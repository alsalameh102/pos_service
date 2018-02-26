/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satlujwe_pos;

import config.Constant;
import config.SysProp;

import java.text.ParseException;
import java.util.ArrayList;

import com.pos.satlujwe.PosGW.connection.SoapConnectionPOS;
import config.SysPropConn;
import java.util.Enumeration;
import java.util.Properties;
import objects.AppSettingOBJ;


import objects.CartItemOBJ;
import objects.HeldItemsOBJ;
import objects.HoldTransactionOBJ;
import objects.ProductOBJ;
import objects.SoldItemOBJ;
import objects.TransactionOBJ;
import objects.UserOBJ;
import utils.CodeGenerator;
import utils.Numbers;


/**
 *
 * @author ETDelacruz
 */
public class LogicControl {
    
    private UserOBJ currentUser;
    private TransactionOBJ currentTrans;
    private ArrayList<CartItemOBJ> cart;
   
    private Numbers num;
    
    private int orderNo = 0;
    private int entryJob, entryBreak;	
    private String currInvoiceNum;
    private String currHeldID = "";
    private String currUPC = "";
    
    public static SysProp sysProp = new SysProp();
    public SysPropConn sysPropConn;
    private SoapConnectionPOS conn;
    
    public LogicControl(){

        cart = new ArrayList();
        conn = new SoapConnectionPOS();
        
        currentTrans = new TransactionOBJ();
        currentTrans.setWasHeld(Constant.WAS_HELD_NO);
        num = new Numbers();
        
        currentTrans.setInvoiceNum(currInvoiceNum);

        
        sysPropConn = new SysPropConn(conn);    
        sysPropConn.initAppProperties();
        this.currInvoiceNum = getInvoiceNumber();
    }
    
    public String getInvoiceNumber(){
        
        StringBuilder sb = new StringBuilder();
        long timeNow = System.currentTimeMillis();
        //String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date(timeNow));
        
        sb.append(getAppProperties().getProperty(Constant.RECEIPT_INVOICEPREF));
        sb.append(timeNow);
    
        return sb.toString();
    }
    
    
    public SysProp getProperties(){
        return sysProp;
    }
    
    //appsettings - 2018-01-20 Ericko
    public Properties getAppProperties(){
        return sysPropConn.getAppProp();
    }
    
    public void refreshAppProperties(){
        sysPropConn.initAppProperties();
    }
    
    public boolean updateAppProperties(Properties prop){
        ArrayList<AppSettingOBJ> list = new ArrayList<>();
        Enumeration e = prop.propertyNames();
        while(e.hasMoreElements()){
            AppSettingOBJ setting = new AppSettingOBJ();
            String key = e.nextElement().toString();
            setting.setSettingName(key);
            setting.setSettingValue(prop.getProperty(key));
            list.add(setting);
        }
        
        return sysPropConn.updateAppProperties(list);
    }
    
    //timekeeping
    public int getEntryJob() {
        return entryJob;
    }

    public void setEntryJob(int entryJob) {
        this.entryJob = entryJob;
    }

    public int getEntryBreak() {
        return entryBreak;
    }

    public void setEntryBreak(int entryBreak) {
        this.entryBreak = entryBreak;
    }
    
    public boolean createNewTimeRecord(){
    	    	
    	
        if(this.conn.getEntryRecordJobCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()) == 0){
            if(this.conn.insertTimeRecordCommand(this.getCurrentUser(), sysProp.getInstance().getProperty(Constant.DBNAME).toString())){
                setEntryJob(this.conn.getEntryRecordJobCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()));
                return true;
            }
        }
        return false;
    }
    
    public boolean updateTimeRecord(){
        if(this.conn.getEntryRecordJobCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()) != 0){
        	return this.conn.updateTimeRecordCommand(entryJob, sysProp.getInstance().getProperty(Constant.DBNAME).toString());
            //return this.cm.updateTimeRecord(entryJob);
        }
        return false;
    }  
    
    public boolean createNewBreakRecord(){
        if(this.conn.getEntryRecordJobCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()) != 0){
            if(this.conn.getEntryRecordBreakCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()) == 0){
                if(this.conn.insertBreakRecordCommand(getCurrentUser(), sysProp.getInstance().getProperty(Constant.DBNAME).toString())){
                    setEntryBreak(this.conn.getEntryRecordBreakCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()));
                    return true;
                }
            }   
        }
        return false;
    }
    
    public boolean updateBreakRecord(){
        if(this.conn.getEntryRecordJobCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()) != 0){
            if(this.conn.getEntryRecordBreakCommand(this.currentUser.getUserid(), sysProp.getInstance().getProperty(Constant.DBNAME).toString()) != 0){
            	return this.conn.updateBreakRecordCommand(entryBreak, sysProp.getInstance().getProperty(Constant.DBNAME).toString());
            	//return this.cm.updateBreakRecord(entryBreak);
            }
        }
        return false;
    }
    
    //------- product/inventory functions

    public Numbers getConverter(){
        return num;
    }
    
    public ArrayList<ProductOBJ> getInventory(){
        return this.conn.getInventoryCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString());
    }
    
    public void emptyCart(){
        cart.clear();
    }
    
    public void updateCartItem(ProductOBJ p, int qty, boolean update){
       
        int newQty = 0;
        boolean found  = false;
        
            for (CartItemOBJ it : cart){
                if(it.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){
                    found = true;
                    if(!update){
                        newQty = it.getQuantity() + qty;
                    }
                    else{
                        newQty = qty;
                    }
                    if(newQty == 0){
                        cart.remove(it);
                    }
                    else{
                        it.setQuantity(newQty);
                        it.setTotalPrice(Numbers.getTaxedUnitPrice(p.getPURCHASE_PRICE(), Double.parseDouble(p.getTAX().replace("%", ""))) * newQty );
                    }
                    break;
                }
            }
            
            if(!found){
                    CartItemOBJ item = new CartItemOBJ();
                    item.setItemCode(p.getITEM_CODE());
                    item.setDesc(p.getPRODUCT_NAME());
                    item.setQuantity(qty);
                    item.setInvoiceNum(this.getCurrInvoiceNum());
                    item.setTotalPrice(Numbers.getTaxedUnitPrice(p.getPURCHASE_PRICE(), Double.parseDouble(p.getTAX().replace("%", ""))) * qty);
                    item.setTaxable(p.getTAXABLE());
                    item.setOrderNo(orderNo++);
                    cart.add(item);
            }
        
    }
    
    
    public boolean addToCartbyCode(String upc, int qty){
    
        boolean found = false;
        for (ProductOBJ p : getInventory()){
                if(p.getITEM_CODE().equalsIgnoreCase(upc)){
                   found = true;
                   updateCartItem(p, qty, false);
                   Main.control.updateRegisterTable();
                   Main.control.closeSearch();
                   return found;
                }
        }
        
        return found;
        
    }
    
    public void loadCartItemFromPending(ArrayList<HeldItemsOBJ> pendingItems){
       
        int newQty = 0;
        this.cart.clear();
        
            for (HeldItemsOBJ hi : pendingItems){
                for(ProductOBJ p : this.getInventory()){
                    if(hi.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){

                        CartItemOBJ item = new CartItemOBJ();
                        item.setItemCode(p.getITEM_CODE());
                        item.setDesc(p.getPRODUCT_NAME());
                        item.setQuantity(hi.getQty());
                        item.setTotalPrice(Numbers.getTaxedUnitPrice(p.getPURCHASE_PRICE(), Double.parseDouble(p.getTAX().replace("%", ""))) * hi.getQty());
                        item.setTaxable(p.getTAXABLE());
                        item.setOrderNo(orderNo++);
                        cart.add(item);

                        break;
                    }
                }
                
            }       
    }
    
    public void loadCart(String heldID){
        //loadCartItemFromPending(this.tm.getHeldItems(heldID));
        try {
			loadCartItemFromPending(this.conn.getHeldItemsCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString(), heldID));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Main.control.showErrorMessage(e.getMessage());
		}
    }
    
    public void removeCartItem(ProductOBJ p){
        
        for (CartItemOBJ it : cart){
                if(it.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){
                    cart.remove(it);
                    break;
                }
            }
    
    }
    
    public boolean updateInventory(String invoiceNum){
        
        SoldItemOBJ si;
        for (CartItemOBJ it: cart){
            for(ProductOBJ p: this.getInventory()){
                if(it.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){
                    si = new SoldItemOBJ();
                    si.setId(p.getID());
                    si.setInvoiceNum(invoiceNum);
                    si.setItemCode(p.getITEM_CODE());
                    si.setProdName(p.getPRODUCT_NAME());
                    si.setPurchasePrice(it.getTotalPrice());
                    si.setQty(it.getQuantity());
                    si.setRemarks(this.currentUser.getUsername());
                    si.setSku(p.getSKU());
                    if(this.conn.insertSoldItemCommand(si, sysProp.getInstance().getProperty(Constant.DBNAME).toString())){
                        
                    }
                    else {
                    	
                    }
                    
                    break;
                }
            }
        }
        
        return false;
    }
    
    public ArrayList<CartItemOBJ> getCart(){
        return cart;
    }
    
    
    //transaction functions
    
    public String getCurrInvoiceNum() {
        return currInvoiceNum;
    }
    
    public void setInvoiceNum(String in){
        this.currInvoiceNum = in; 
    }
    
    public void updateInvoiceNum(){
        this.currInvoiceNum = CodeGenerator.getInvoiceNumber();
    }
    
    public TransactionOBJ getCurrentTrans(){
        return this.currentTrans;
    }
    
    public void resetCurrentTrans(){
        this.currentTrans = null;
        this.currentTrans = new TransactionOBJ();
    }
    
    public boolean insertTrans(){
        if(!this.currentTrans.isHasBalance()){
            updateInventory(this.currentTrans.getInvoiceNum());
        }
        return this.conn.makeSaleCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString(), this.getCart(), this.currentTrans);
    }
    
    
    public boolean checkHeldTransactions(){

        return this.conn.checkHeldTransCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString());
    }

    
    public boolean checkifHeldTransactionExisting(String holdID){
        
        return this.conn.checkHeldTransExistingCommand(holdID, sysProp.getInstance().getProperty(Constant.DBNAME).toString());
    }
    
    public ArrayList<HoldTransactionOBJ> getPendingTrans(){
        try {
			return this.conn.getPendingTransCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Main.control.showErrorMessage(e.getMessage());
		}
        return null;
    }
    
    
    public boolean holdTransaction(HoldTransactionOBJ ht){
        
        boolean success = false;
        if(this.conn.insertholdTransCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString(), ht)){
            
            for (CartItemOBJ ci : cart){
                HeldItemsOBJ hi = new HeldItemsOBJ();
                hi.setHeldID(ht.getheldID());
                hi.setItemCode(ci.getItemCode());
                hi.setQty(ci.getQuantity());
                hi.setStatus(Constant.HELD_TRANS_OPEN);
                
                if(this.conn.insertheldItemCommand(hi, sysProp.getInstance().getProperty(Constant.DBNAME).toString())){
                    success = true;
                }
                else {
                    success = false;
                }
            }
            return success;
        }
        
        return success;
    }
    
    
    public boolean cancelPending(String heldID){
        
        return this.conn.cancelPendingCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString(), heldID);
    }
    
    public boolean openCancelled(String heldID){
    
        return this.conn.openCancelledCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString(), heldID);
    }
    
    public boolean closePending(String heldID){
    
        return this.conn.closePendingCommand(sysProp.getInstance().getProperty(Constant.DBNAME).toString(), heldID);
    }
    
    public boolean getUser(String username, String password){
    	UserOBJ user = this.conn.validateUserCommand(username, password, sysProp.getInstance().getProperty(Constant.DBNAME).toString());
    	if( user != null){
    		this.setCurrentUser(user);
    		return true;
    	}
    	return false;
    }
    
    //---------------------
    // user functions
    
    public UserOBJ getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserOBJ currentUser) {
        this.currentUser = currentUser;
    }
    
    public void resetAll(){
        setCurrentUser(null);
        
    }
    

    public String getCurrHeldID() {
        return currHeldID;
    }

    public void setCurrHeldID(String currHeldID) {
        this.currHeldID = currHeldID;
    }

    public String getCurrUPC() {
        return currUPC;
    }

    public void setCurrUPC(String currUPC) {
        this.currUPC = currUPC;
    }

}

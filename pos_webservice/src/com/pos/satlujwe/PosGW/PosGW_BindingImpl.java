/**
 * PosGW_BindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;


import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pos.satlujwe.PosGW.CancelTransactionRequest;
import com.pos.satlujwe.PosGW.CancelTransactionResponse;
import com.pos.satlujwe.PosGW.CheckExistingHeldTRequest;
import com.pos.satlujwe.PosGW.CheckExistingHeldTResponse;
import com.pos.satlujwe.PosGW.CheckHeldTRequest;
import com.pos.satlujwe.PosGW.CheckHeldTResponse;
import com.pos.satlujwe.PosGW.CheckUserRequest;
import com.pos.satlujwe.PosGW.CheckUserResponse;
import com.pos.satlujwe.PosGW.ClosePendingTRequest;
import com.pos.satlujwe.PosGW.ClosePendingTResponse;
import com.pos.satlujwe.PosGW.CreateTKRequest;
import com.pos.satlujwe.PosGW.CreateTKResponse;
import com.pos.satlujwe.PosGW.GetEntryRBRequest;
import com.pos.satlujwe.PosGW.GetEntryRBResponse;
import com.pos.satlujwe.PosGW.GetEntryRJRequest;
import com.pos.satlujwe.PosGW.GetEntryRJResponse;
import com.pos.satlujwe.PosGW.GetHeldItemsRequest;
import com.pos.satlujwe.PosGW.GetHeldTRequest;
import com.pos.satlujwe.PosGW.GetInventoryRequest;
import com.pos.satlujwe.PosGW.InsertBRRequest;
import com.pos.satlujwe.PosGW.InsertBRResponse;
import com.pos.satlujwe.PosGW.InsertHeldItemRequest;
import com.pos.satlujwe.PosGW.InsertHeldItemResponse;
import com.pos.satlujwe.PosGW.InsertHeldTRequest;
import com.pos.satlujwe.PosGW.InsertHeldTResponse;
import com.pos.satlujwe.PosGW.InsertSoldRequest;
import com.pos.satlujwe.PosGW.InsertSoldResponse;
import com.pos.satlujwe.PosGW.InsertTRRequest;
import com.pos.satlujwe.PosGW.InsertTRResponse;
import com.pos.satlujwe.PosGW.MakeSaleRequest;
import com.pos.satlujwe.PosGW.MakeSaleResponse;
import com.pos.satlujwe.PosGW.OpenCancelledTRequest;
import com.pos.satlujwe.PosGW.OpenCancelledTResponse;
import com.pos.satlujwe.PosGW.PosGWHoldItem;
import com.pos.satlujwe.PosGW.PosGWHoldTransaction;
import com.pos.satlujwe.PosGW.PosGWProduct;
import com.pos.satlujwe.PosGW.PosGW_PortType;
import com.pos.satlujwe.PosGW.SearchInventoryRequest;
import com.pos.satlujwe.PosGW.SearchInventoryResponse;
import com.pos.satlujwe.PosGW.UpdateBRRequest;
import com.pos.satlujwe.PosGW.UpdateBRResponse;
import com.pos.satlujwe.PosGW.UpdateInventoryRequest;
import com.pos.satlujwe.PosGW.UpdateInventoryResponse;
import com.pos.satlujwe.PosGW.UpdateTRRequest;
import com.pos.satlujwe.PosGW.UpdateTRResponse;

import db.TimeKeepingManager;
import db.DBFactory;
import db.InventoryManager;
import db.TransactionManager;
import db.UserValidation;
import db.dao.AppSettingsDAO;
import db.dao.InventoryDAO;
import db.dao.ReturnItemDAO;
import db.dao.TimeKeepingDAO;
import db.dao.TransactionsDAO;
import db.dao.UserDAO;
import db.dao.VoidInvoiceDAO;
import objects.AppSettingOBJ;
import objects.CartItemOBJ;
import objects.HeldItemsOBJ;
import objects.HoldTransactionOBJ;
import objects.ProductOBJ;
import objects.ReturnItemOBJ;
import objects.SoldItemOBJ;
import objects.TransactionOBJ;
import objects.UserOBJ;
import objects.VoidInvoiceOBJ;
import utils.POSCalendar;

//@WebService(serviceName = "PosGW_Port", portName = "PosGW_Port", endpointInterface = "com.pos.satlujwe.PosGW.PosGW_PortType",
//targetNamespace = "http://satlujwe.pos.com/PosGW", wsdlLocation = "WEB-INF/wsdl/PosGW_Port.wsdl")

public class PosGW_BindingImpl implements com.pos.satlujwe.PosGW.PosGW_PortType{
	
	private static final Log log = LogFactory.getLog(PosGW_BindingImpl.class);

    public com.pos.satlujwe.PosGW.InsertTRResponse TK_InsertTR(com.pos.satlujwe.PosGW.InsertTRRequest parameters) throws java.rmi.RemoteException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
        TimeKeepingDAO timeKeepingTemplate = (TimeKeepingDAO)context.getBean("timekeepingTemplate");
        
    	InsertTRResponse itrresponse = new InsertTRResponse();
    	UserOBJ user = new UserOBJ();
    	user.setUserid(parameters.getCurrentUser().getUserID());
    	user.setFirstname(parameters.getCurrentUser().getFirstName());
    	user.setLastname(parameters.getCurrentUser().getLastName());
    	user.setUsername(parameters.getCurrentUser().getUsername());
    	
    	itrresponse.setIsSuccess(timeKeepingTemplate.createTimeRecord(user));
    	
    	System.out.println("After itrresponse setIsSuccess");
    	
        return itrresponse;
    }

    public com.pos.satlujwe.PosGW.UpdateTRResponse TK_UpdateTR(com.pos.satlujwe.PosGW.UpdateTRRequest parameters) throws java.rmi.RemoteException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
        TimeKeepingDAO timeKeepingTemplate = (TimeKeepingDAO)context.getBean("timekeepingTemplate");
    	UpdateTRResponse utrresponse = new UpdateTRResponse();
    	utrresponse.setIsSuccess(timeKeepingTemplate.updateTimeRecord(parameters.getEntryID()));
    	
        return utrresponse;
    }

    public com.pos.satlujwe.PosGW.InsertBRResponse TK_InsertBR(com.pos.satlujwe.PosGW.InsertBRRequest parameters) throws java.rmi.RemoteException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
        TimeKeepingDAO timeKeepingTemplate = (TimeKeepingDAO)context.getBean("timekeepingTemplate");
    	InsertBRResponse ibrresponse = new InsertBRResponse();
    	UserOBJ user = new UserOBJ();
    	user.setUserid(parameters.getCurrentUser().getUserID());
    	user.setFirstname(parameters.getCurrentUser().getFirstName());
    	user.setLastname(parameters.getCurrentUser().getLastName());
    	user.setUsername(parameters.getCurrentUser().getUsername());
    	ibrresponse.setIsSuccess(timeKeepingTemplate.createBreakRecord(user));
    	
        return ibrresponse;
    }

    public com.pos.satlujwe.PosGW.UpdateBRResponse TK_UpdateBR(com.pos.satlujwe.PosGW.UpdateBRRequest parameters) throws java.rmi.RemoteException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
        TimeKeepingDAO timeKeepingTemplate = (TimeKeepingDAO)context.getBean("timekeepingTemplate");
    	UpdateBRResponse ubrresponse = new UpdateBRResponse();
    	ubrresponse.setIsSuccess(timeKeepingTemplate.updateBreakRecord(parameters.getEntryID()));
    	
        return ubrresponse;
    }

    public com.pos.satlujwe.PosGW.GetEntryRJResponse TK_GetRJEntry(com.pos.satlujwe.PosGW.GetEntryRJRequest parameters) throws java.rmi.RemoteException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
        TimeKeepingDAO timeKeepingTemplate = (TimeKeepingDAO)context.getBean("timekeepingTemplate");
    	GetEntryRJResponse gerjresponse = new GetEntryRJResponse();
    	gerjresponse.setEntryID(timeKeepingTemplate.entryTimeRecord(parameters.getUserID()));
    	
        return gerjresponse;
    }

    public com.pos.satlujwe.PosGW.GetEntryRBResponse TK_GetEntryRB(com.pos.satlujwe.PosGW.GetEntryRBRequest parameters) throws java.rmi.RemoteException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
        TimeKeepingDAO timeKeepingTemplate = (TimeKeepingDAO)context.getBean("timekeepingTemplate");
    	GetEntryRBResponse gerbresponse = new GetEntryRBResponse();
    	gerbresponse.setEntryID(timeKeepingTemplate.entryBreakRecord(parameters.getUserID()));
    	
        return gerbresponse;
    }

    public com.pos.satlujwe.PosGW.PosGWProduct[] getInventory(com.pos.satlujwe.PosGW.GetInventoryRequest parameters) throws java.rmi.RemoteException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	InventoryDAO inventoryTemplate = (InventoryDAO)context.getBean("inventoryTemplate");
    	ArrayList<ProductOBJ> inv = (ArrayList<ProductOBJ>) inventoryTemplate.listProducts();
    	System.out.println("Before conversion");
    	PosGWProduct[] inventorylist = new PosGWProduct[inv.size()];
    	
    	for(int i = 0; i < inv.size(); i++){
    		//System.out.println("Iteration");
    		inventorylist[i] = new PosGWProduct();
    		inventorylist[i].setAisle(inv.get(i).getAISLE());
    		//System.out.println("After Aisle");
    		inventorylist[i].setCoupon(inv.get(i).getCOUPON());
    		//System.out.println("After Coupon");
    		inventorylist[i].setCreatedAt(inv.get(i).getCREATED_AT().toString());
    		//System.out.println("After Created At");
    		inventorylist[i].setID(inv.get(i).getID());
    		//System.out.println("After ID");
    		inventorylist[i].setItemCode(inv.get(i).getITEM_CODE());
    		//System.out.println("After Item Code");
    		inventorylist[i].setPerishable(inv.get(i).getPERISHABLE());
    		//System.out.println("After Perishable");
    		inventorylist[i].setProductIMG(inv.get(i).getPRODUCT_IMG());
    		//System.out.println("After product image");
    		inventorylist[i].setProductName(inv.get(i).getPRODUCT_NAME());
    		//System.out.println("After product name");
    		inventorylist[i].setPurchasePrice(BigDecimal.valueOf(inv.get(i).getPURCHASE_PRICE()));
    		//System.out.println("After purchase price");
    		inventorylist[i].setQtyOnFloor(inv.get(i).getQUANTITY_ON_FLOOR());
    		//System.out.println("After Qty on flr");
    		inventorylist[i].setQtyOffFloor(inv.get(i).getQUANTITY_OFF_FLOOR());
    		//System.out.println("After Qty Off Flr");
    		inventorylist[i].setRemarks(inv.get(i).getREMARKS());
    		//System.out.println("After Remarts");
    		inventorylist[i].setRetailPrice(BigDecimal.valueOf(inv.get(i).getRETAIL_PRICE()));
    		//System.out.println("After retail price");
    		inventorylist[i].setShelfLifeOffFloor(inv.get(i).getSHELF_LIFE_OFF_FLOOR());
    		//System.out.println("After shelf life off flr");
    		inventorylist[i].setShelfLifeOnFloor(inv.get(i).getSHELF_LIFE_ON_FLOOR());
    		//System.out.println("After shelf life on flr");
    		inventorylist[i].setSKU(inv.get(i).getSKU());
    		//System.out.println("After SKU");
    		inventorylist[i].setSubCategory(inv.get(i).getSUB_CATEGORY());
    		//System.out.println("After sub cat");
    		inventorylist[i].setTaxable(inv.get(i).getTAXABLE());
    		//System.out.println("After taxable");
    		inventorylist[i].setTax(inv.get(i).getTAX());
    		
    		inventorylist[i].setUpdatedAt("");
    		//System.out.println("After updated at");
    		inventorylist[i].setVendor(inv.get(i).getVENDOR());
    		//System.out.println("After vendor");
    		//System.out.println(i + " : " + inv.get(i).getPRODUCT_NAME());
    		
    	}
    	
        return inventorylist;
    }

    public com.pos.satlujwe.PosGW.UpdateInventoryResponse updateInventory(com.pos.satlujwe.PosGW.UpdateInventoryRequest parameters) throws java.rmi.RemoteException {
    	InventoryManager inventory = new InventoryManager();
    	UpdateInventoryResponse uiresponse = new UpdateInventoryResponse();
    	uiresponse.setIsSuccess(inventory.updateInventory(parameters.getItemCode(), parameters.getStock().intValue(), parameters.getInventorySpace()));
    	
        return uiresponse;
    }

    public com.pos.satlujwe.PosGW.SearchInventoryResponse searchInventory(com.pos.satlujwe.PosGW.SearchInventoryRequest parameters) throws java.rmi.RemoteException {
    	
    	//SearchInventoryResponse siresponse = new SearchInventoryResponse();
    	//Product prod = inventory.searchInventoryByName("");
    	
        return null;
    }

    public com.pos.satlujwe.PosGW.InsertSoldResponse insertSold(com.pos.satlujwe.PosGW.InsertSoldRequest parameters) throws java.rmi.RemoteException {
    	InventoryManager inventory = new InventoryManager();
    	InsertSoldResponse isresponse = new InsertSoldResponse();
    	
    	SoldItemOBJ si = new SoldItemOBJ();
    	si.setId(parameters.getItemsSold().getID());
    	si.setInvoiceNum(parameters.getItemsSold().getInvoiceNum());
    	si.setItemCode(parameters.getItemsSold().getItemCode());
    	si.setProdName(parameters.getItemsSold().getProdName());
    	si.setPurchasePrice(parameters.getItemsSold().getPurchasePrice().doubleValue());
    	si.setQty(parameters.getItemsSold().getQty());
    	si.setRemarks(parameters.getItemsSold().getRemarks());
    	si.setSku(parameters.getItemsSold().getSku());
    	//si.setSoldDate(new Date(parameters.getItemsSold().getSoldDate()));
    	
    	isresponse.setIsSuccess(inventory.insertSold(si, parameters.getInventorySpace()));
    	
        return isresponse;
    }

    public com.pos.satlujwe.PosGW.MakeSaleResponse makeSale(com.pos.satlujwe.PosGW.MakeSaleRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	MakeSaleResponse msResponse = new MakeSaleResponse();
    	
    	ArrayList<CartItemOBJ> items = new ArrayList<CartItemOBJ>();
    	TransactionOBJ trans = new TransactionOBJ();
    	
    	for (int i = 0; i < parameters.getItems().length; i++){
    		
    		CartItemOBJ item = new CartItemOBJ();
    		item.setDesc(parameters.getItems(i).getDesc());
    		item.setInvoiceNum(parameters.getItems(i).getInvoiceNum());
    		item.setItemCode(parameters.getItems(i).getItemCode());
    		item.setOrderNo(parameters.getItems(i).getOrderNo());
    		item.setQuantity(parameters.getItems(i).getQty());
    		item.setTotalPrice(parameters.getItems(i).getTotalPrice().doubleValue());
    		items.add(item);
    		
    	}
    	
    	trans.setBalance(parameters.getSale().getBalance().doubleValue());
    	trans.setCashier(parameters.getSale().getCashier());
    	trans.setCashTendered(parameters.getSale().getCashTendered().doubleValue());
    	trans.setChange(parameters.getSale().getChange().doubleValue());
    	//trans.setHasBalance(parameters.getSale().get);
    	trans.setId(parameters.getSale().getID());
    	trans.setInvoiceNum(parameters.getSale().getInvoiceNum());
    	trans.setMonth(parameters.getSale().getMonth());
    	trans.setName(parameters.getSale().getName());
    	trans.setSubTotal(parameters.getSale().getSubTotal().doubleValue());
    	//trans.setTimeStamp(new Date(parameters.getSale().getTimeStamp()));
    	trans.setTotalAmount(parameters.getSale().getTotalAmount().doubleValue());
    	trans.setType(parameters.getSale().getType());
    	trans.setVat(parameters.getSale().getVAT());
    	trans.setWasHeld(parameters.getSale().getWasHeld());
    	trans.setYear(parameters.getSale().getYear());
    	
    	msResponse.setIsSuccess(transactionTemplate.txmakeSale(trans, items));
    	
    	
        return msResponse;
    }

    public com.pos.satlujwe.PosGW.PosGWTransaction[] getTransactions(com.pos.satlujwe.PosGW.GetTransactionsRequest parameters) throws java.rmi.RemoteException {
        return null;
    }

	public com.pos.satlujwe.PosGW.CheckHeldTResponse checkHeld(com.pos.satlujwe.PosGW.CheckHeldTRequest parameters) throws java.rmi.RemoteException {
    	
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	CheckHeldTResponse chresponse = new CheckHeldTResponse();
    	chresponse.setIsSuccess(transactionTemplate.checkHeldTransactions());
    	
        return chresponse;
    }

    public com.pos.satlujwe.PosGW.CheckExistingHeldTResponse checkExistingHeld(com.pos.satlujwe.PosGW.CheckExistingHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	CheckExistingHeldTResponse cehtresponse = new CheckExistingHeldTResponse();
    	cehtresponse.setIsSuccess(transactionTemplate.checkifHeldTransactionExisting(parameters.getHeldID()));
    	
        return cehtresponse;
    }

    public com.pos.satlujwe.PosGW.InsertHeldTResponse insertHeld(com.pos.satlujwe.PosGW.InsertHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	InsertHeldTResponse ihtresponse = new InsertHeldTResponse();
    	HoldTransactionOBJ ht = new HoldTransactionOBJ();
    	//ht.setCreatedAt(new Date(parameters.getHeldTrans().getCreatedAt()));
    	ht.setheldID(parameters.getHeldTrans().getHeldID());
    	ht.setId(parameters.getHeldTrans().getID());
    	ht.setInvoice(parameters.getHeldTrans().getInvoiceNum());
    	ht.setLoggedBy(parameters.getHeldTrans().getLoggedby());
    	ht.setStatus(parameters.getHeldTrans().getStatus());
    	ht.setUserid(parameters.getHeldTrans().getUserID());
    	
    	ihtresponse.setIsSuccess(transactionTemplate.insertHeldTransaction(ht));
    	
        return ihtresponse;
    }

    public com.pos.satlujwe.PosGW.PosGWHoldTransaction[] getHeld(com.pos.satlujwe.PosGW.GetHeldTRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	System.out.println("Before get held trans");
    	ArrayList<HoldTransactionOBJ> pending = transactionTemplate.getHeldTransactions();
    	System.out.println("After get held trans");
    	PosGWHoldTransaction[] held = new PosGWHoldTransaction[pending.size()];
    	for (int i = 0; i < pending.size(); i++){
    		held[i] = new PosGWHoldTransaction();
    		
    		held[i].setCreatedAt(POSCalendar.DatetoString(pending.get(i).getCreatedAt()));
    		//System.out.println("Before created at");
    		held[i].setHeldID(pending.get(i).getheldID());
    		//System.out.println("Before held id");
    		held[i].setID(pending.get(i).getId());
    		//System.out.println("Before id");
    		held[i].setInvoiceNum(pending.get(i).getInvoice());
    		//System.out.println("Before invoice num");
    		held[i].setLoggedby(pending.get(i).getLoggedBy());
    		//System.out.println("Before logged by");
    		held[i].setSoldAt("");
    		//System.out.println("Before sold at");
    		held[i].setStatus(pending.get(i).getStatus());
    		//System.out.println("Before status");
    		held[i].setUserID(pending.get(i).getUserid());
    		//System.out.println("Before user id");
    		
    	}
    	
        return held;
    }

    public com.pos.satlujwe.PosGW.PosGWHoldItem[] getHeldItems(com.pos.satlujwe.PosGW.GetHeldItemsRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	ArrayList<HeldItemsOBJ> items = transactionTemplate.getHeldItems(parameters.getHeldID());
    	PosGWHoldItem[] HeldItemsOBJ = new PosGWHoldItem[items.size()];
    	
    	System.out.println("HELD ITEM SIZE: "+items.size());
    	
    	for (int i = 0; i < items.size(); i++){
    		
    		HeldItemsOBJ[i] = new PosGWHoldItem();
    		HeldItemsOBJ[i].setCreatedAt(POSCalendar.DatetoString(items.get(i).getCreatedAt()));
    		HeldItemsOBJ[i].setHeldID(items.get(i).getHeldID());
    		HeldItemsOBJ[i].setItemCode(items.get(i).getItemCode());
    		HeldItemsOBJ[i].setQty(items.get(i).getQty());
    		HeldItemsOBJ[i].setStatus(items.get(i).getStatus());
    		
    	}
    	
        return HeldItemsOBJ;
    }

    public com.pos.satlujwe.PosGW.InsertHeldItemResponse insertHeldItems(com.pos.satlujwe.PosGW.InsertHeldItemRequest parameters) throws java.rmi.RemoteException {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	InsertHeldItemResponse ihiresponse = new InsertHeldItemResponse();
    	HeldItemsOBJ hi = new HeldItemsOBJ();
    	//hi.setCreatedAt(new Date(parameters.getHeldItem().getCreatedAt()));
    	hi.setHeldID(parameters.getHeldItem().getHeldID());
    	hi.setItemCode(parameters.getHeldItem().getItemCode());
    	hi.setQty(parameters.getHeldItem().getQty());
    	hi.setStatus(parameters.getHeldItem().getStatus());
    	
    	ihiresponse.setIsSuccess(transactionTemplate.insertHeldItem(hi));
    	
    	return ihiresponse;
    }

    public com.pos.satlujwe.PosGW.CancelTransactionResponse cancelTransaction(com.pos.satlujwe.PosGW.CancelTransactionRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	CancelTransactionResponse ctresponse = new CancelTransactionResponse();
    	ctresponse.setIsSuccess(transactionTemplate.txcancelTransaction(parameters.getHeldID()));
    	
        return ctresponse;
    }

    public com.pos.satlujwe.PosGW.OpenCancelledTResponse openCancelled(com.pos.satlujwe.PosGW.OpenCancelledTRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	OpenCancelledTResponse ocresponse = new OpenCancelledTResponse();
    	ocresponse.setIsSuccess(transactionTemplate.txopenCancelledTransaction(parameters.getHeldID()));
    	
        return ocresponse;
    }

    public com.pos.satlujwe.PosGW.ClosePendingTResponse closePending(com.pos.satlujwe.PosGW.ClosePendingTRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	TransactionsDAO transactionTemplate = (TransactionsDAO)context.getBean("transactionTemplate");
    	ClosePendingTResponse cpresponse = new ClosePendingTResponse();
    	cpresponse.setIsSuccess(transactionTemplate.txclosePendingTransaction(parameters.getHeldID()));
    	
        return cpresponse;
    }

    public com.pos.satlujwe.PosGW.CheckUserResponse userValidation(com.pos.satlujwe.PosGW.CheckUserRequest parameters) throws java.rmi.RemoteException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	UserDAO userTemplate = (UserDAO)context.getBean("userTemplate");
    	CheckUserResponse curesponse = new CheckUserResponse();
    	UserOBJ user = userTemplate.getUserIfExisting(parameters.getUserName(), parameters.getPassword());
    	if(user != null){
    		PosGWUser puser = new PosGWUser();
    		puser.setActivationKey(user.getActivationKey());
    		puser.setDateCreated(user.getDateCreated());
    		puser.setEmail(user.getEmail());
    		puser.setEmailStatus(user.getEmailStatus());
    		puser.setFirstName(user.getFirstname());
    		puser.setLastName(user.getLastname());
    		puser.setPassword(user.getPassword());
    		puser.setResetKey(user.getResetKey());
    		puser.setRole(user.getRole());
    		puser.setUserID(user.getUserid());
    		puser.setUsername(user.getUsername());
    		puser.setUserStatus(user.getUserStat());
    		curesponse.setUser(puser);
    	}
    	
        return curesponse;
    }

	public com.pos.satlujwe.PosGW.PosGWAppSetting[] getAllSettings(com.pos.satlujwe.PosGW.GetAllSettingsRequest parameters) throws java.rmi.RemoteException {
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
		System.out.println("PosGW.PosGWAppSetting after application context");
    	AppSettingsDAO appSettingsTemplate = (AppSettingsDAO)context.getBean("appSettingsTemplate");
    	System.out.println("PosGW.PosGWAppSetting after appsettingsdao");
    	ArrayList<AppSettingOBJ> settings = (ArrayList<AppSettingOBJ>) appSettingsTemplate.listSettings();
    	
    	System.out.println("PosGW.PosGWAppSetting after query");
    	
    	PosGWAppSetting[] appsettings = new PosGWAppSetting[settings.size()];
    	
    	for (int i = 0; i < settings.size(); i++){
    		appsettings[i] = new PosGWAppSetting();
    		appsettings[i].setId(settings.get(i).getId());
    		appsettings[i].setSettingName(settings.get(i).getSettingName());
    		appsettings[i].setSettingDesc(settings.get(i).getSettingDescription());
    		appsettings[i].setSettingValue(settings.get(i).getSettingValue());
    		
    	}
    	
    	System.out.println("PosGW.PosGWAppSetting before return");
    	
        return appsettings;
    }

	public com.pos.satlujwe.PosGW.PosGWAppSetting[] getReceiptSettings(com.pos.satlujwe.PosGW.GetReceiptSettingsRequest parameters) throws java.rmi.RemoteException {
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	AppSettingsDAO appSettingsTemplate = (AppSettingsDAO)context.getBean("appSettingsTemplate");
    	ArrayList<AppSettingOBJ> settings = (ArrayList<AppSettingOBJ>) appSettingsTemplate.receiptSettings();
    	
    	PosGWAppSetting[] appsettings = new PosGWAppSetting[settings.size()];
    	
    	for (int i = 0; i < settings.size(); i++){
    		appsettings[i] = new PosGWAppSetting();
    		appsettings[i].setId(settings.get(i).getId());
    		appsettings[i].setSettingName(settings.get(i).getSettingName());
    		appsettings[i].setSettingDesc(settings.get(i).getSettingDescription());
    		appsettings[i].setSettingValue(settings.get(i).getSettingValue());
    		
    	}
    	
        return appsettings;
    }

	public com.pos.satlujwe.PosGW.ChangeSettingResponse changeSetting(com.pos.satlujwe.PosGW.ChangeSettingRequest parameters) throws java.rmi.RemoteException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	AppSettingsDAO appSettingsTemplate = (AppSettingsDAO)context.getBean("appSettingsTemplate");
    	ChangeSettingResponse csr = new ChangeSettingResponse();
    	
    	ArrayList<AppSettingOBJ> updateList = new ArrayList<AppSettingOBJ>();
    	
    	for(int i = 0; i < parameters.getReceiptSettings().length; i++){
    		AppSettingOBJ setting = new AppSettingOBJ();
    		setting.setId(parameters.getReceiptSettings()[i].getId());
    		setting.setSettingDescription(parameters.getReceiptSettings()[i].getSettingDesc());
    		setting.setSettingName(parameters.getReceiptSettings()[i].getSettingName());
    		setting.setSettingValue(parameters.getReceiptSettings()[i].getSettingValue());
    		updateList.add(setting);
    	}
    	
    	csr.setIsSuccess(appSettingsTemplate.update(updateList)); 
		
        return csr;
    }

	public com.pos.satlujwe.PosGW.InsertReturnItemResponse insertReturnItem(com.pos.satlujwe.PosGW.InsertReturnItemRequest parameters) throws java.rmi.RemoteException {
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	ReturnItemDAO returnItemTemplate = (ReturnItemDAO)context.getBean("returnItemTemplate");
    	InsertReturnItemResponse irr = new InsertReturnItemResponse();
    	
    	ReturnItemOBJ ri = new ReturnItemOBJ();
    	ri.setId(Integer.parseInt(parameters.getReturnItem().getReturnID()));
    	ri.setInvoiceNum(parameters.getReturnItem().getInvoiceNum());
    	ri.setItemCode(parameters.getReturnItem().getItemCode());
    	ri.setUserid(Integer.parseInt(parameters.getReturnItem().getUserID()));
    	ri.setLoggedBy(parameters.getReturnItem().getLoggedby());
    	ri.setQty(parameters.getReturnItem().getQty());
    	ri.setStatus(parameters.getReturnItem().getStatus());
    	ri.setCreatedAt(parameters.getReturnItem().getCreatedAt());
    	
    	irr.setIsSuccess(returnItemTemplate.create(ri));
		
		return irr;
    }

	public com.pos.satlujwe.PosGW.VoidInvoiceResponse voidInvoice(com.pos.satlujwe.PosGW.VoidInvoiceRequest parameters) throws java.rmi.RemoteException {
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/POSBeans.xml");
    	VoidInvoiceDAO voidInvoiceTemplate = (VoidInvoiceDAO)context.getBean("voidInvoiceTemplate");
    	VoidInvoiceResponse vir = new VoidInvoiceResponse();
    	
    	VoidInvoiceOBJ vi = new VoidInvoiceOBJ();
    	vi.setId(parameters.getVoidInvoice().getId());
    	vi.setInvoiceNum(parameters.getVoidInvoice().getInvoiceNum());
    	vi.setLoggedBy(parameters.getVoidInvoice().getLoggedby());
    	vi.setStatus(parameters.getVoidInvoice().getStatus());
    	vi.setUserId(Integer.parseInt(parameters.getVoidInvoice().getUserID()));
    	
    	vir.setIsSuccess(voidInvoiceTemplate.create(vi));
        return vir;
    }



}

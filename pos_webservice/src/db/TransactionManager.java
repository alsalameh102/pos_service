/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import config.Constant;
import db.tables.HeldItemDB;
import db.tables.HoldDB;
import db.tables.ProductsDB;
import db.tables.SoldProductsDB;
import db.tables.RegisterTransactionsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.CartItemOBJ;
import objects.HeldItemsOBJ;
import objects.HoldTransactionOBJ;
import objects.ProductOBJ;
import objects.SoldItemOBJ;
import objects.TransactionOBJ;

/**
 *
 * @author ETDelacruz
 */
public class TransactionManager {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt, insertLog, updateInventory;
    
    private ArrayList<HoldTransactionOBJ> pending;
    private ArrayList<HeldItemsOBJ> pendingItems;
    
    private InventoryManager im;
    
    public TransactionManager(){
    	
        dbf = new DBFactory();
        im = new InventoryManager();
        pending = new ArrayList<HoldTransactionOBJ>();
        pendingItems = new ArrayList<HeldItemsOBJ>();
    }
    
    public boolean makeSale(TransactionOBJ t, ArrayList<CartItemOBJ> items){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                //System.out.println("Enter try!");
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(RegisterTransactionsDB.INSERT_TRANS);
                updateInventory = conn.prepareStatement(ProductsDB.UPDATE_PRODUCT_STOCK);
                
                
                pstmt.setString(1, t.getInvoiceNum());
                pstmt.setString(2, t.getCashier());
                pstmt.setString(3, t.getName());
                pstmt.setString(4, t.getType());
                pstmt.setString(5, t.getWasHeld());
                pstmt.setDouble(6, t.getTotalAmount());
                pstmt.setDouble(7, t.getChange());
                pstmt.setDouble(8, t.getSubTotal());
                pstmt.setDouble(9, t.getCashTendered());
                pstmt.setString(10, t.getMonth());
                pstmt.setString(11, t.getYear());
                pstmt.setString(12, t.getVat());
                pstmt.setDouble(13, t.getBalance());
                pstmt.executeUpdate(); //insert transaction
                //pstmt.close();

                //System.out.println("Done with trans!");
                
                //pstmt = conn.prepareStatement(SoldProducts.INSERT_SOLD_LOG);    
                int newStock;
                if(!t.isHasBalance()){
                    for (CartItemOBJ it: items){
                        for(ProductOBJ p: im.getInventory()){
                            if(it.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){
                                newStock = p.getQUANTITY_ON_FLOOR() - it.getQuantity();

                                updateInventory.setDouble(1, newStock);
                                updateInventory.setString(2, it.getItemCode());
                                updateInventory.addBatch(); // update inventory
                                //System.out.println("updated inventory!");
                                //System.out.println("before insert sold log!");

                                /*pstmt.setInt(1, p.getID());
                                pstmt.setString(2, t.getInvoiceNum());
                                pstmt.setString(3, p.getPRODUCT_NAME());
                                pstmt.setString(4, p.getITEM_CODE());
                                pstmt.setString(5, p.getSKU());
                                pstmt.setDouble(6, it.getTotalPrice());
                                pstmt.setInt(7, it.getQuantity());
                                pstmt.setString(8, Main.lcontrol.getCurrentUser().getUsername());
                                pstmt.addBatch(); //insert sold product log*/

                                //System.out.println("inserted sold log!");
                                break;
                            }
                        }
                    }
                }
                //System.out.println("before update inventory!");
                updateInventory.executeBatch();
                updateInventory.clearBatch();
                updateInventory.close();
                pstmt.close();

                
                conn.commit(); // save changes
                conn.setAutoCommit(true);

                conn.close();
                return true;
            } catch (SQLException ex) {
                try {
                    conn.rollback();
                    return false;
                } catch (SQLException ex1) {
                    //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex1.getMessage());
                    Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean makeSale(TransactionOBJ t, ArrayList<CartItemOBJ> items, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                //System.out.println("Enter try!");
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(RegisterTransactionsDB.INSERT_TRANS);
                updateInventory = conn.prepareStatement(ProductsDB.UPDATE_PRODUCT_STOCK);
                
                
                pstmt.setString(1, t.getInvoiceNum());
                pstmt.setString(2, t.getCashier());
                pstmt.setString(3, t.getName());
                pstmt.setString(4, t.getType());
                pstmt.setString(5, t.getWasHeld());
                pstmt.setDouble(6, t.getTotalAmount());
                pstmt.setDouble(7, t.getChange());
                pstmt.setDouble(8, t.getSubTotal());
                pstmt.setDouble(9, t.getCashTendered());
                pstmt.setString(10, t.getMonth());
                pstmt.setString(11, t.getYear());
                pstmt.setString(12, t.getVat());
                pstmt.setDouble(13, t.getBalance());
                pstmt.executeUpdate(); //insert transaction
                //pstmt.close();

                //System.out.println("Done with trans!");
                
                //pstmt = conn.prepareStatement(SoldProducts.INSERT_SOLD_LOG);    
                int newStock;
                if(!t.isHasBalance()){
                    for (CartItemOBJ it: items){
                        for(ProductOBJ p: im.getInventory()){
                            if(it.getItemCode().equalsIgnoreCase(p.getITEM_CODE())){
                                newStock = p.getQUANTITY_ON_FLOOR() - it.getQuantity();

                                updateInventory.setDouble(1, newStock);
                                updateInventory.setString(2, it.getItemCode());
                                updateInventory.addBatch(); // update inventory
                                //System.out.println("updated inventory!");
                                //System.out.println("before insert sold log!");

                                /*pstmt.setInt(1, p.getID());
                                pstmt.setString(2, t.getInvoiceNum());
                                pstmt.setString(3, p.getPRODUCT_NAME());
                                pstmt.setString(4, p.getITEM_CODE());
                                pstmt.setString(5, p.getSKU());
                                pstmt.setDouble(6, it.getTotalPrice());
                                pstmt.setInt(7, it.getQuantity());
                                pstmt.setString(8, Main.lcontrol.getCurrentUser().getUsername());
                                pstmt.addBatch(); //insert sold product log*/

                                //System.out.println("inserted sold log!");
                                break;
                            }
                        }
                    }
                }
                //System.out.println("before update inventory!");
                updateInventory.executeBatch();
                updateInventory.clearBatch();
                updateInventory.close();
                pstmt.close();

                
                conn.commit(); // save changes
                conn.setAutoCommit(true);

                conn.close();
                return true;
            } catch (SQLException ex) {
                try {
                    conn.rollback();
                    return false;
                } catch (SQLException ex1) {
                    //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex1.getMessage());
                    Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    
    
    public boolean checkHeldTransactions(){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(HoldDB.GET_ALL_HELD_TODAY);
                if(rs.next()){
                    stmt.close();
                    conn.close();
                    return true;
                }
                
                stmt.close();
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean checkHeldTransactions(String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(HoldDB.GET_ALL_HELD_TODAY);
                if(rs.next()){
                    stmt.close();
                    conn.close();
                    return true;
                }
                
                stmt.close();
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean checkifHeldTransactionExisting(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.GET_HELD);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    pstmt.close();
                    conn.close();
                    return true;
                }
                
                
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean checkifHeldTransactionExisting(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.GET_HELD);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    pstmt.close();
                    conn.close();
                    return true;
                }
                
                
                conn.close();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean insertHeldTransaction(HoldTransactionOBJ hi){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.INSERT_HELD);
                pstmt.setString(1, hi.getUserid());
                pstmt.setString(2, hi.getInvoice());
                pstmt.setString(3, hi.getheldID());
                pstmt.setString(4, hi.getLoggedBy());
                pstmt.setString(5, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean insertHeldTransaction(HoldTransactionOBJ hi, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.INSERT_HELD);
                pstmt.setString(1, hi.getUserid());
                pstmt.setString(2, hi.getInvoice());
                pstmt.setString(3, hi.getheldID());
                pstmt.setString(4, hi.getLoggedBy());
                pstmt.setString(5, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public ArrayList<HoldTransactionOBJ> getHeldTransactions(){
    
        this.pending.clear();
        
        conn = dbf.getConn();
            
        if(conn != null){
         
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(HoldDB.GET_ALL_HELD_TODAY);
                while(rs.next()){
                    HoldTransactionOBJ ht = new HoldTransactionOBJ();
                    ht.setheldID(rs.getString(HoldDB.HELDID));
                    ht.setInvoice(rs.getString(HoldDB.INVOICE));
                    ht.setCreatedAt(rs.getTimestamp(HoldDB.CREATEDAT));
                    ht.setLoggedBy(rs.getString(HoldDB.LOGGED));
                    ht.setUserid(rs.getString(HoldDB.USERID));
                    ht.setStatus(rs.getString(HoldDB.STATUS));
                    this.pending.add(ht);
                }
                
                stmt.close();
                conn.close();
                return this.pending;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        
        return null;
    }
    
    public ArrayList<HoldTransactionOBJ> getHeldTransactions(String inventorySpace){
        
        this.pending.clear();
        
        System.out.println("Before Query");
        conn = dbf.getConn(inventorySpace);
            
        if(conn != null){
         
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(HoldDB.GET_ALL_HELD_TODAY);
                while(rs.next()){
                    HoldTransactionOBJ ht = new HoldTransactionOBJ();
                    ht.setheldID(rs.getString(HoldDB.HELDID));
                    ht.setInvoice(rs.getString(HoldDB.INVOICE));
                    ht.setCreatedAt(rs.getTimestamp(HoldDB.CREATEDAT));
                    ht.setLoggedBy(rs.getString(HoldDB.LOGGED));
                    ht.setUserid(rs.getString(HoldDB.USERID));
                    ht.setStatus(rs.getString(HoldDB.STATUS));
                    this.pending.add(ht);
                }
                
                stmt.close();
                conn.close();
                return this.pending;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        System.out.println("Empty Query");
        
        return null;
    }
    
    
    public ArrayList<HeldItemsOBJ> getHeldItems(String heldID){
    
        this.pendingItems.clear();
        
        conn = dbf.getConn();
        
        if(conn != null){
         
            try {
                pstmt = conn.prepareStatement(HeldItemDB.GET_HELD_ITEM);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    HeldItemsOBJ hi = new HeldItemsOBJ();
                    hi.setItemCode(rs.getString(HeldItemDB.ITEMCODE));
                    hi.setHeldID(rs.getString(HeldItemDB.HELDID));
                    hi.setQty(rs.getInt(HeldItemDB.QTY));
                    hi.setStatus(rs.getString(HeldItemDB.STATUS));
                    
                    this.pendingItems.add(hi);
                }
                pstmt.close();
                conn.close();
                return this.pendingItems;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        
        return null;
    }
    
    
    public ArrayList<HeldItemsOBJ> getHeldItems(String heldID, String inventorySpace){
        
        this.pendingItems.clear();
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
         
            try {
                pstmt = conn.prepareStatement(HeldItemDB.GET_HELD_ITEM);
                pstmt.setString(1, heldID);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    HeldItemsOBJ hi = new HeldItemsOBJ();
                    hi.setItemCode(rs.getString(HeldItemDB.ITEMCODE));
                    hi.setHeldID(rs.getString(HeldItemDB.HELDID));
                    hi.setQty(rs.getInt(HeldItemDB.QTY));
                    hi.setStatus(rs.getString(HeldItemDB.STATUS));
                    hi.setCreatedAt(rs.getTimestamp(HeldItemDB.CREATEDAT));
                    
                    this.pendingItems.add(hi);
                }
                pstmt.close();
                conn.close();
                return this.pendingItems;
                } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.toString());
            }
                
            
        }
        
        return null;
    }
    
    
    public boolean insertHeldItem(HeldItemsOBJ hi){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HeldItemDB.INSERT_HELD_ITEM);
                pstmt.setString(1, hi.getHeldID());
                pstmt.setString(2, hi.getItemCode());
                pstmt.setInt(3, hi.getQty());
                pstmt.setString(4, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean insertHeldItem(HeldItemsOBJ hi, String inventorySpace){
        
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HeldItemDB.INSERT_HELD_ITEM);
                pstmt.setString(1, hi.getHeldID());
                pstmt.setString(2, hi.getItemCode());
                pstmt.setInt(3, hi.getQty());
                pstmt.setString(4, hi.getStatus());
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean cancelTransaction(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.CANCEL_HELD);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItemDB.CANCEL_HELD_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean cancelTransaction(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.CANCEL_HELD);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItemDB.CANCEL_HELD_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    
    public boolean openCancelledTransaction(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.SET_TO_PENDING);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItemDB.SET_TO_PENDING_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean openCancelledTransaction(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.SET_TO_PENDING);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItemDB.SET_TO_PENDING_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean closePendingTransaction(String heldID){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.SET_TO_CLOSED);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItemDB.SET_TO_CLOSED_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean closePendingTransaction(String heldID, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(HoldDB.SET_TO_CLOSED);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt = conn.prepareStatement(HeldItemDB.SET_TO_CLOSED_ITEM);
                pstmt.setString(1, heldID);
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(TransactionManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(TransactionManager.class.getName() +" : "+ex.getMessage());
            }
        }
        
        return false;
    }
    
}

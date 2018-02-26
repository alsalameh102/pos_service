/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.tables.AislesDB;
import db.tables.CategoriesDB;
import db.tables.ProductsDB;
import db.tables.SoldProductsDB;
import db.tables.VendorsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pos.satlujwe.PosGW.PosGWProduct;

import objects.AisleOBJ;
import objects.CategoryOBJ;
import objects.ProductOBJ;
import objects.SoldItemOBJ;
import objects.VendorOBJ;

/**
 *
 * @author ETDelacruz
 */
public class InventoryManager {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    private ArrayList<ProductOBJ> inventory, searchResult;
    private ArrayList<AisleOBJ> aisles;
    private ArrayList<CategoryOBJ> categories;
    private ArrayList<VendorOBJ> vendors;
    
    private PosGWProduct[] inventorylist;
    
    public InventoryManager(){
        dbf = new DBFactory();
    }
    
    public ArrayList<AisleOBJ> getAisleList(){
        
        aisles = null;
        conn = dbf.getConn();
        
        if(conn != null){
            aisles = new ArrayList();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(AislesDB.GET_ALL_AISLES);
               
                while(rs.next()){
                    AisleOBJ aisle = new AisleOBJ();
                    aisle.setAisleid(rs.getInt(AislesDB.AISLEID));
                    aisle.setAisleName(rs.getString(AislesDB.AISLENAME));
                    aisle.setCreatedAt(rs.getDate(AislesDB.CREATEDAT));
                    aisle.setUpdateAt(rs.getDate(AislesDB.UPDATEDAT));
                    aisles.add(aisle);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return aisles;
        }
        return null;
    }
    
   public ArrayList<VendorOBJ> getVendorList(){
        
        vendors = null;
        conn = dbf.getConn();
        
        if(conn != null){
            vendors = new ArrayList();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(VendorsDB.GET_ALL_VENDORS);
                while(rs.next()){
                    VendorOBJ vendor = new VendorOBJ();
                    vendor.setVendorId(rs.getInt(VendorsDB.VENDORID));
                    vendor.setVendorName(rs.getString(VendorsDB.VENDORNAME));
                    vendor.setCreatedAt(rs.getDate(VendorsDB.CREATEDAT));
                    vendor.setUpdateAt(rs.getDate(VendorsDB.UPDATEDAT));
                    vendors.add(vendor);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return vendors;
        }
        return null;
    }
        
  public ArrayList<CategoryOBJ> getCategories(){
        
        categories = null;
        conn = dbf.getConn();
        
        if(conn != null){
            categories = new ArrayList();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(CategoriesDB.GET_ALL_CATEGORIES);
                while(rs.next()){
                    CategoryOBJ category = new CategoryOBJ();
                    category.setAisleId(rs.getInt(CategoriesDB.AISLEID));
                    category.setCategoryId(rs.getInt(CategoriesDB.CATID));
                    category.setCategoryName(rs.getString(CategoriesDB.CATNAME));
                    category.setCreatedAt(rs.getDate(CategoriesDB.CREATEDAT));
                    category.setUpdateAt(rs.getDate(CategoriesDB.UPDATEDAT));
                    categories.add(category);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return categories;
        }
        return null;
    }
    
    public ArrayList<ProductOBJ> getInventory(){
        
        inventory = null;
        conn = dbf.getConn();
        
        if(conn != null){
            inventory = new ArrayList<ProductOBJ>();
            
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(ProductsDB.ALL_PRODUCTS);
                while(rs.next()){
                    ProductOBJ prod = new ProductOBJ();
                    prod.setID(rs.getInt(ProductsDB.ID));
                    prod.setPRODUCT_NAME(rs.getString(ProductsDB.PRODUCT_NAME));
                    prod.setPRODUCT_IMG(rs.getString(ProductsDB.PRODUCT_IMG));
                    prod.setAISLE(rs.getInt(ProductsDB.AISLE));
                    prod.setCOUPON(rs.getString(ProductsDB.COUPON));
                    prod.setITEM_CODE(rs.getString(ProductsDB.ITEM_CODE));
                    prod.setSKU(rs.getString(ProductsDB.SKU));
                    prod.setPERISHABLE(rs.getString(ProductsDB.PERISHABLE));
                    prod.setQUANTITY_OFF_FLOOR(rs.getInt(ProductsDB.QUANTITY_OFF_FLOOR));
                    prod.setQUANTITY_ON_FLOOR(rs.getInt(ProductsDB.QUANTITY_ON_FLOOR));
                    prod.setVENDOR(rs.getInt(ProductsDB.VENDOR));
                    prod.setRETAIL_PRICE(rs.getDouble(ProductsDB.RETAIL_PRICE));
                    prod.setPURCHASE_PRICE(rs.getDouble(ProductsDB.PURCHASE_PRICE));
                    prod.setSUB_CATEGORY(rs.getString(ProductsDB.SUB_CATEGORY));
                    prod.setSHELF_LIFE_OFF_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_OFF_FLOOR));
                    prod.setSHELF_LIFE_ON_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_ON_FLOOR));
                    prod.setTAXABLE(rs.getString(ProductsDB.TAXABLE));
                    prod.setCREATED_AT(rs.getDate(ProductsDB.CREATED_AT));
                    prod.setREMARKS(rs.getString(ProductsDB.REMARKS));
                    inventory.add(prod);
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return inventory;
        }
        
        return null;
    }
    
    public ArrayList<ProductOBJ> getInventory(String inventorySpace){
        
        inventory = null;
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            inventory = new ArrayList<ProductOBJ>();
            
            try {
            	
            	System.out.println("Before Inventory Query");
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(ProductsDB.ALL_PRODUCTS);
                while(rs.next()){
                    ProductOBJ prod = new ProductOBJ();
                    prod.setID(rs.getInt(ProductsDB.ID));
                    prod.setPRODUCT_NAME(rs.getString(ProductsDB.PRODUCT_NAME));
                    prod.setPRODUCT_IMG(rs.getString(ProductsDB.PRODUCT_IMG));
                    prod.setAISLE(rs.getInt(ProductsDB.AISLE));
                    prod.setCOUPON(rs.getString(ProductsDB.COUPON));
                    prod.setITEM_CODE(rs.getString(ProductsDB.ITEM_CODE));
                    prod.setSKU(rs.getString(ProductsDB.SKU));
                    prod.setPERISHABLE(rs.getString(ProductsDB.PERISHABLE));
                    prod.setQUANTITY_OFF_FLOOR(rs.getInt(ProductsDB.QUANTITY_OFF_FLOOR));
                    prod.setQUANTITY_ON_FLOOR(rs.getInt(ProductsDB.QUANTITY_ON_FLOOR));
                    prod.setVENDOR(rs.getInt(ProductsDB.VENDOR));
                    prod.setRETAIL_PRICE(rs.getDouble(ProductsDB.RETAIL_PRICE));
                    prod.setPURCHASE_PRICE(rs.getDouble(ProductsDB.PURCHASE_PRICE));
                    prod.setSUB_CATEGORY(rs.getString(ProductsDB.SUB_CATEGORY));
                    prod.setSHELF_LIFE_OFF_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_OFF_FLOOR));
                    prod.setSHELF_LIFE_ON_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_ON_FLOOR));
                    prod.setTAXABLE(rs.getString(ProductsDB.TAXABLE));
                    prod.setCREATED_AT(rs.getDate(ProductsDB.CREATED_AT));
                    prod.setREMARKS(rs.getString(ProductsDB.REMARKS));
                    inventory.add(prod);
                }
                
                System.out.println("After Inventory Query");
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return inventory;
        }
        
        return null;
    }
    
    
    public boolean updateInventory(String itemCode, double stock){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(ProductsDB.UPDATE_PRODUCT_STOCK);
                pstmt.setDouble(1, stock);
                pstmt.setString(2, itemCode);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
    public boolean updateInventory(String itemCode, double stock, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(ProductsDB.UPDATE_PRODUCT_STOCK);
                pstmt.setDouble(1, stock);
                pstmt.setString(2, itemCode);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
    
    
    public ArrayList<ProductOBJ> searchInventoryByName(String searchString){
        
        searchResult = null;
        conn = dbf.getConn();
        String query = null;
        
        /*
        switch(caseNum){
            case 1: query = Products.SEARCH_PRODUCT_BY_AISLE; break;
            case 2: query = Products.SEARCH_PRODUCT_BY_CATEGORY; break;
            case 3: query = Products.SEARCH_PRODUCT_BY_VENDOR; break;
            case 4: query = Products.SEARCH_PRODUCT_BY_NAME; break;
            case 5: query = Products.SEARCH_PRODUCT_BY_NAME_AISLE; break;
            case 6: query = Products.SEARCH_PRODUCT_BY_NAME_CAT; break;
            case 7: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR; break;
            case 8: query = Products.SEARCH_PRODUCT_BY_AISLE_CAT; break;
            case 9: query = Products.SEARCH_PRODUCT_BY_AISLE_VENDOR; break;
            case 10: query = Products.SEARCH_PRODUCT_BY_CAT_VENDOR; break;
            case 11: query = Products.SEARCH_PRODUCT_BY_AISLE_CAT_VENDOR; break;
            case 12: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR_AISLE; break;
            case 13: query = Products.SEARCH_PRODUCT_BY_NAME_CAT_AISLE; break;
            case 14: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR_CAT; break;
            case 15: query = Products.SEARCH_PRODUCT_BY_NAME_VENDOR_AISLE_CAT; break;
            default: query = Products.ALL_PRODUCTS; break;
        }
        */
        
        if(conn != null){
            searchResult = new ArrayList();
            
            try {
                pstmt = conn.prepareStatement(ProductsDB.SEARCH_PRODUCT_BY_NAME);
                pstmt.setString(1, "%"+searchString+"%");
                /*searchString = searchString
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");
                pstmt.setString(1, "%" +searchString+ "%");*/
                
                
                rs = pstmt.executeQuery();
                while(rs.next()){
                    ProductOBJ prod = new ProductOBJ();
                    prod.setID(rs.getInt(ProductsDB.ID));
                    prod.setPRODUCT_NAME(rs.getString(ProductsDB.PRODUCT_NAME));
                    prod.setPRODUCT_IMG(rs.getString(ProductsDB.PRODUCT_IMG));
                    prod.setAISLE(rs.getInt(ProductsDB.AISLE));
                    prod.setCOUPON(rs.getString(ProductsDB.COUPON));
                    prod.setITEM_CODE(rs.getString(ProductsDB.ITEM_CODE));
                    prod.setSKU(rs.getString(ProductsDB.SKU));
                    prod.setPERISHABLE(rs.getString(ProductsDB.PERISHABLE));
                    prod.setQUANTITY_OFF_FLOOR(rs.getInt(ProductsDB.QUANTITY_OFF_FLOOR));
                    prod.setQUANTITY_ON_FLOOR(rs.getInt(ProductsDB.QUANTITY_ON_FLOOR));
                    prod.setVENDOR(rs.getInt(ProductsDB.VENDOR));
                    prod.setRETAIL_PRICE(rs.getDouble(ProductsDB.RETAIL_PRICE));
                    prod.setPURCHASE_PRICE(rs.getDouble(ProductsDB.PURCHASE_PRICE));
                    prod.setSUB_CATEGORY(rs.getString(ProductsDB.SUB_CATEGORY));
                    prod.setSHELF_LIFE_OFF_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_OFF_FLOOR));
                    prod.setSHELF_LIFE_ON_FLOOR(rs.getInt(ProductsDB.SHELF_LIFE_ON_FLOOR));
                    prod.setTAXABLE(rs.getString(ProductsDB.TAXABLE));
                    prod.setCREATED_AT(rs.getDate(ProductsDB.CREATED_AT));
                    prod.setREMARKS(rs.getString(ProductsDB.REMARKS));
                    searchResult.add(prod);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            return searchResult;
        }
        
        return null;
    }
    
    public boolean insertSold(SoldItemOBJ si){
    
        conn = dbf.getConn();
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(SoldProductsDB.INSERT_SOLD_LOG);
                pstmt.setInt(1, si.getId());
                pstmt.setString(2, si.getInvoiceNum());
                pstmt.setString(3, si.getProdName());
                pstmt.setString(4, si.getItemCode());
                pstmt.setString(5, si.getSku());
                pstmt.setDouble(6, si.getPurchasePrice());
                pstmt.setInt(7, si.getQty());
                pstmt.setString(8, si.getRemarks());
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
    public boolean insertSold(SoldItemOBJ si, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(SoldProductsDB.INSERT_SOLD_LOG);
                pstmt.setInt(1, si.getId());
                pstmt.setString(2, si.getInvoiceNum());
                pstmt.setString(3, si.getProdName());
                pstmt.setString(4, si.getItemCode());
                pstmt.setString(5, si.getSku());
                pstmt.setDouble(6, si.getPurchasePrice());
                pstmt.setInt(7, si.getQty());
                pstmt.setString(8, si.getRemarks());
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
        
        }
        
        return false;
    }
    
}

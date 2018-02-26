/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

/**
 *
 * @author etdelacruz
 */
public class SoldProductsDB {
    
    public static final String ID = "product_id";
    public static final String INVOICE = "invoice";
    public static final String PRODUCT_NAME = "product_name";
    public static final String ITEM_CODE = "item_code";
    public static final String SKU = "sku";
    public static final String PURCHASE_PRICE = "purchase_price";
    public static final String QUANTITY = "quantity";
    public static final String REMARKS = "remarks";
    public static final String SOLD_AT = "sold_at";
    public static final String UPDATED_AT = "updated_at";
    
    
    //queries
    public static final String INSERT_SOLD_LOG = "INSERT INTO sold_products_log (product_id, invoice, product_name, item_code, sku, purchase_price, quantity"
            + ", remarks) VALUES (?,?,?,?,?,?,?,?)";
}

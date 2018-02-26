/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

/**
 *
 * @author ETDelacruz
 */
public class ProductsDB {
    
     //column names in database
    public static final String ID = "product_id";
    public static final String PRODUCT_IMG = "product_img";
    public static final String PRODUCT_NAME = "product_name";
    public static final String ITEM_CODE = "item_code";
    public static final String SKU = "sku";
    public static final String VENDOR = "vendor";
    public static final String PURCHASE_PRICE = "retail_price";
    public static final String RETAIL_PRICE = "retail_price";
    public static final String AISLE = "aisle";
    public static final String PERISHABLE = "perishable";
    public static final String SUB_CATEGORY = "sub_category";
    public static final String QUANTITY_ON_FLOOR = "quantity_on_floor";
    public static final String SHELF_LIFE_ON_FLOOR = "shelf_life_on_floor";
    public static final String QUANTITY_OFF_FLOOR = "quantity_off_floor";
    public static final String SHELF_LIFE_OFF_FLOOR = "shelf_life_off_floor";
    public static final String TAX = "tax";
    public static final String TAXABLE = "taxable";
    public static final String COUPON = "coupon";
    public static final String REMARKS = "remarks";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    
    
    
    //queries
    
    public static final String ALL_PRODUCTS = "SELECT * FROM products";
    public static final String SEARCH_PRODUCT_BY_NAME = "SELECT * FROM products where product_name like ?";
    public static final String SEARCH_PRODUCT_BY_AISLE = "SELECT * FROM products where aisle = ?";
    public static final String SEARCH_PRODUCT_BY_CATEGORY = "SELECT * FROM products where sub_category = ?";
    public static final String SEARCH_PRODUCT_BY_VENDOR = "SELECT * FROM products where vendor = ?";
    public static final String SEARCH_PRODUCT_BY_NAME_AISLE = "SELECT * FROM products where product_name like ? and aisle = ?";
    public static final String SEARCH_PRODUCT_BY_NAME_CAT = "SELECT * FROM products where product_name like ? and sub_category = ?";
    public static final String SEARCH_PRODUCT_BY_NAME_VENDOR = "SELECT * FROM products where product_name like ? and vendor = ?";
    public static final String SEARCH_PRODUCT_BY_NAME_VENDOR_AISLE_CAT = "SELECT * FROM products where product_name like ? and vendor = ? and aisle = ? and sub_category = ?";
    public static final String SEARCH_PRODUCT_BY_NAME_VENDOR_AISLE = "SELECT * FROM products where product_name like ? and vendor = ? and aisle = ?";
    public static final String SEARCH_PRODUCT_BY_NAME_VENDOR_CAT = "SELECT * FROM products where product_name like ? and vendor = ? and sub_category = ?";
    public static final String SEARCH_PRODUCT_BY_NAME_CAT_AISLE = "SELECT * FROM products where product_name like ? and aisle = ? and sub_category = ?";
    
    public static final String SEARCH_PRODUCT_BY_AISLE_CAT = "SELECT * FROM products where and aisle = ? and sub_category = ?";
    public static final String SEARCH_PRODUCT_BY_AISLE_VENDOR = "SELECT * FROM products where and aisle = ? and vendor = ?";
    public static final String SEARCH_PRODUCT_BY_AISLE_CAT_VENDOR = "SELECT * FROM products where and aisle = ? and sub_category = ? and vendor = ?";
    public static final String SEARCH_PRODUCT_BY_CAT_VENDOR = "SELECT * FROM products where and vendor = ? and sub_category = ?";
    public static final String UPDATE_PRODUCT_STOCK = "UPDATE products SET quantity_on_floor=? where item_code = ?";
    public static final String UPDATE_PRODUCT_DELTA = "UPDATE products SET quantity_on_floor=(quantity_on_floor-?) where item_code = ?";
    
    
    public static final String REPORT_ALL_PRODUCTS = "SELECT item_code AS 'Item Code',product_name AS 'Product Name',quantity_on_floor AS 'Quantity in Floor',quantity_off_floor AS 'Quantity Off Floor', retail_price*(quantity_on_floor+quantity_off_floor) AS 'Total Price Value' FROM products";
}

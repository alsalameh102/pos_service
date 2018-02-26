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
public class CategoriesDB {
    
    public static final String CATID = "category_id";
    public static final String CATNAME = "category_name";
    public static final String AISLEID = "aisle_id";
    public static final String CREATEDAT = "created_at";
    public static final String UPDATEDAT = "updated_at";
    
    public static final String GET_ALL_CATEGORIES   = "SELECT * FROM categories";
    
}

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
public class UsersDB {
    
    //column names in database
    public static final String ID = "id";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String ROLE = "user_role";
    public static final String ACT_KEY = "activation_key";
    public static final String RESET_KEY = "reset_key";
    public static final String EMAIL_STATUS = "email_activation_status";
    public static final String USER_STATUS = "user_status";
    public static final String DATE_CREATED = "created_at";
    
    //queries
    public static final String GET_USER_DETAILS = "SELECT * from users where username = ? and password = ?";
}

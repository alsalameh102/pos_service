/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.tables.UsersDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import objects.UserOBJ;
import utils.Password;


/**
 *
 * @author ETDelacruz
 */
public class UserValidation {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    
    public UserValidation(){
        dbf = new DBFactory();
    }
    
    public boolean checkIfUserExisting(String user, String password){
    
        conn = dbf.getConn();
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(UsersDB.GET_USER_DETAILS);
                pstmt.setString(1, user);
                pstmt.setString(2, Password.getEncryptedPw(password));
                rs = pstmt.executeQuery();
                
                if(rs.next()){
                    UserOBJ account = new UserOBJ();
                    account.setUserid(rs.getInt(UsersDB.ID));
                    account.setFirstname(rs.getString(UsersDB.FIRSTNAME));
                    account.setLastname(rs.getString(UsersDB.LASTNAME));
                    account.setUsername(rs.getString(UsersDB.USERNAME));
                    account.setPassword(rs.getString(UsersDB.PASSWORD));
                    account.setEmail(rs.getString(UsersDB.EMAIL));
                    account.setRole(rs.getString(UsersDB.ROLE));
                    account.setActivationKey(rs.getString(UsersDB.ACT_KEY));
                    account.setResetKey(rs.getString(UsersDB.RESET_KEY));
                    account.setEmailStatus(rs.getString(UsersDB.EMAIL_STATUS));
                    account.setUserStat(rs.getString(UsersDB.USER_STATUS));
                    account.setDateCreated(rs.getString(UsersDB.DATE_CREATED));
                    //Main.lcontrol.setCurrentUser(account);
                    pstmt.close();
                    conn.close();
                    
                    return true;
                }
                
            } catch (SQLException ex) {
                //Main.control.showErrorMessage(UserValidation.class.getName() +" : "+ex.toString());
            }
        }
        
        return false;
    }
    
    public UserOBJ getUserIfExisting(String user, String password, String inventorySpace){
        
        conn = dbf.getConn(inventorySpace);
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(UsersDB.GET_USER_DETAILS);
                pstmt.setString(1, user);
                pstmt.setString(2, Password.getEncryptedPw(password));
                rs = pstmt.executeQuery();
                
                if(rs.next()){
                    UserOBJ account = new UserOBJ();
                    account.setUserid(rs.getInt(UsersDB.ID));
                    account.setFirstname(rs.getString(UsersDB.FIRSTNAME));
                    account.setLastname(rs.getString(UsersDB.LASTNAME));
                    account.setUsername(rs.getString(UsersDB.USERNAME));
                    account.setPassword(rs.getString(UsersDB.PASSWORD));
                    account.setEmail(rs.getString(UsersDB.EMAIL));
                    account.setRole(rs.getString(UsersDB.ROLE));
                    account.setActivationKey(rs.getString(UsersDB.ACT_KEY));
                    account.setResetKey(rs.getString(UsersDB.RESET_KEY));
                    account.setEmailStatus(rs.getString(UsersDB.EMAIL_STATUS));
                    account.setUserStat(rs.getString(UsersDB.USER_STATUS));
                    account.setDateCreated(rs.getString(UsersDB.DATE_CREATED));
                    //Main.lcontrol.setCurrentUser(account);
                    pstmt.close();
                    conn.close();
                    
                    return account;
                }
                
            } catch (SQLException ex) {
                System.out.println("getUserIfExisting ERROR:"+ex.getMessage());
            }
        }
        
        return null;
    }
    
}

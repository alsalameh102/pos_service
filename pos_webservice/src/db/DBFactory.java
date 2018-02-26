/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import config.Constant;
import config.SysProp;

import java.sql.*;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 * @author ETDelacruz
 */
public class DBFactory implements Constant {
    
	private static final Log log = LogFactory.getLog(DBFactory.class);
    private static Connection conn;
    private Statement stmt;
    private static Properties prop;
    public static SysProp sysProp;
    
    public DBFactory(){
        prop = new Properties();
        sysProp = new SysProp();
        prop.setProperty("user", sysProp.getInstance().getProperty(DBUSER).toString());
        prop.setProperty("password", sysProp.getInstance().getProperty(DBPASS).toString());
        prop.setProperty("verifyServerCertificate", "false");
        prop.setProperty("useSSL", "true"); 
        prop.setProperty("zeroDateTimeBehavior", "convertToNull");
        prop.setProperty("useJDBCCompliantTimezoneShift", "true");
        prop.setProperty("useLegacyDatetimeCode", "false");
        prop.setProperty("serverTimezone", "UTC");
    }
    
    public String getURL(){
        StringBuilder sb = new StringBuilder();
        sb.append(sysProp.getInstance().getProperty(DBURL).toString()); //dburl
        sb.append(sysProp.getInstance().getProperty(DBHOST).toString()); //dbhost
        sb.append(":");
        sb.append(sysProp.getInstance().getProperty(DBPORT).toString()); //dbport
        sb.append("/");
        sb.append(sysProp.getInstance().getProperty(DBNAME).toString()); //dbname  
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public String getURL(String dbName){
    	
        StringBuilder sb = new StringBuilder();
        sb.append(sysProp.getInstance().getProperty(DBURL).toString()); //dburl
        sb.append(sysProp.getInstance().getProperty(DBHOST).toString()); //dbhost
        sb.append(":");
        sb.append(sysProp.getInstance().getProperty(DBPORT).toString()); //dbport
        sb.append("/");
        sb.append(dbName); //dbname  
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    
    public Connection getConn(){
        
        try {
            Class.forName(sysProp.getInstance().getProperty(DBSQLDRIVER).toString()); //dbsqldriver
            conn = DriverManager.getConnection(getURL(),prop);
            
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
        	System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public Connection getConn(String dbName){
   
        try {
            Class.forName(sysProp.getInstance().getProperty(DBSQLDRIVER).toString()); //dbsqldriver
            
            conn = DriverManager.getConnection(getURL(dbName),prop);
            System.out.println("DB Connection Successful!");
            return conn;
        } catch (Exception ex) {
        	System.err.println(ex.getMessage());
        }
        
        return null;
    }
    
}

package db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import objects.AppSettingOBJ;


public interface AppSettingsDAO {

  /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public boolean create(String key, String value, String desc);
  
  /** 
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public AppSettingOBJ getAppSetting(String key);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<AppSettingOBJ> listSettings();
  public List<AppSettingOBJ> receiptSettings();
  
  /** 
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public boolean delete(String key);
  
  /** 
     * This is the method to be used to update
     * a record into the Student table.
  */
  public boolean update(ArrayList<AppSettingOBJ> updateSettings);
	
}

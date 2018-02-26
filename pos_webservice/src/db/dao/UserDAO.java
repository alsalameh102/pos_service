package db.dao;

import javax.sql.DataSource;

import objects.UserOBJ;

public interface UserDAO {

	  /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  public UserOBJ getUserIfExisting(String user, String password);
  
	
}

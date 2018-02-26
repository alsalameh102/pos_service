package db.dao;

import java.util.List;
import javax.sql.DataSource;
import objects.ReturnItemOBJ;

public interface ReturnItemDAO {

  /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public boolean create(ReturnItemOBJ ri);
  
  /** 
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public ReturnItemOBJ getReturnItemOBJ(int key);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<ReturnItemOBJ> listAllReturnItems();
  
  public List<ReturnItemOBJ> listReturnItemsToday();
  
  /** 
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public boolean delete(int key);
  
  /** 
     * This is the method to be used to update
     * a record into the Student table.
  */
  public boolean update(int key, String value);
	
}

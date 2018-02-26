package db.dao;

import java.util.List;
import javax.sql.DataSource;

import objects.ProductOBJ;
import objects.ReturnItemOBJ;
import objects.SoldItemOBJ;

public interface InventoryDAO {

	 /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  

  public boolean createSold(SoldItemOBJ si);
  public boolean createReturn(ReturnItemOBJ ri);
  

  public ProductOBJ getProduct(Integer id);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<ProductOBJ> listProducts();
 
 
  /** 
     * This is the method to be used to update
     * a record into the Student table.
  */
  public boolean updateByNewStock(String itemCode, double stock);
  public boolean updateByDelta(String itemCode, double delta);
	
}

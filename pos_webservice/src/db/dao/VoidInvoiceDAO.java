package db.dao;

import java.util.List;
import javax.sql.DataSource;
import objects.VoidInvoiceOBJ;

public interface VoidInvoiceDAO {

	/** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public boolean create(VoidInvoiceOBJ vi);
  
  /** 
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public VoidInvoiceOBJ getVoidInvoice(String key);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<VoidInvoiceOBJ> listVoidInvoices();
  public List<VoidInvoiceOBJ> listVoidInvoicesToday();
  
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
  public boolean update(String key, String value);
	
}

package db.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import objects.CartItemOBJ;
import objects.HeldItemsOBJ;
import objects.HoldTransactionOBJ;
import objects.TransactionOBJ;

public interface TransactionsDAO {

	  /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
	
	  public boolean txmakeSale(TransactionOBJ t, ArrayList<CartItemOBJ> items);
	  
	  
	  public boolean checkHeldTransactions();
	  public boolean checkifHeldTransactionExisting(String heldID);
	  public boolean insertHeldTransaction(HoldTransactionOBJ hi);
	  
	  public ArrayList<HoldTransactionOBJ> getHeldTransactions();
	  public ArrayList<HeldItemsOBJ> getHeldItems(String heldID);
	  public boolean insertHeldItem(HeldItemsOBJ hi);
	  public boolean txcancelTransaction(String heldID);
	  public boolean txopenCancelledTransaction(String heldID);
	  public boolean txclosePendingTransaction(String heldID);
	
}

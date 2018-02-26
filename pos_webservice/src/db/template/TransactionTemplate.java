package db.template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import db.dao.TransactionsDAO;
import db.mapper.AppSettingMapper;
import db.mapper.HeldItemMapper;
import db.mapper.HoldTransactionMapper;
import db.tables.AppSettingsDB;
import db.tables.HeldItemDB;
import db.tables.HoldDB;
import db.tables.ProductsDB;
import db.tables.RegisterTransactionsDB;
import db.tables.SoldProductsDB;
import objects.AppSettingOBJ;
import objects.CartItemOBJ;
import objects.HeldItemsOBJ;
import objects.HoldTransactionOBJ;
import objects.TransactionOBJ;

public class TransactionTemplate implements TransactionsDAO{

	private JdbcTemplate jdbcTemplateObject;

	
	public TransactionTemplate(){
		
	}
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource); 
	}

	@Override
	public boolean txmakeSale(TransactionOBJ t, ArrayList<CartItemOBJ> items) {
		// TODO Auto-generated method stub
		try{
			jdbcTemplateObject.update( RegisterTransactionsDB.INSERT_TRANS, t.getInvoiceNum(), t.getCashier(), t.getName(), t.getType(), t.getWasHeld()
					, t.getTotalAmount(), t.getChange(), t.getSubTotal(), t.getCashTendered(), t.getMonth(), t.getYear(), t.getVat(), t.getBalance());
			jdbcTemplateObject.batchUpdate(ProductsDB.UPDATE_PRODUCT_DELTA, new BatchPreparedStatementSetter() {
	
				@Override
				public void setValues(PreparedStatement updateInventory, int i) throws SQLException {
					CartItemOBJ item = items.get(i);
					updateInventory.setDouble(1, item.getQuantity());
	                updateInventory.setString(2, item.getItemCode());
				}
	
				@Override
				public int getBatchSize() {
					return items.size();
				}
			  });
			
			jdbcTemplateObject.batchUpdate(SoldProductsDB.INSERT_SOLD_LOG, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement insertSold, int i) throws SQLException {
					CartItemOBJ item = items.get(i);
					insertSold.setInt(1, 0); //default for the meantime
					insertSold.setString(2, item.getInvoiceNum());
					if(item.getDesc()!=null){
						insertSold.setString(3, item.getDesc());
					} else {
						insertSold.setString(3, "-");
					}
					
					insertSold.setString(4, item.getItemCode());
					insertSold.setString(5, "");
					insertSold.setDouble(6, item.getTotalPrice());
					insertSold.setInt(7, item.getQuantity());
					insertSold.setString(8, "");
				}
	
				@Override
				public int getBatchSize() {
					return items.size();
				}
			  });
			
			// to simulate the exception.
	         //throw new RuntimeException("simulate Error condition") ;
			
			
			return true;
		}
		catch (DataAccessException e) {
			 System.out.println("Error: "+e.getMessage());
	         System.out.println("makeSale : Error in updating records, rolling back");
	    }
		
		return false;
	}

	
	@Override
	public boolean checkHeldTransactions() {
		// TODO Auto-generated method stub
		List<HoldTransactionOBJ> list = jdbcTemplateObject.query(HoldDB.GET_ALL_HELD_TODAY, new HoldTransactionMapper());
		if(list.isEmpty()){
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkifHeldTransactionExisting(String heldID) {
		HoldTransactionOBJ ht;
		try{
			ht = jdbcTemplateObject.queryForObject(HoldDB.GET_HELD, new Object[]{heldID}, new HoldTransactionMapper());
		}catch(EmptyResultDataAccessException e){
			ht = null;
		}
		
		if(ht != null){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean insertHeldTransaction(HoldTransactionOBJ hi) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( HoldDB.INSERT_HELD, hi.getUserid(), hi.getInvoice(), hi.getheldID(), hi.getLoggedBy(), hi.getStatus());
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public ArrayList<HoldTransactionOBJ> getHeldTransactions() {
		// TODO Auto-generated method stub
		ArrayList<HoldTransactionOBJ> list = (ArrayList<HoldTransactionOBJ>) jdbcTemplateObject.query(HoldDB.GET_ALL_HELD_TODAY, new HoldTransactionMapper());
		return list;
	}

	@Override
	public ArrayList<HeldItemsOBJ> getHeldItems(String heldID) {
		// TODO Auto-generated method stub
		ArrayList<HeldItemsOBJ> list = (ArrayList<HeldItemsOBJ>) jdbcTemplateObject.query(HeldItemDB.GET_HELD_ITEM, new HeldItemMapper(), heldID);
		return list;
	}

	@Override
	public boolean insertHeldItem(HeldItemsOBJ hi) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( HeldItemDB.INSERT_HELD_ITEM, hi.getHeldID(), hi.getItemCode(), hi.getQty(), hi.getStatus());
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean txcancelTransaction(String heldID) {
		// TODO Auto-generated method stub	
		try{
			jdbcTemplateObject.update( HoldDB.CANCEL_HELD, heldID);
			jdbcTemplateObject.update( HeldItemDB.CANCEL_HELD_ITEM, heldID);
			return true;
		}
		catch (DataAccessException e) {
	         System.out.println("cancelTransaction : Error in updating records, rolling back");

	    }

		return false;
		
	}

	@Override
	public boolean txopenCancelledTransaction(String heldID) {
		// TODO Auto-generated method stub

		try{
			jdbcTemplateObject.update( HoldDB.SET_TO_PENDING, heldID);
			jdbcTemplateObject.update( HeldItemDB.SET_TO_PENDING_ITEM, heldID);
			return true;
		}
		catch (DataAccessException e) {
	         System.out.println("openCancelledTransaction : Error in updating records, rolling back");
	    }

		return false;
		
	}

	@Override
	public boolean txclosePendingTransaction(String heldID) {
		// TODO Auto-generated method stub
		
		try{
			jdbcTemplateObject.update( HoldDB.SET_TO_CLOSED, heldID);
			jdbcTemplateObject.update( HeldItemDB.SET_TO_CLOSED_ITEM, heldID);
			return true;
		}
		catch (DataAccessException e) {
	         System.out.println("closePendingTransaction : Error in updating records, rolling back");
	    }

		return false;
		
	}

}

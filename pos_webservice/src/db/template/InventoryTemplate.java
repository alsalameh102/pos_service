package db.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import db.dao.InventoryDAO;
import db.mapper.InventoryMapper;
import db.tables.ProductsDB;
import db.tables.SoldProductsDB;
import objects.ProductOBJ;
import objects.ReturnItemOBJ;
import objects.SoldItemOBJ;

public class InventoryTemplate implements InventoryDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public boolean createSold(SoldItemOBJ si) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( SoldProductsDB.INSERT_SOLD_LOG, si.getId(), si.getInvoiceNum(), si.getProdName(), si.getItemCode(), si.getSku(), 
				si.getPurchasePrice(), si.getQty(), si.getRemarks());
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean createReturn(ReturnItemOBJ ri) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductOBJ getProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductOBJ> listProducts() {
		// TODO Auto-generated method stub
		List<ProductOBJ> list = jdbcTemplateObject.query(ProductsDB.ALL_PRODUCTS, new InventoryMapper());
		return list;
	}

	@Override
	public boolean updateByNewStock(String itemCode, double stock) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( ProductsDB.UPDATE_PRODUCT_STOCK, stock, itemCode);
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateByDelta(String itemCode, double delta) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( ProductsDB.UPDATE_PRODUCT_DELTA, delta, itemCode);
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

}

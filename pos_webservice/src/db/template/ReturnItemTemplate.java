package db.template;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import db.dao.ReturnItemDAO;
import db.mapper.ReturnItemMapper;
import db.tables.ReturnItemDB;
import objects.ReturnItemOBJ;

public class ReturnItemTemplate implements ReturnItemDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public boolean create(ReturnItemOBJ ri) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( ReturnItemDB.INSERTRETURN, ri.getUserid(), ri.getInvoiceNum(), ri.getItemCode(), ri.getQty(), ri.getLoggedBy(), ri.getStatus());
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public ReturnItemOBJ getReturnItemOBJ(int key) {
		// TODO Auto-generated method stub
		ReturnItemOBJ ri = jdbcTemplateObject.queryForObject(ReturnItemDB.GETSPECIFICRETURNS, new Object[]{key}, new ReturnItemMapper());
		return ri;
	}

	@Override
	public List<ReturnItemOBJ> listAllReturnItems() {
		// TODO Auto-generated method stub
		List<ReturnItemOBJ> list = jdbcTemplateObject.query(ReturnItemDB.GETALLRETURNS, new ReturnItemMapper());
		return list;
	}

	@Override
	public List<ReturnItemOBJ> listReturnItemsToday() {
		// TODO Auto-generated method stub
		List<ReturnItemOBJ> list = jdbcTemplateObject.query(ReturnItemDB.GETALLRETURNSTODAY, new ReturnItemMapper());
		return list;
	}
	
	@Override
	public boolean delete(int key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int key, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

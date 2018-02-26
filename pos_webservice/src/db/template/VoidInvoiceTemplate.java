package db.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import db.dao.VoidInvoiceDAO;
import db.mapper.ReturnItemMapper;
import db.mapper.VoidInvoiceMapper;
import db.tables.AppSettingsDB;
import db.tables.ReturnItemDB;
import db.tables.VoidInvoiceDB;
import objects.ReturnItemOBJ;
import objects.VoidInvoiceOBJ;

public class VoidInvoiceTemplate implements VoidInvoiceDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public boolean create(VoidInvoiceOBJ vi) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( VoidInvoiceDB.INSERTVOID, vi.getUserId(), vi.getInvoiceNum(), vi.getLoggedBy(), vi.getStatus());
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public VoidInvoiceOBJ getVoidInvoice(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VoidInvoiceOBJ> listVoidInvoices() {
		// TODO Auto-generated method stub
		List<VoidInvoiceOBJ> list = jdbcTemplateObject.query(VoidInvoiceDB.GETALLVOIDINVOICE, new VoidInvoiceMapper());
		return list;
	}

	@Override
	public List<VoidInvoiceOBJ> listVoidInvoicesToday() {
		// TODO Auto-generated method stub
		List<VoidInvoiceOBJ> list = jdbcTemplateObject.query(VoidInvoiceDB.GETALLVOIDEDTODAY, new VoidInvoiceMapper());
		return list;
	}
	
	@Override
	public boolean delete(String key) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( VoidInvoiceDB.DELETEVOID, key);
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean update(String key, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

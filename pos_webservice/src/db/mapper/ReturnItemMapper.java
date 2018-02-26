package db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.tables.ReturnItemDB;
import objects.ReturnItemOBJ;

public class ReturnItemMapper implements RowMapper<ReturnItemOBJ>{

	@Override
	public ReturnItemOBJ mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ReturnItemOBJ ri = new ReturnItemOBJ();
		
		ri.setId(rs.getInt(ReturnItemDB.RETURNID));
		ri.setInvoiceNum(rs.getString(ReturnItemDB.INVOICENUM));
		ri.setItemCode(rs.getString(ReturnItemDB.ITEMCODE));
		ri.setLoggedBy(rs.getString(ReturnItemDB.LOGGEDBY));
		ri.setQty(rs.getInt(ReturnItemDB.QTY));
		ri.setStatus(rs.getString(ReturnItemDB.STATUS));
		ri.setUserid(rs.getInt(ReturnItemDB.USERID));
		ri.setCreatedAt(rs.getString(ReturnItemDB.CREATEDAT));
		
		return ri;
	}

}

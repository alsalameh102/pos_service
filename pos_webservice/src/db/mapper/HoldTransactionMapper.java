package db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.tables.HoldDB;
import objects.HoldTransactionOBJ;

public class HoldTransactionMapper implements RowMapper<HoldTransactionOBJ>{

	@Override
	public HoldTransactionOBJ mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		 HoldTransactionOBJ ht = new HoldTransactionOBJ();
         ht.setheldID(rs.getString(HoldDB.HELDID));
         ht.setInvoice(rs.getString(HoldDB.INVOICE));
         ht.setCreatedAt(rs.getTimestamp(HoldDB.CREATEDAT));
         ht.setLoggedBy(rs.getString(HoldDB.LOGGED));
         ht.setUserid(rs.getString(HoldDB.USERID));
         ht.setStatus(rs.getString(HoldDB.STATUS));
		
		return ht;
	}

}

package db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.tables.HeldItemDB;
import objects.HeldItemsOBJ;

public class HeldItemMapper implements RowMapper<HeldItemsOBJ>{

	@Override
	public HeldItemsOBJ mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		HeldItemsOBJ hi = new HeldItemsOBJ();
        hi.setItemCode(rs.getString(HeldItemDB.ITEMCODE));
        hi.setHeldID(rs.getString(HeldItemDB.HELDID));
        hi.setQty(rs.getInt(HeldItemDB.QTY));
        hi.setStatus(rs.getString(HeldItemDB.STATUS));
        hi.setCreatedAt(rs.getTimestamp(HeldItemDB.CREATEDAT));
        
		return hi;
	}

}

package db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.tables.VoidInvoiceDB;
import objects.VoidInvoiceOBJ;

public class VoidInvoiceMapper implements RowMapper<VoidInvoiceOBJ>{

	@Override
	public VoidInvoiceOBJ mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		VoidInvoiceOBJ vi = new VoidInvoiceOBJ();
		
		vi.setId(rs.getInt(VoidInvoiceDB.VOIDINVOICEID));
		vi.setInvoiceNum(rs.getString(VoidInvoiceDB.INVOICENUM));
		vi.setLoggedBy(rs.getString(VoidInvoiceDB.LOGGEDBY));
		vi.setStatus(rs.getString(VoidInvoiceDB.STATUS));
		vi.setUserId(rs.getInt(VoidInvoiceDB.USERID));
		vi.setCreatedAt(rs.getString(VoidInvoiceDB.CREATEDAT));
		
		return vi;
	}

}

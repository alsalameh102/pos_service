package db.tables;

public class VoidInvoiceDB {

	
	 public static final String VOIDINVOICEID = "id";
	 public static final String USERID = "userid";
	 public static final String INVOICENUM = "invoice_num";
	 public static final String LOGGEDBY = "logged_by";
	 public static final String CREATEDAT = "created_at";
	 public static final String STATUS = "status";
	
	 
	 public static final String GETALLVOIDINVOICE = "select * from void_invoice";
	 public static final String GETALLVOIDEDTODAY = "select * from void_invoice where created_at >= CURDATE() AND created_at < CURDATE() + INTERVAL 1 DAY ORDER BY created_at";
	 public static final String INSERTVOID = "insert into void_invoice (userid, invoice_num, logged_by, status) values (?,?,?,?)";
	 public static final String DELETEVOID = "delete from void_invoice where id = ?";
}

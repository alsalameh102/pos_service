package db.tables;

public class ReturnItemDB {

	 public static final String RETURNID = "id";
	 public static final String USERID = "userid";
	 public static final String INVOICENUM = "invoice_num";
	 public static final String ITEMCODE = "item_code";
	 public static final String QTY = "qty";
	 public static final String LOGGEDBY = "logged_by";
	 public static final String CREATEDAT = "created_at";
	 public static final String STATUS = "status";
	
	 public static final String GETALLRETURNS = "select * from returns";
	 public static final String GETALLRETURNSTODAY = "select * from returns where created_at >= CURDATE() AND created_at < CURDATE() + INTERVAL 1 DAY ORDER BY created_at";
	 public static final String GETSPECIFICRETURNS = "select * from returns where id = ?";
	 public static final String INSERTRETURN = "insert into returns (userid, invoice_num, item_code, qty, logged_by, status) values (?,?,?,?,?,?)";
	 
	 
}

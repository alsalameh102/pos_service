/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

/**
 *
 * @author ETDelacruz
 */
public class RegisterTransactionsDB {
    
    public static final String ID = "transaction_id";
    public static final String INVOICE_NUM = "invoice_number";
    public static final String CASHIER = "cashier";
    public static final String DATE = "tran_date";
    public static final String NAME = "tran_name";
    public static final String TYPE = "tran_type";
    public static final String HELD = "was_held";
    public static final String TOTAL_AMT = "total_amount";
    public static final String CHANGE = "tran_change";
    public static final String SUB_TOTAL = "sub_total";
    public static final String AMOUNT_TENDERED = "amount_tendered";
    public static final String MONTH = "tran_month";
    public static final String YEAR = "tran_year";
    public static final String VAT = "tran_vat";
    public static final String BALANCE = "tran_balance";
    
    //queries
    public static final String GET_ALL_TRANS = "SELECT * from register_transactions";
    public static final String INSERT_TRANS = "INSERT INTO register_transactions (invoice_number, cashier, tran_name, tran_type, was_held, total_amount, tran_change, sub_total, amount_tendered, tran_month, tran_year, tran_vat, tran_balance) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    
    public static final String GET_SALES_REPORT_OVERALL = "SELECT register_transactions_id as 'register_transactions ID',tran_date as 'Date',invoice_number as 'Invoice Number',total_amount as 'Total Amount',tran_balance as 'Balance' from register_transactions";
    public static final String GET_SALES_REPORT_TODAY = "SELECT * from register_transactions";
    public static final String GET_SALES_REPORT_THIS_MONTH = "SELECT * from register_transactions";
    
    public static final String GET_SALES_REPORT_OVERALL_TOTAL = "SELECT SUM(total_amount) as 'Total Sales',SUM(tran_balance) as 'Total Balance' from register_transactions";
    public static final String GET_SALES_REPORT_TODAY_TOTAL = "SELECT SUM(total_amount) as 'Total Sales',SUM(tran_balance) as 'Total Balance' from register_transactions";
    public static final String GET_SALES_REPORT_THIS_MONTH_TOTAL = "SELECT SUM(total_amount) as 'Total Sales',SUM(tran_balance) as 'Total Balance' from register_transactions";
}

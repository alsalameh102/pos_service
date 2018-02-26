/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author ETDelacruz
 */
public interface Constant {

    //pos properties file
    public static final String DBSQLDRIVER = "DBSQLDRIVER";
    public static final String DBURL = "DBURL";
    public static final String DBNAME = "DBNAME";
    public static final String DBHOST = "DBHOST";
    public static final String DBPORT = "DBPORT";
    public static final String DBUSER = "DBUSER";
    public static final String DBPASS = "DBPASS";
    
    public static final String POS_INVOICE_PREF = "POS_INVOICE_PREF";
    public static final String POS_VAT = "POS_VAT";
    public static final String POS_STATION_NUMBER = "POS_STATION_NUMBER";
    public static final String PROPERTY_PATH = "PROPERTY_PATH";
    public static final String POS_TITLE = "POS_TITLE";
    public static final String POS_BG_IMG = "POS_BG_IMG";
    
    
    public static final String TITLE = "My POS v1.0";
    //database connection final values
    //temporary setup
    public static final String SQLDRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://";
    public static final String DB = "satlujwe_pos3";
    public static final String HOST = "localhost";
    public static final String PORT = "8888";
    public static final String USER = "satlujwe_pos3";
    public static final String PASS = "pos@123##";
    //public static final String HOST = "db4free.net";
    //public static final String PORT = "3306";

//fxml paths
    public static final String MW_FXML_PATH = "/fxml/Register.fxml";
    public static final String LOGIN_FXML_PATH = "/fxml/Init.fxml";
    public static final String IS_FXML_PATH = "/fxml/SearchInventory.fxml";
    public static final String PAYMENT_FXML_PATH = "/fxml/Payment.fxml";
    public static final String HELDITEM_FXML_PATH = "/fxml/HeldItems.fxml";
    public static final String OPTIONS_FXML_PATH = "/fxml/Options.fxml";
    public static final String CLOCKER_FXML_PATH = "/fxml/CashierClocker.fxml";
    public static final String POSSETTINGS_FXML_PATH = "/fxml/POSSettings.fxml";
    public static final String REPORTS_FXML_PATH = "/fxml/Reports.fxml";
    public static final String SDATE_PICKER_FXML_PATH = "/fxml/POSDatePicker.fxml";
    
    //util
    public static final String HASH_ALGO = "MD5";
    public static final String INVOICE_PREF = "ALXIS-";
     public static final String CART_REGEX = "^(\\d+)(\\s)+x(\\s+)(.*)";
    
    //gui controls
    public static final String EMPTY_STRING = "";
    public static final String COMBO_NONE = "<None>";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    
    //alerts
    public static final String NOT_YET_SUPPORTED = "This function is not yet supported!";
    public static final String LOGIN_ERROR = "Username does not exist or you typed the wrong password!";
    public static final String HOLDID_EXISTS_ERROR = "HoldID already exists! Please Choose another one.";
    public static final String NO_TRANS_ERROR = "Shopping cart is empty!";
    public static final String UPC_NOT_FOUND_ERROR = "Code not found!";
    public static final String SELECT_ERROR = "Choose a product to add!";
    public static final String RECEIPT_ALERT = "Do you want to print receipt?";
    public static final String BALANCE_ALERT = "Balance still remaining!";
    public static final String LOGIN_ALERT = "You sure you want to login?";
    public static final String LOGOUT_ALERT = "You sure you want to logout?";
    public static final String DELETE_ITEM_ALERT = "You sure you want to delete item(s)?";
    public static final String CANCEL_PENDING_ALERT = "You sure you want to cancel this pending transaction?";
    public static final String TIME_IN_CONFIRMATION = "Successfully timed in!";
    public static final String TIME_OUT_CONFIRMATION = "Successfully timed out!";
    public static final String TIME_OUT_ERROR = "Error in timing out!";
    public static final String TIME_IN_ERROR = "Time in record already exists!";
    public static final String START_BREAK_CONFIRMATION = "Start your break?";
    public static final String START_BREAK_INFO = "Your break has started!";
    public static final String END_BREAK_INFO = "Your break has ended!";
    public static final String END_BREAK_CONFIRMATION = "End your break?!";
    public static final String START_BREAK_ERROR = "Error in starting break!";
    public static final String END_BREAK_ERROR = "Error in ending break!";
    public static final String FOR_CASHIER_ONLY = "Time keeping in register is for cashiers only!";
    public static final String FOR_ADMIN_ONLY = "Authorization required!";
    public static final String SAVE_SETTINGS_ALERT = "You sure you want to save settings?";
    
    public static final String POS_EFT_NOT_CONNECTED_ALERT = "No EFT Terminal detected!";
    
    public static final String POS_SETTINGS_FILL_MISSING = "Please fill in missing fields!";

    public static final String BACKGROUND_IMG_SAVED = "New background image saved!";
    public static final String BACKGROUND_IMG_SAVE_FAILED = "Failed in saving background image!";
    
    //POS logic
    public static final int MIN_BARCODE_LENGTH = 13;
    public static final long KEYEVENT_THRESHOLD = 100;
    public static final double VAT = .12;
    public static final String CASH = "cash";
    public static final String CREDIT = "credit";
    public static final String DEBIT = "debit";
    public static final String HELD_TRANS_OPEN = "open";
    public static final String HELD_TRANS_CLOSED = "closed";
    public static final String HELD_TRANS_CANCEL = "cancelled";
    public static final String WAS_HELD_YES = "yes";
    public static final String WAS_HELD_NO = "no";
    
    public static final String RECORD_TYPE_JOB = "job";
    public static final String RECORD_TYPE_BREAK = "break";
    //roles
    public static final String CASHIER = "cashier";
    public static final String ADMIN = "admin";
    public static final String SUPER_ADMIN = "superadmin";
    
    
    //reports
    
    public static final int INVENTORY_REPORT_TYPE = 1;
    public static final int SALES_REPORT_TYPE = 2;
    public static final int TIMEKEEPING_REPORT_TYPE = 3;
    
    public static final String INVENTORY_REPORT = "InventoryReport";
    public static final String SALES_REPORT = "SalesReport";
    public static final String TIMEKEEPING_REPORT = "TimekeepingReport";
    
    public static final String REPORT_GENERATION_SUCCESS = " generated in reports directory!";
    public static final String NO_REPORT = "No report to export!";
    public static final String ERROR_IN_EXPORTING_REPORT = "Error in generating report!";
}

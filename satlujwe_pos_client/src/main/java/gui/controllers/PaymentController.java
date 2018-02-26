/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import satlujwe_pos.Main;
import config.Constant;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import objects.CartItemOBJ;
import pos.receipt.bean.BeanFactory;
import pos.receipt.bean.ReceiptBean;
import pos.receipt.print.helper.ReceiptPrintHelper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import utils.Numbers;
import utils.POSCalendar;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class PaymentController implements Initializable {

    private double amountDue = 0;
    private double balance = 0;
    private double subTotal = 0;
    private double currentVAT = 0;
    private double amountTend = 0;
    private double change = 0;
    private String cashierName = null;
    
    private Alert receiptAlert, posAlert;
    private TextInputDialog cashDialog;
    
    private TextField txtChange;
    @FXML
    private Button btnCash;
    @FXML
    private TextField txtTotalAmount;
    @FXML
    private Button btnCredit;
    @FXML
    private Button btnDebit;
    @FXML
    private Button btnGiftCert;
    @FXML
    private Label lblAmount;
    @FXML
    private Button btnDone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //this.txtChange.setText(String.valueOf(this.change));
    }    
    
    public void setDetails(double amountDue, double subTotal, double vat){
        this.amountDue = Numbers.roundUp(amountDue);
        this.subTotal = Numbers.roundUp(subTotal);
        this.currentVAT = Numbers.roundUp(vat);
        this.txtTotalAmount.setText(Numbers.roundUpS(this.amountDue));
    }
    
    @FXML
    private void payCashAction(ActionEvent event) {
       
       payCash();

    }
    
    @FXML
    private void btnDoneAction(ActionEvent event) {
        
        Main.lcontrol.emptyCart();
        Main.control.updateRegisterTable();

        Main.lcontrol.updateInvoiceNum();
        Main.lcontrol.setCurrHeldID("");
        Main.lcontrol.getCurrentTrans().setWasHeld(Constant.WAS_HELD_NO);
        Main.control.closePayment();
    }
    
    @FXML
    private void payCreditAction(ActionEvent event) {
        
        if(!Main.posControl.isEFTConnected()){
            posAlert = new Alert(Alert.AlertType.WARNING, Constant.POS_EFT_NOT_CONNECTED_ALERT);
            posAlert.show();
        }else {
        
        }
    }
 
    @FXML
    private void payDebitAction(ActionEvent event) {
        if(!Main.posControl.isEFTConnected()){
            posAlert = new Alert(Alert.AlertType.WARNING, Constant.POS_EFT_NOT_CONNECTED_ALERT);
            posAlert.show();
        }else {
            
        }
    }   
    
    
    @FXML
    public void keyListener(KeyEvent event){
        if(null != event.getCode())switch (event.getCode()) {       
            case C: payCash();
               
                break;
            default: System.out.println("you have pressed "+event.getCode().toString());
                break;
                
        }
    }
        
    
    public void payCash(){
    
       cashDialog = new TextInputDialog();
       cashDialog.setTitle("");
       cashDialog.setHeaderText("Please enter amount (no decimal) :");
       
       Optional<String> result = cashDialog.showAndWait();
       List<CartItemOBJ> tempCartItems= null; 
       String tempInvoiceNumber=Main.lcontrol.getCurrInvoiceNum();
       String totalTax = "";
       String grandTotal= amountDue+"";
       
       if(result.isPresent()){ 
             this.amountTend = Double.parseDouble(result.get()) / 100;
             balance = this.amountDue - this.amountTend; 
             Main.lcontrol.getCurrentTrans().setBalance(balance);
             this.cashierName = "User ID#"+Main.lcontrol.getCurrentUser().getUsername()+" - "+Main.lcontrol.getCurrentUser().getLastname()+ " " +Main.lcontrol.getCurrentUser().getFirstname();
             
             Main.lcontrol.getCurrentTrans().setCashier(this.cashierName);
             Main.lcontrol.getCurrentTrans().setInvoiceNum(Main.lcontrol.getCurrInvoiceNum());
             Main.lcontrol.getCurrentTrans().setCashTendered(amountTend);
             Main.lcontrol.getCurrentTrans().setType(Constant.CASH);
             Main.lcontrol.getCurrentTrans().setSubTotal(this.subTotal);
             Main.lcontrol.getCurrentTrans().setTotalAmount(this.amountDue);
             Main.lcontrol.getCurrentTrans().setMonth(POSCalendar.getMonth());
             Main.lcontrol.getCurrentTrans().setYear(POSCalendar.getYear());
             Main.lcontrol.getCurrentTrans().setVat(String.valueOf(this.currentVAT));
             Main.lcontrol.getCurrentTrans().setName(this.cashierName);
             
             if(Main.lcontrol.getCurrentTrans().getBalance() <= 0){

                 this.change = amountTend - this.amountDue;
                 this.change = Numbers.roundUp(this.change);
//                 this.txtChange.setText(Numbers.roundUpS(this.change));

                 Main.lcontrol.getCurrentTrans().setChange(change);
                 Main.lcontrol.getCurrentTrans().setBalance(0);
                 Main.lcontrol.getCurrentTrans().setHasBalance(false);
                 this.lblAmount.setText("Change due");
                 this.txtTotalAmount.setText(Numbers.roundUpS(Main.lcontrol.getCurrentTrans().getChange()));

             } //end if cash tendered is equal or greater than total amount due
             else {
                 //with balance code here
                 this.amountDue = balance;
                 Main.lcontrol.getCurrentTrans().setChange(0);
                 Main.lcontrol.getCurrentTrans().setBalance(balance);
                 Main.lcontrol.getCurrentTrans().setHasBalance(true);
                 this.lblAmount.setText("Balance due");
                 this.txtTotalAmount.setText(Numbers.roundUpS(Main.lcontrol.getCurrentTrans().getBalance()));
                 //this.txtChange.setText(Numbers.roundUpS(Main.lcontrol.getCurrentTrans().getChange()));
             }
             
             //insert transaction
             if(Main.lcontrol.insertTrans()){

                 if(balance <= 0){

                     List<CartItemOBJ> orderList = Main.lcontrol.getCart();
                	 tempCartItems= new ArrayList(orderList);
                	 totalTax = Main.control.getRegControl().getTax()+"";
                     
                     Main.lcontrol.emptyCart();
                     Main.control.updateRegisterTable();

                     Main.lcontrol.updateInvoiceNum();
                     Main.lcontrol.setCurrHeldID("");
                     Main.lcontrol.getCurrentTrans().setWasHeld(Constant.WAS_HELD_NO);
                     
                     /*receiptAlert = new Alert(Alert.AlertType.CONFIRMATION, Constant.RECEIPT_ALERT, ButtonType.YES, ButtonType.NO);
                     receiptAlert.showAndWait();
                     
                     if(receiptAlert.getResult() == ButtonType.YES){
                         //print receipt
                     }
                     else {
                     }*/

                     try {
							prepareReceiptDataAndPrint(tempCartItems, tempInvoiceNumber ,  totalTax,  grandTotal);
						} catch (JRException e) {
							// TODO Auto-generated catch block
							receiptAlert = new Alert(Alert.AlertType.ERROR, Constant.REPORT_PRINT_ERROR);
		                    receiptAlert.show();
						}
                     
                     //Main.control.closePayment();
                     
                 }
                 else {
                     receiptAlert = new Alert(Alert.AlertType.INFORMATION, Constant.BALANCE_ALERT);
                     receiptAlert.show();
                 }
             }
             
        }
        
    }
    
    	private void prepareReceiptDataAndPrint(List<CartItemOBJ> orderList, String invoiceNumber, String totalTax, String grandTotal) throws JRException {
				Map<String, String> parameters= new HashMap<String,String>();
				prepareParameters(parameters,invoiceNumber, totalTax, grandTotal);
				startThreadForPrinting(orderList, parameters);
	}

	private void startThreadForPrinting(List<CartItemOBJ> orderList, Map<String, String> parameters) throws JRException {
		Collection<ReceiptBean> receiptBeanList;
		try {
			receiptBeanList = BeanFactory.getReceiptBean(orderList);
			if (receiptBeanList != null) {
				ReceiptPrintHelper printHelperObj = new ReceiptPrintHelper();
				try {
					 printHelperObj.fillReceiptData(receiptBeanList, parameters);
					// printHelperObj.printReportToPrinter(jsprint);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			throw new JRException("Receipt Cannot be printed :" + e);
		}
	}
	
	private void prepareParameters(Map<String,String> parameters, String invoiceNumber, String totalTax, String grandTotal) {
		parameters.put("storeName",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STORENAME));
		parameters.put("storeAddress1",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STOREADDRESS1));
		parameters.put("storeAddress2",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STOREADDRESS1));
		parameters.put("footerMessage",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_FOOTERMESSAGE));
		parameters.put("subTotal", ""+this.subTotal);
		parameters.put("changeDue", ""+this.change);
		parameters.put("invoiceNumber", invoiceNumber);
		System.out.println("Invoice Number "+invoiceNumber);
		parameters.put("stationNumber", Main.lcontrol.getAppProperties().getProperty(Constant.POS_STATION_NUMBER));
		parameters.put("grandTotal", grandTotal);
		parameters.put("totalTax", totalTax);
		parameters.put("copyType", "***");
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import satlujwe_pos.Main;
import config.Constant;
import gui.model.OrderModel;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import objects.CartItemOBJ;
import objects.HoldTransactionOBJ;
import objects.ProductOBJ;
import utils.Numbers;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class RegisterController implements Initializable {

    private int orderNo = 0;
    private int qty = 0;
    private double grandTotal, subTotal, tax;
    
    private final StringBuffer barcode = new StringBuffer();
    private long lastEventTimeStamp = 0L;
    
    private List rows;
    private ObservableList data;
    private Alert logoutAlert, alert;
    private TextInputDialog qtyChangeDialog;
    private TextInputDialog holdIDDialog;
    private final DateTimeFormatter SHORT_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);
    
    
    
    private TextField txtBarcode;
    private TextField txtQuantity;
    @FXML
    private TableView<OrderModel> tblItems;
    @FXML
    private Button btnPay;
    @FXML
    private Button btnOptions;
    @FXML
    private AnchorPane paymentPane;
    @FXML
    private Label lblSubtotal;
    @FXML
    private Label lblTax;
    @FXML
    private Label lblGrandTotal;
    @FXML
    private Label lblSubVal;
    @FXML
    private Label lblTaxVal;
    @FXML
    private Label lblGrandVal;
    @FXML
    private Label lblCurrentUser;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblCurrentUsertype;
    @FXML
    private GridPane mainGrid;
    @FXML
    private Button btnHold;
    @FXML
    private Button btnVoid;
    @FXML
    private Label lblStation;
    @FXML
    private TableColumn<OrderModel, Integer> colOrder;
    @FXML
    private TableColumn<OrderModel, String> colItemInfo;
    @FXML
    private TableColumn<OrderModel, String> colQuantity;
    @FXML
    private TableColumn<OrderModel, Double> colPrice;
    @FXML
    private TableColumn<OrderModel, String> colTax;
    @FXML
    private Label lblPlaceHolder;
    @FXML
    private TextField txtInput;
    @FXML
    private Button btnReturnItem;
    @FXML
    private Label lblShortcut1;
    @FXML
    private Label lblShortcut2;
    @FXML
    private Label lblShortcut3;
    @FXML
    private Label lblshortcut4;
    @FXML
    private Label lblshortcut5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bindToTime();
        setUserDetails();
        txtSearchListen();
        rows = new ArrayList();
        
        
        colOrder.setCellValueFactory(new PropertyValueFactory<>("OrderNum"));      
        colItemInfo.setCellValueFactory(new PropertyValueFactory<>("ItemInfo"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colTax.setCellValueFactory(new PropertyValueFactory<>("Tax"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        
        colQuantity.setCellFactory(TextFieldTableCell.forTableColumn());
        colQuantity.setOnEditCommit((CellEditEvent<OrderModel, String> t) -> {
            ((OrderModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setQuantity(t.getNewValue());
            System.out.println("New value is "+t.getNewValue());
            qtyChangeButtonAction();
        });
        
    }    
    
    public void setCurrentTime(String time){
        lblTime.setText(time);
        
    }
    
    private void txtSearchListen(){
        
        txtInput.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            //System.out.println(" Text Changed to  " + newValue + ")\n");
            //setSearchResult(newValue);
        });
    
    }
    
    public void setUserDetails(){
        lblStation.setText("Station #"+Main.lcontrol.sysProp.getInstance().getProperty(Constant.POS_STATION_NUMBER).toString());
        lblCurrentUser.setText(Main.lcontrol.getCurrentUser().getUsername());
        lblCurrentUsertype.setText(Main.lcontrol.getCurrentUser().getRole());
    }
    
    private void bindToTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                                                      event -> setCurrentTime(LocalDateTime.now().format(SHORT_TIME_FORMATTER))),
                                         new KeyFrame(Duration.seconds(0)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private void updatePaymentPane(){
    
        this.subTotal = 0;
        this.grandTotal = 0;
        this.tax = 0;
        for (CartItemOBJ it : Main.lcontrol.getCart()) {
            subTotal+=it.getTotalPrice();
            grandTotal+=it.getTotalPrice();
        }
        
        //this.tax = Numbers.roundUp(subTotal * Constant.VAT);
        grandTotal+=this.tax;
        
        this.lblTaxVal.setText("$"+Numbers.roundUpS(this.tax));
        this.lblSubVal.setText("$"+Numbers.roundUpS(this.subTotal));
        this.lblGrandVal.setText("$"+Numbers.roundUpS(this.grandTotal));
    }
    
    public void updateItemTable(){
        
        rows.clear();
        Main.lcontrol.getCart().forEach((it) -> {
            rows.add(new OrderModel(it.getOrderNo(), it.getItemCode()+" @ "+it.getDesc(), ""+it.getQuantity(), Numbers.roundUpS(it.getTotalPrice()), it.getTaxable(), it.getItemCode()));
        });
        data = FXCollections.observableList(rows);
        tblItems.setItems(data);
        
        updatePaymentPane();
        
    }
    
    
    
    //event functions
    @FXML
    private void payButtonAction(ActionEvent event) {

       if(this.grandTotal > 0 && !Main.lcontrol.getCart().isEmpty()){
           if(!Main.control.IsPaymentOpen()){
                Main.control.openPayment(this.grandTotal, this.subTotal, this.tax);
           }
       }
       else {
          alert = new Alert(Alert.AlertType.ERROR, Constant.NO_TRANS_ERROR);
          alert.show();
       }
       
        
    }
    
    private void delButtonAction() {

        if(this.tblItems.getSelectionModel().getSelectedIndex() != -1){

            logoutAlert = new Alert(Alert.AlertType.CONFIRMATION, Constant.DELETE_ITEM_ALERT, ButtonType.YES, ButtonType.NO);
            logoutAlert.showAndWait();
       
            if(logoutAlert.getResult() == ButtonType.YES){
                OrderModel om = tblItems.getSelectionModel().getSelectedItem();
                for (ProductOBJ p : Main.lcontrol.getInventory()){
                    if(p.getITEM_CODE().equalsIgnoreCase(om.getItemCode())){
                        Main.lcontrol.updateCartItem(p, 0, true);
                        Main.control.updateRegisterTable();
                        break;
                    }
                }     
            }
       }
       
        
    }
    
    @FXML
    private void holdButtonAction(ActionEvent event) {
       
            if(!Main.lcontrol.checkHeldTransactions()){
                if(Main.lcontrol.getCurrHeldID().isEmpty()){
                    if(!Main.lcontrol.getCart().isEmpty()){
                        holdIDDialog = new TextInputDialog();
                        holdIDDialog.setHeaderText("Enter HoldID:");
                        Optional<String> holdID = holdIDDialog.showAndWait();
                        if (holdID.isPresent()) {
                            if(!Main.lcontrol.checkifHeldTransactionExisting(holdID.get())){
                                HoldTransactionOBJ ht = new HoldTransactionOBJ();
                                ht.setUserid(Main.lcontrol.getCurrentUser().getUsername());
                                ht.setLoggedBy(Main.lcontrol.getCurrentUser().getFirstname());
                                ht.setInvoice(Main.lcontrol.getCurrInvoiceNum());
                                ht.setheldID(holdID.get());
                                ht.setStatus(Constant.HELD_TRANS_OPEN);

                                if(Main.lcontrol.holdTransaction(ht)){
                                    //changeHoldBtn();
                                    Main.lcontrol.emptyCart();
                                    Main.control.updateRegisterTable();
                                    Main.lcontrol.setCurrHeldID("");
                                    Main.lcontrol.updateInvoiceNum();
                                    Main.lcontrol.getCurrentTrans().setWasHeld(Constant.WAS_HELD_NO);
                                }
                            }else {

                            }
                        }
                    }else {
                        alert = new Alert(Alert.AlertType.ERROR, Constant.NO_TRANS_ERROR);
                        alert.show();
                    }
                }
                else {
                    if(Main.lcontrol.checkifHeldTransactionExisting(Main.lcontrol.getCurrHeldID())){
                        if(Main.lcontrol.openCancelled(Main.lcontrol.getCurrHeldID())){
                            Main.lcontrol.emptyCart();
                            Main.control.updateRegisterTable();
                            Main.lcontrol.setCurrHeldID("");
                            Main.lcontrol.updateInvoiceNum();
                            Main.lcontrol.getCurrentTrans().setWasHeld(Constant.WAS_HELD_NO);
                        }
                    }
                }
            }
            else {
                if(!Main.control.IsheldItemsOpen()){
                    Main.control.openHeldItems();
                }
            }

    }
    
    private void qtyChangeButtonAction() {

       if(this.tblItems.getSelectionModel().getSelectedIndex() != -1){

                try { 
                    OrderModel om = tblItems.getSelectionModel().getSelectedItem();
                    for (ProductOBJ p : Main.lcontrol.getInventory()){
                        if(p.getITEM_CODE().equalsIgnoreCase(om.getItemCode())){
                            Main.lcontrol.updateCartItem(p, Integer.parseInt(om.getQuantity()), true);
                            Main.control.updateRegisterTable();
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    
                }

       }
       
        
    }
   
    @FXML
    public void voidInvoiceButtonAction(ActionEvent event){
        
       alert = new Alert(Alert.AlertType.ERROR, Constant.NOT_YET_SUPPORTED);
       alert.show();
    }
    
    
    @FXML
    private void optionButtonAction(ActionEvent event) {
        
       if(!Main.control.IsOptionsOpen()){
           Main.control.openOptions();
       }
       else {
           
           Main.control.showOptions();
       }
        
    }
    
    /*private void searchButtonAction(ActionEvent event) {
        
       if(this.txtBarcode.getText().isEmpty()){ 
            if(Main.control.IsSearchOpen() == false){
                 Main.control.openInventorySearch();

            }
       }else {
           Main.lcontrol.setCurrUPC(this.txtBarcode.getText());
           try {
                qty = Integer.parseInt(this.txtQuantity.getText());
                if(Main.lcontrol.addToCartbyCode(Main.lcontrol.getCurrUPC(), qty)){
                        this.txtBarcode.setText("");
                        this.txtQuantity.setText("");
                }
                else {
                    alert = new Alert(Alert.AlertType.ERROR, Constant.UPC_NOT_FOUND_ERROR);
                    alert.show();
                }
                
           }catch(NumberFormatException e){
               this.txtQuantity.setText("");
           }
       }
        
    }*/
    
    @FXML
    private void txtInputAction(ActionEvent event) {
        if(!txtInput.getText().isEmpty()){
            String exp = txtInput.getText();
            if(exp.matches(Constant.CART_REGEX)){
                //System.out.println("MATCHES!");
                String result[] = exp.split("x");
                if(Main.lcontrol.addToCartbyCode(result[1].trim(), Integer.parseInt(result[0].trim()))){
                    txtInput.setText("");
                }
                else {
                
                }
                
            }
            else {
                if(Main.lcontrol.addToCartbyCode(exp.trim(), 1)){
                    txtInput.setText("");
                }
                else {
                
                }
            }
        }
    }
    
    @FXML
    public void keyListener(KeyEvent event){
        if(null != event.getCode())switch (event.getCode()) {       
            case DELETE: //System.out.println("you have pressed DELETE!");
                delButtonAction();
                break;
            default: System.out.println("you have pressed "+event.getCode().toString());
                break;
                
        }
        
        long now = Instant.now().toEpochMilli();

        // events must come fast enough to separate from manual input
        if (now - this.lastEventTimeStamp > Constant.KEYEVENT_THRESHOLD) {
            barcode.delete(0, barcode.length());
        }
        this.lastEventTimeStamp = now;

        // ENTER comes as 0x000d
        if (event.getCharacter().charAt(0) == (char) 0x000d) {
            if (barcode.length() >= Constant.MIN_BARCODE_LENGTH) {
                System.out.println("barcode: " + barcode);
                if(Main.lcontrol.addToCartbyCode(barcode.toString().trim(), 1)){
                    txtInput.setText("");
                }
                else {
                
                }
            }
            barcode.delete(0, barcode.length());
        } else {
            barcode.append(event.getCharacter());
        }
            event.consume();

        }
    
    public TableView<OrderModel> getTblItems() {
		return tblItems;
	}
	public void setTblItems(TableView<OrderModel> tblItems) {
		this.tblItems = tblItems;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
}

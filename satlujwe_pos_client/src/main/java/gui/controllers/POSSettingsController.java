/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import config.Constant;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import pos.receipt.print.helper.ReceiptPreviewHandler;
import satlujwe_pos.Main;
import utils.POSFileHandler;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class POSSettingsController implements Initializable {

    Alert alert;
    File file, file2;
    FileChooser chooser;
    ReceiptPreviewHandler handler;
    
    private TextField txtVat;
    @FXML
    private TextField txtStationNumber;
    @FXML
    private TextField txtDBName;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField dbPassword;
    @FXML
    private TextField txtPort;
    @FXML
    private TextField txtHost;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;

    
    private TextField txtInvoicePref;
    @FXML
    private Button btnChoose;
    @FXML
    private TextField txtImage;
    @FXML
    private TextField txtWindowTitle;
    @FXML
    private TextField txtPayShortCut;
    @FXML
    private TextField txtHoldShortCut;
    @FXML
    private TextField txtVoidInvoice;
    @FXML
    private TextField txtReturnItemShortCut;
    @FXML
    private TextField txtOptionsShortCut;
    @FXML
    private Button btnPreview;
    @FXML
    private TextField txtStoreName;
    @FXML
    private TextField txtStreetAddress;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtInvoicePrefix;
    @FXML
    private TextArea txtFooter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtDBName.setText(Main.lcontrol.sysProp.getInstance().getProperty(Constant.DBNAME).toString());
        //txtUsername.setText(Main.lcontrol.sysProp.getInstance().getProperty(Constant.DBUSER).toString());
        //dbPassword.setText(Main.lcontrol.sysProp.getInstance().getProperty(Constant.DBPASS).toString());
        //txtPort.setText(Main.lcontrol.sysProp.getInstance().getProperty(Constant.DBPORT).toString());
        //txtHost.setText(Main.lcontrol.sysProp.getInstance().getProperty(Constant.DBHOST).toString());
        
        //txtVat.setText(Main.lcontrol.getAppProperties().getProperty(Constant.POS_VAT));
        //txtInvoicePref.setText(Main.lcontrol.getAppProperties().getProperty(Constant.POS_INVOICE_PREF));
        txtStationNumber.setText(Main.lcontrol.getAppProperties().getProperty(Constant.POS_STATION_NUMBER));
        txtImage.setText(Main.lcontrol.getAppProperties().getProperty(Constant.POS_BG_IMG));
        txtWindowTitle.setText(Main.lcontrol.getAppProperties().getProperty(Constant.POS_TITLE));
        
        txtPayShortCut.setText(Main.lcontrol.getAppProperties().getProperty(Constant.SHORTCUT_PAY));
        txtHoldShortCut.setText(Main.lcontrol.getAppProperties().getProperty(Constant.SHORTCUT_HOLD));
        txtVoidInvoice.setText(Main.lcontrol.getAppProperties().getProperty(Constant.SHORTCUT_VOID));
        txtReturnItemShortCut.setText(Main.lcontrol.getAppProperties().getProperty(Constant.SHORTCUT_RITEM));
        txtOptionsShortCut.setText(Main.lcontrol.getAppProperties().getProperty(Constant.SHORTCUT_OPTIONS));
        
        txtStoreName.setText(Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STORENAME));
        txtStreetAddress.setText(Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STOREADDRESS1));
        txtCity.setText(Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STOREADDRESS2));
        txtInvoicePrefix.setText(Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_INVOICEPREF));
        txtFooter.setText(Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_FOOTERMESSAGE));
        
    }    
    
    
    
    public boolean validateFields(){
    
        if(!txtDBName.getText().isEmpty() && !txtStationNumber.getText().isEmpty() && !txtPayShortCut.getText().isEmpty() && !txtHoldShortCut.getText().isEmpty() && !txtVoidInvoice.getText().isEmpty() && !txtReturnItemShortCut.getText().isEmpty()
                && !txtOptionsShortCut.getText().isEmpty() && !txtStationNumber.getText().isEmpty() && !txtImage.getText().isEmpty() && !txtWindowTitle.getText().isEmpty() && !txtStoreName.getText().isEmpty() && !txtStreetAddress.getText().isEmpty()&& !txtCity.getText().isEmpty()
                && !txtInvoicePrefix.getText().isEmpty() && !txtFooter.getText().isEmpty()){
            return true;
        }
        else {
            return false;
        }

    }
    
    @FXML
    private void chooseFileAction(ActionEvent event) {
        chooser = new FileChooser();
        chooser.setTitle("Open File");
        
        file = chooser.showOpenDialog(Main.control.getOptions());
        file2 = new File("./setup/"+file.getName());
        
        if(file != null){
            txtImage.setText(file.getName());
        }
        else {
            
        }
    }
    
    @FXML
    private void saveButtonAction(ActionEvent event) {
        
        if(validateFields()){
            alert = new Alert(Alert.AlertType.CONFIRMATION, Constant.SAVE_SETTINGS_ALERT, ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if(alert.getResult() == ButtonType.YES){

               Main.lcontrol.getAppProperties().setProperty(Constant.RECEIPT_INVOICEPREF, txtInvoicePrefix.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.RECEIPT_STORENAME, txtStoreName.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.RECEIPT_STOREADDRESS1, txtStreetAddress.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.RECEIPT_STOREADDRESS2, txtCity.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.RECEIPT_FOOTERMESSAGE, txtFooter.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.SHORTCUT_PAY, txtPayShortCut.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.SHORTCUT_HOLD, txtHoldShortCut.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.SHORTCUT_VOID, txtVoidInvoice.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.SHORTCUT_RITEM, txtReturnItemShortCut.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.SHORTCUT_OPTIONS, txtOptionsShortCut.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.POS_STATION_NUMBER, txtStationNumber.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.POS_TITLE, txtWindowTitle.getText());
               Main.lcontrol.getAppProperties().setProperty(Constant.POS_BG_IMG, txtImage.getText());

               if(file != null && file2 != null){
                    if(POSFileHandler.copyDirectory(file, file2)){
                        try {
                            
                            Main.control.setBackgroundImage(file2, (Region) Main.control.getMainWindow().getScene().getRoot());
                            Main.control.setBackgroundImage(file2, (Region) Main.control.getLoginWindow().getScene().getRoot());
                        } catch (MalformedURLException ex) {
                            Main.control.showErrorMessage(ex.getMessage());
                        }
                    }
                    else {
                         alert = new Alert(Alert.AlertType.ERROR, Constant.BACKGROUND_IMG_SAVED);
                         alert.show();
                    }
               }
               
               if(Main.lcontrol.updateAppProperties(Main.lcontrol.getAppProperties())){
                   Main.lcontrol.refreshAppProperties();
               }
               
               Main.control.closePOSSettings();
            }
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR, Constant.POS_SETTINGS_FILL_MISSING);
            alert.show();
        }
        
    }
    
    @FXML
    private void openReceiptPreview(){   
    
        //show receipt preview
        handler = new ReceiptPreviewHandler();
        
    }
    
    @FXML
    private void cancelButtonAction(ActionEvent event) {
        if(Main.control.IsPOSSettingsOpen()){
            Main.control.closePOSSettings();
        }
        
    }
    
}

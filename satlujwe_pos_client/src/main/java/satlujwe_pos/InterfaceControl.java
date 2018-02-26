/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satlujwe_pos;

import config.Constant;
import gui.controllers.CashierClockerController;
import gui.controllers.HeldItemsController;
import gui.controllers.InitController;
import gui.controllers.OptionsController;
import gui.controllers.POSDatePickerController;
import gui.controllers.POSSettingsController;
import gui.controllers.PaymentController;
import gui.controllers.ReceiptPreviewController;
import gui.controllers.RegisterController;
import gui.controllers.ReportsController;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.POSFileHandler;

/**
 *
 * @author ETDelacruz
 * 
 * class for controlling instances of windows
 */
public class InterfaceControl implements Constant{

    private Parent root;
    private final Stage main;
    private final Stage login;
    private final Stage inventorySearch;
    private final Stage payments;
    private final Stage heldItems;
    private final Stage optionsWindow;
    private final Stage timeKeeping;
    private final Stage posSettings;
    private final Stage reports;
    private final Stage singleDatePicker;
    private final Stage receiptPreview;
    private Alert showError;
    
    private FXMLLoader initLoader;
    private FXMLLoader mainLoader;
    private FXMLLoader searchInventoryLoader;
    private FXMLLoader paymentLoader;
    private FXMLLoader heldLoader;
    private FXMLLoader optionLoader;
    private FXMLLoader timekeepingLoader;
    private FXMLLoader posSettingsLoader;
    private FXMLLoader reportsLoader;
    private FXMLLoader singleDatePickerLoader;
    private FXMLLoader receiptPreviewLoader;
    
    private RegisterController regControl;
    //private SearchInventoryController searchControl;
    private InitController initControl;
    private PaymentController paymentControl;
    private HeldItemsController helditemsControl;
    private OptionsController optionsControl;
    private CashierClockerController timekeepControl;
    private POSSettingsController posSettingsControl;
    private ReportsController reportsControl;
    private POSDatePickerController sdatePickerControl;
    private ReceiptPreviewController rPreviewControl;
    
    public InterfaceControl(){
        
        main = new Stage();
        login = new Stage();
        inventorySearch = new Stage();
        payments = new Stage();
        heldItems = new Stage();
        optionsWindow = new Stage();
        timeKeeping = new Stage();
        posSettings = new Stage();
        reports = new Stage();
        singleDatePicker = new Stage();
        receiptPreview = new Stage();
        
        //set ownership
        //main.initOwner(login);
        inventorySearch.initOwner(main);
        payments.initOwner(main);
        heldItems.initOwner(main);
        optionsWindow.initOwner(main);
        timeKeeping.initOwner(optionsWindow);
        posSettings.initOwner(optionsWindow);
        reports.initOwner(optionsWindow);
        singleDatePicker.initOwner(reports);
        receiptPreview.initOwner(posSettings);
        
        inventorySearch.initModality(Modality.WINDOW_MODAL);
        payments.initModality(Modality.WINDOW_MODAL);
        heldItems.initModality(Modality.WINDOW_MODAL);
        optionsWindow.initModality(Modality.APPLICATION_MODAL);
        timeKeeping.initModality(Modality.WINDOW_MODAL);
        posSettings.initModality(Modality.WINDOW_MODAL);
        reports.initModality(Modality.WINDOW_MODAL);
        singleDatePicker.initModality(Modality.WINDOW_MODAL);
        receiptPreview.initModality(Modality.WINDOW_MODAL);
    }
      
    public boolean IsMainOpen() {
        return main.isShowing();
    }

    public boolean IsLoginOpen() {
        return login.isShowing();
    }
    
    public boolean IsSearchOpen() {
        return inventorySearch.isShowing();
    }
    
    public boolean IsPaymentOpen() {
        return payments.isShowing();
    }
    
    public boolean IsheldItemsOpen() {
        return heldItems.isShowing();
    }
    
    public boolean IsOptionsOpen() {
        return optionsWindow.isShowing();
    }
    
    public boolean IsClockerOpen() {
        return timeKeeping.isShowing();
    }
    
    public boolean IsPOSSettingsOpen() {
        return posSettings.isShowing();
    }

    public boolean IsReportsOpen() {
        return reports.isShowing();
    }
    
    public boolean IsSingleDatePickerOpen() {
        return singleDatePicker.isShowing();
    }
    
    public boolean IsReceiptPreviewOpen() {
        return receiptPreview.isShowing();
    }
    
    public Stage getMainWindow() {
        return main;
    }

    public Stage getLoginWindow() {
        return login;
    }
    
    public Stage getOptions() {
        return optionsWindow;
    }
    
    public void closeLogin(){
        this.login.close();
    }
    
    public void closeMainWindow(){
        this.main.close();
    }  
    
    public void closeSearch(){
        this.inventorySearch.close();
    }  
    
    public void closePayment(){
        this.payments.close();
    }  
    
     public void closeHeldItems(){
        this.heldItems.close();
    }  
     
    public void closeOptions(){
        this.optionsWindow.close();
    }  
    
    public void closeClocker(){
        this.timeKeeping.close();
    }
    
    public void closePOSSettings(){
        this.posSettings.close();
    }
    
    public void closeReports(){
        this.reports.close();
    }
    
    public void closeSingleDatePicker(){
        this.singleDatePicker.close();
    }
    
    public void closeReceiptPreview() {
        receiptPreview.close();
    }
    
    public void showLogin(){
        this.login.show();
    }
    
    public void showMainWindow(){
        this.main.show();
    }
    
    public void showSearch(){
        this.inventorySearch.show();
    }
    
    public void showHeldItems(){
        this.heldItems.show();
    }
    
    public void showOptions(){
        this.optionsWindow.show();
    }
    
   
    
    public void showTimekeep(){
        this.timeKeeping.show();
    }
    
    public void showPOSSettings(){
        this.posSettings.show();
    }
    
    public void showReports(){
        this.reports.show();
    }
    
    public void showSingleDatePicker(){
        this.singleDatePicker.show();
    }
    
    public void showReceiptPreview() {
        receiptPreview.show();
    }
    
    public void closeAll(){
        this.closeClocker();
        this.closeHeldItems();
        this.closeOptions();
        this.closePayment();
        this.closeSearch();
        this.closePOSSettings();
        this.closeReports();
        this.closeSingleDatePicker();
        this.closeReceiptPreview();
        this.closeMainWindow();
    }
    
    public void openLogin(){
    
      try {
          
           //System.out.println("Pumasok!");
           initLoader = new FXMLLoader(getClass().getResource(LOGIN_FXML_PATH));
           root = (Parent) initLoader.load();
           
           initControl = (InitController) initLoader.getController();
           
           
           
           login.setTitle(Main.lcontrol.sysProp.getInstance().getProperty(POS_TITLE).toString());
           login.setResizable(true);
           login.setMaximized(false);
           login.setScene(new Scene(root));
           
           this.setBackgroundImage(POSFileHandler.getBGImageFile(Main.lcontrol.sysProp.getInstance().getProperty(POS_BG_IMG).toString()), (Region) login.getScene().getRoot());
           login.show();
           
      } catch (IOException ex) {
          Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" : "+ex.toString());
      }
    }
    
    public void openMainWindow(){
    
      try {
           mainLoader = new FXMLLoader(getClass().getResource(MW_FXML_PATH));
           root = (Parent) mainLoader.load();        
           
           regControl = (RegisterController) mainLoader.getController();
           
           main.setTitle(Main.lcontrol.sysProp.getInstance().getProperty(POS_TITLE).toString());
           main.setResizable(true);
           main.setMaximized(false);
           main.setScene(new Scene(root));
           this.setBackgroundImage(POSFileHandler.getBGImageFile(Main.lcontrol.sysProp.getInstance().getProperty(POS_BG_IMG).toString()), (Region) main.getScene().getRoot());
           main.show();
           
      } catch (IOException ex) {
          Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" : "+ex.toString());
      }
    }
    
   /* public void openInventorySearch(){
    
      try {
           searchInventoryLoader = new FXMLLoader(getClass().getResource(IS_FXML_PATH));
           root = (Parent) searchInventoryLoader.load();
           
           searchControl = (SearchInventoryController) searchInventoryLoader.getController();
           
           inventorySearch.setTitle("Search Inventory");
           inventorySearch.setResizable(false);
           inventorySearch.setScene(new Scene(root));
           inventorySearch.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" : "+ex.toString());
      }
    }*/
    
    public void openPayment(double amountDue, double subTotal, double vat){
    
      try {
           paymentLoader = new FXMLLoader(getClass().getResource(PAYMENT_FXML_PATH));
           root = (Parent) paymentLoader.load();
           
           paymentControl = (PaymentController) paymentLoader.getController();
           paymentControl.setDetails(amountDue, subTotal, vat);
           
           payments.setTitle("Payment");
           payments.setResizable(false);
           payments.setScene(new Scene(root));
           payments.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" : "+ex.toString());
      }
    }
    
    public void openHeldItems(){
    
      try {
           heldLoader = new FXMLLoader(getClass().getResource(HELDITEM_FXML_PATH));
           root = (Parent) heldLoader.load();
           
           helditemsControl = (HeldItemsController) heldLoader.getController();
           
           
           heldItems.setTitle("Held Transactions");
           heldItems.setResizable(false);
           heldItems.setScene(new Scene(root));
           heldItems.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" : "+ex.toString());
      }
    }
    
    public void openOptions(){
    
      try {
           optionLoader = new FXMLLoader(getClass().getResource(OPTIONS_FXML_PATH));
           root = (Parent) optionLoader.load();
           
           optionsControl = (OptionsController) optionLoader.getController();
           
           
           optionsWindow.setTitle("Options");
           optionsWindow.setResizable(false);
           optionsWindow.setScene(new Scene(root));
           optionsWindow.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" openOptions : "+ex.toString());
      }
    }
    
    public void openClocker(){
    
      try {
           timekeepingLoader = new FXMLLoader(getClass().getResource(CLOCKER_FXML_PATH));
           root = (Parent) timekeepingLoader.load();
           
           timekeepControl = (CashierClockerController) timekeepingLoader.getController();
           
           
           timeKeeping.setTitle("Clocker");
           timeKeeping.setResizable(false);
           timeKeeping.setScene(new Scene(root));
           timeKeeping.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" openClocker : "+ex.toString());
      }
    }
    
    public void openPOSSettings(){
    
      try {
           posSettingsLoader = new FXMLLoader(getClass().getResource(POSSETTINGS_FXML_PATH));
           root = (Parent) posSettingsLoader.load();
           
           posSettingsControl = (POSSettingsController) posSettingsLoader.getController();
           
           
           posSettings.setTitle("Clocker");
           posSettings.setResizable(false);
           posSettings.setScene(new Scene(root));
           posSettings.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" openPOSSettings : "+ex.toString());
      }
    }
    
    
    public void openReports(){
    
      try {
           reportsLoader = new FXMLLoader(getClass().getResource(REPORTS_FXML_PATH));
           root = (Parent) reportsLoader.load();
           
           reportsControl = (ReportsController) reportsLoader.getController();
           
           
           reports.setTitle("Reports");
           reports.setResizable(true);
           reports.setScene(new Scene(root));
           reports.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" openReports : "+ex.toString());
      }
    }
    
    
    public void openSingleDatePicker(){
    
      try {
           singleDatePickerLoader = new FXMLLoader(getClass().getResource(SDATE_PICKER_FXML_PATH));
           root = (Parent) singleDatePickerLoader.load();
           
           sdatePickerControl =  (POSDatePickerController) singleDatePickerLoader.getController();
           
           
           singleDatePicker.setTitle("Select date..");
           singleDatePicker.setResizable(false);
           singleDatePicker.setScene(new Scene(root));
           singleDatePicker.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" openSingleDatePicker : "+ex.toString());
      }
    }
    
    
    public void openReceiptPreview(String receiptFormat){
    
      try {
           receiptPreviewLoader = new FXMLLoader(getClass().getResource(SDATE_PICKER_FXML_PATH));
           root = (Parent) receiptPreviewLoader.load();
           
           rPreviewControl =  (ReceiptPreviewController) receiptPreviewLoader.getController();
           
           
           receiptPreview.setTitle("Receipt Preview..");
           receiptPreview.setResizable(false);
           receiptPreview.setScene(new Scene(root));
           receiptPreview.show();
           
      } catch (IOException ex) {
           Logger.getLogger(InterfaceControl.class.getName()).log(Level.SEVERE, null, ex);
           Main.control.showErrorMessage(this.toString() +" openReceiptPreview : "+ex.toString());
      }
    }
    
    
    public void setBackgroundImage(File file, Region region) throws MalformedURLException {
        Image image = new Image(file.toURI().toURL().toExternalForm());
        
        region.setBackground(new Background(new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        )));
        
    }
    
    public void updateRegisterTable(){
        regControl.updateItemTable();
    }
    
        
    public void showErrorMessage(String message){
        showError = new Alert(Alert.AlertType.ERROR, message);
        showError.show();
    }

    public FXMLLoader getInitLoader() {
        return initLoader;
    }

    public FXMLLoader getMainLoader() {
        return mainLoader;
    }
    
    public void setBGImage(){
        
    }
    
    public RegisterController getRegControl() {
		return regControl;
	}
    
    public void setRegControl(RegisterController regControl) {
		this.regControl = regControl;
	}
    
    public ReportsController getReportController(){
        return reportsControl;
    }
   
}

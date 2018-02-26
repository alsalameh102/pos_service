/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import config.Constant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import satlujwe_pos.Main;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class OptionsController implements Initializable {

    
    private Alert alert;
    @FXML
    private TabPane tabPane;
    @FXML
    private Button btnTimeKeeping;
    @FXML
    private Button btnChangeCashierAct;
    @FXML
    private Button btnDisplayHold;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnReports;
    @FXML
    private Button btnUserAccounts;
    @FXML
    private Button btnSettings;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void clockerButtonAction(ActionEvent event) {
       if(Main.lcontrol.getCurrentUser().getRole().equalsIgnoreCase(Constant.CASHIER)){ 
            if(!Main.control.IsClockerOpen()){
                Main.control.openClocker();
            }
            else {
                Main.control.showTimekeep();
            }
       }
       else {
           alert = new Alert(Alert.AlertType.ERROR, Constant.FOR_CASHIER_ONLY);
           alert.show();
       }
        
    }
    
    @FXML
    private void adminTabAction(Event event) {
       if(Main.lcontrol.getCurrentUser().getRole().equalsIgnoreCase(Constant.ADMIN) || Main.lcontrol.getCurrentUser().getRole().equalsIgnoreCase(Constant.SUPER_ADMIN)){ 
            
       }
       else {
           tabPane.getSelectionModel().select(0);
           alert = new Alert(Alert.AlertType.ERROR, Constant.FOR_ADMIN_ONLY);
           alert.show();
       }
        
    }
    
    
    @FXML
    private void onholdButtonAction(ActionEvent event) {
        
       if(!Main.control.IsheldItemsOpen()){
                    Main.control.openHeldItems();
       }
 
    }
    
    @FXML
    private void changeActButtonAction(ActionEvent event) {
        
       alert = new Alert(Alert.AlertType.ERROR, Constant.NOT_YET_SUPPORTED);
       alert.show();
 
    }
    
    @FXML
    private void reportsButtonAction(ActionEvent event) {
        
       if(!Main.control.IsReportsOpen()){
           Main.control.openReports();
       }
 
    }
    
    @FXML
    private void userActButtonAction(ActionEvent event) {
        
       alert = new Alert(Alert.AlertType.ERROR, Constant.NOT_YET_SUPPORTED);
       alert.show();
 
    }
    
    @FXML
    private void settingsButtonAction(ActionEvent event) {
        
       if(!Main.control.IsPOSSettingsOpen()){
           Main.control.openPOSSettings();
       }
    }
    
    @FXML
    private void exitButtonAction(ActionEvent event) {
        
       alert = new Alert(Alert.AlertType.CONFIRMATION, Constant.LOGOUT_ALERT, ButtonType.YES, ButtonType.NO);
       alert.showAndWait();
       
       if(alert.getResult() == ButtonType.YES){
           Main.lcontrol.resetAll();
           Main.control.closeAll();
           Main.control.showLogin();
       }
        
    
 
    }
    
}

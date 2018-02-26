/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import config.Constant;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.util.Duration;
import satlujwe_pos.Main;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class CashierClockerController implements Initializable {

    private final DateTimeFormatter SHORT_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);
    Alert error, alert, breakAlert, logoutAlert;
    
    @FXML
    private Button btnClockIn;
    @FXML
    private Button btnLeave;
    @FXML
    private Button btnClockout;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnEmergency;
    @FXML
    private Button btnCancel;
    @FXML
    private Label lblTimestamp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bindToTime();
    }    
    
    public void setCurrentTime(String time){
        lblTimestamp.setText(time);
        
    }
    
    private void bindToTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                                                      event -> setCurrentTime(LocalDateTime.now().format(SHORT_TIME_FORMATTER))),
                                         new KeyFrame(Duration.seconds(0)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    
    @FXML
    private void clockInBtnAction(ActionEvent event) {
       
        if(Main.lcontrol.getCurrentUser().getRole().equalsIgnoreCase(Constant.CASHIER)){
            logoutAlert = new Alert(Alert.AlertType.CONFIRMATION, Constant.LOGIN_ALERT, ButtonType.YES, ButtonType.NO);
            logoutAlert.showAndWait();

            if(logoutAlert.getResult() == ButtonType.YES){ 
                      if(Main.lcontrol.createNewTimeRecord()){
                          alert = new Alert(Alert.AlertType.INFORMATION, Constant.TIME_IN_CONFIRMATION);
                          alert.show();
                          Main.control.closeClocker();
                          
                      }else {
                          error = new Alert(Alert.AlertType.ERROR, Constant.TIME_IN_ERROR);
                          error.show();
                      }
            }
       }
       else {
                alert = new Alert(Alert.AlertType.ERROR, Constant.FOR_CASHIER_ONLY);
                alert.show();
       }
        
    }
    
    @FXML
    private void clockOutBtnAction(ActionEvent event) {
       if(Main.lcontrol.getCurrentUser().getRole().equalsIgnoreCase(Constant.CASHIER)){
            logoutAlert = new Alert(Alert.AlertType.CONFIRMATION, Constant.LOGOUT_ALERT, ButtonType.YES, ButtonType.NO);
            logoutAlert.showAndWait();
       
            if(logoutAlert.getResult() == ButtonType.YES){


                     if(!Main.lcontrol.updateTimeRecord()){
                         alert = new Alert(Alert.AlertType.ERROR, Constant.TIME_OUT_ERROR);
                         alert.show();      
                     }else {
                         Main.lcontrol.resetAll();
                         Main.control.closeAll();
                         Main.control.showLogin();
                     }
            }
       }else {
               alert = new Alert(Alert.AlertType.ERROR, Constant.FOR_CASHIER_ONLY);
               alert.show();
       }

    }
    
    @FXML
    private void leaveBrkBtnAction(ActionEvent event) {
       if(Main.lcontrol.getCurrentUser().getRole().equalsIgnoreCase(Constant.CASHIER)){
            breakAlert = new Alert(Alert.AlertType.CONFIRMATION, Constant.START_BREAK_CONFIRMATION, ButtonType.YES, ButtonType.NO);
            breakAlert.showAndWait();

            if(breakAlert.getResult() == ButtonType.YES){
                if(!Main.lcontrol.createNewBreakRecord()){
                    alert = new Alert(Alert.AlertType.ERROR, Constant.START_BREAK_ERROR);
                    alert.show();
                } 
                else {
                    alert = new Alert(Alert.AlertType.INFORMATION, Constant.START_BREAK_INFO);
                    alert.show();
                    Main.control.closeClocker();
                }

            }
       }else {
           alert = new Alert(Alert.AlertType.ERROR, Constant.FOR_CASHIER_ONLY);
           alert.show();
       }
  
    }
    
    @FXML
    private void backBrkBtnAction(ActionEvent event) {
       if(Main.lcontrol.getCurrentUser().getRole().equalsIgnoreCase(Constant.CASHIER)){ 
            breakAlert = new Alert(Alert.AlertType.CONFIRMATION, Constant.END_BREAK_CONFIRMATION, ButtonType.YES, ButtonType.NO);
            breakAlert.showAndWait();

            if(breakAlert.getResult() == ButtonType.YES){
                if(!Main.lcontrol.updateBreakRecord()){
                    alert = new Alert(Alert.AlertType.ERROR, Constant.END_BREAK_ERROR);
                    alert.show();
                }
                else {
                    alert = new Alert(Alert.AlertType.INFORMATION, Constant.END_BREAK_INFO);
                    alert.show();
                    Main.control.closeClocker();
                }

            }
       }
       else {
           alert = new Alert(Alert.AlertType.ERROR, Constant.FOR_CASHIER_ONLY);
           alert.show();
       }
        
    }
    
    @FXML
    private void emergencyBtnAction(ActionEvent event) {
        
       alert = new Alert(Alert.AlertType.ERROR, Constant.NOT_YET_SUPPORTED);
       alert.show();
        
    }
    
    @FXML
    private void cancelBtnAction(ActionEvent event) {
        
       if(Main.control.IsClockerOpen()){
           Main.control.closeClocker();
       }
       
        
    }
    
}

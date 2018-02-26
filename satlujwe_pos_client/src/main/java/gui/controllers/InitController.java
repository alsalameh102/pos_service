/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import satlujwe_pos.Main;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class InitController implements Initializable {

    //private UserValidation uv = new UserValidation();
    private DateTimeFormatter SHORT_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);

    private Alert alert;
    @FXML
    private Button btnSignIn;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblStationNo;
    @FXML
    private Label lblTimeStamp;
    @FXML
    private GridPane gridPane;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bindToTime();
        
        lblStationNo.setText("Station #"+Main.lcontrol.sysProp.getInstance().getProperty(Constant.POS_STATION_NUMBER).toString());
    }    
    
    
    
    
    @FXML
    private void signInButtonAction(ActionEvent event) {
        
        String username, password;
        
        username = txtUser.getText();
        password = txtPassword.getText();
        
        if(!username.isEmpty() && !password.isEmpty()){
            if(Main.lcontrol.getUser(username, password)){
                //System.out.println(username+" exists!");
                if(Main.control.IsMainOpen() == false){
                    Main.control.openMainWindow();
                    Main.control.closeLogin();
                    resetLogin();
                }
            }
            else {
                alert = new Alert(Alert.AlertType.ERROR, Constant.LOGIN_ERROR);
                alert.show();
            }
        }else {
        
        }
        
    }
    
    public void setCurrentTime(String time){
            lblTimeStamp.setText(time);
    }
    
    private void bindToTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                                                      event -> setCurrentTime(LocalDateTime.now().format(SHORT_TIME_FORMATTER))),
                                         new KeyFrame(Duration.seconds(0)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private void resetLogin(){
        txtUser.requestFocus();
        txtUser.setText(Constant.EMPTY_STRING);
        txtPassword.setText(Constant.EMPTY_STRING);
    }
    
}

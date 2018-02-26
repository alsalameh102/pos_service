/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import satlujwe_pos.Main;
import utils.POSCalendar;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class POSDatePickerController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private Button btnGenerate;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        datePicker.setValue(LocalDate.now());
    }    
 
    @FXML
    public void generateReportbtnAction(ActionEvent event){
       // Main.control.getReportController().getTblReport().setItems(Main.lcontrol.getTimeKeeping(POSCalendar.getYYYYMMDD2(datePicker.getValue())));
        Main.control.closeSingleDatePicker();
    }
    
    @FXML
    public void cancelbtnAction(ActionEvent event){
        Main.control.closeSingleDatePicker();
    }
}

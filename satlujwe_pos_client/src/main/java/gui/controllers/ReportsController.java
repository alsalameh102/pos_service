/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import config.Constant;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import satlujwe_pos.Main;
import utils.POSCalendar;
import utils.POSFileHandler;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class ReportsController implements Initializable {

    @FXML
    private Button btnExportToCSV;
    @FXML
    private Button btnExportToPDF;
    @FXML
    private TableView tblReport;

    private ObservableList<ObservableList> data;
    private int reportType = 0;
    
    private Alert alert;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public TableView getTblReport(){
        return tblReport;
    }
    
    
    @FXML
    private void inventoryMenuItemAction(ActionEvent event) {
        
        //tblReport = new TableView();
        reportType = Constant.INVENTORY_REPORT_TYPE;
        setTableReportContent();
    } 
    
    @FXML
    private void timekeepingTodayMenuItemAction(ActionEvent event) {
        
        //tblReport = new TableView();
        reportType = Constant.TIMEKEEPING_REPORT_TYPE;
        //tblReport.setItems(Main.lcontrol.getTimeKeeping(POSCalendar.getYYYYMMDD2(LocalDate.now())));
    } 
    
    @FXML
    private void timekeepingSpecDayMenuItemAction(ActionEvent event) {
        
        //tblReport = new TableView();
        reportType = Constant.TIMEKEEPING_REPORT_TYPE;
        //setTableReportContent();
        if(!Main.control.IsSingleDatePickerOpen()){
            Main.control.openSingleDatePicker();
        }
    } 
    
    @FXML
    private void overallSalesReportAction(ActionEvent event) {
        
        //tblReport = new TableView();
        reportType = Constant.SALES_REPORT_TYPE;
        //tblReport.setItems(Main.lcontrol.getOverallSalesR(tblReport));
    } 
    
    @FXML
    public void cashierSalesReportAction(ActionEvent event){
        alert = new Alert(Alert.AlertType.ERROR, Constant.NOT_YET_SUPPORTED);
        alert.show();
    }
    
    @FXML
    public void productSalesReportAction(ActionEvent event){
        alert = new Alert(Alert.AlertType.ERROR, Constant.NOT_YET_SUPPORTED);
        alert.show();
    }
    
    public void setTableReportContent(){
    
        //tblReport.setItems(Main.lcontrol.getInventoryR(tblReport));
    }
    
    
    @FXML
    private void exportToCSVAction(ActionEvent event) {
        
        String csvFile = ".csv";
        String intro = "";
        
        switch(reportType){
            case Constant.INVENTORY_REPORT_TYPE: csvFile = POSCalendar.getYYYYMMDD()+Constant.INVENTORY_REPORT+csvFile; break;
            case Constant.SALES_REPORT_TYPE: csvFile = POSCalendar.getYYYYMMDD()+Constant.SALES_REPORT+csvFile; break;
            case Constant.TIMEKEEPING_REPORT_TYPE: csvFile = POSCalendar.getYYYYMMDD()+Constant.TIMEKEEPING_REPORT+csvFile; break;
            default : 
        }
        
        if(reportType != 0){
            if(POSFileHandler.writeExcel(tblReport, csvFile, intro)){
                alert = new Alert(Alert.AlertType.INFORMATION, csvFile+Constant.REPORT_GENERATION_SUCCESS);
                alert.show();
            }
            else {
                alert = new Alert(Alert.AlertType.ERROR, Constant.ERROR_IN_EXPORTING_REPORT);
                alert.show();
            }
        }
        else {
            alert = new Alert(Alert.AlertType.WARNING, Constant.NO_REPORT);
            alert.show();
        }
    } 
    
    @FXML
    public void exportToPDFAction(ActionEvent event){
        alert = new Alert(Alert.AlertType.ERROR, Constant.NOT_YET_SUPPORTED);
        alert.show();
    }
    
}

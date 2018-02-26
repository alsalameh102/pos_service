/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import satlujwe_pos.Main;
import config.Constant;
import gui.model.HoldTransModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import objects.HoldTransactionOBJ;

/**
 * FXML Controller class
 *
 * @author ETDelacruz
 */
public class HeldItemsController implements Initializable {

    List rows;
    ObservableList data;
    TextInputDialog holdIDDialog;
    Alert error, alert;
    
    @FXML
    private TableView<HoldTransModel> tblHold;
    @FXML
    private Button btnSelect;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnDelete;
    @FXML
    private TableColumn<HoldTransModel, String> colHoldID;
    @FXML
    private TableColumn<HoldTransModel, String> colInvoice;
    @FXML
    private TableColumn<HoldTransModel, String> colTimeStamp;
    @FXML
    private TableColumn<HoldTransModel, String> colEmp;
    @FXML
    private Button btnHold;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initHoldTable();
    }    
    
    public void initHoldTable(){
    
        colHoldID.setCellValueFactory(new PropertyValueFactory<>("OnHoldID"));
        colInvoice.setCellValueFactory(new PropertyValueFactory<>("Invoice"));
        colTimeStamp.setCellValueFactory(new PropertyValueFactory<>("TimeStamp"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("Employee"));
        this.tblHold.setItems(getPendingTrans());
    }
    
    private ObservableList getPendingTrans(){
        rows = new ArrayList();
        
        for (HoldTransactionOBJ ht : Main.lcontrol.getPendingTrans()) {
            System.out.println(ht.getInvoice());
            rows.add(new HoldTransModel(ht.getheldID(), ht.getInvoice(), ht.getCreatedAt().toString(), ht.getLoggedBy()));
        }
        data = FXCollections.observableList(rows);
        
        return data;
    }
    
    
    //events
    @FXML
    private void holdBtnAction(ActionEvent event) {
        
        if(!Main.lcontrol.getCart().isEmpty()){
            holdIDDialog = new TextInputDialog();
            holdIDDialog.setHeaderText("Enter HoldID for the current transaction:");
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
                        Main.lcontrol.emptyCart();
                        Main.control.updateRegisterTable();
                        Main.lcontrol.setCurrHeldID("");
                        Main.lcontrol.updateInvoiceNum();
                        Main.lcontrol.getCurrentTrans().setWasHeld(Constant.WAS_HELD_NO);
                        //Main.control.updateHoldBtn();
                        this.tblHold.setItems(getPendingTrans());
                    }
                }else {
                    error = new Alert(Alert.AlertType.ERROR, Constant.HOLDID_EXISTS_ERROR);
                    error.show();
                }
            }
        }
        else {
            error = new Alert(Alert.AlertType.ERROR, Constant.NO_TRANS_ERROR);
            error.show();
        }
    }
    
    @FXML
    private void delBtnAction(ActionEvent event) {
        
        if(tblHold.getSelectionModel().getSelectedIndex() != -1){
            alert = new Alert(Alert.AlertType.CONFIRMATION, Constant.CANCEL_PENDING_ALERT, ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
       
            if(alert.getResult() == ButtonType.YES){
                String heldID = tblHold.getSelectionModel().getSelectedItem().getOnHoldID().trim();
                if(Main.lcontrol.cancelPending(heldID)){
                    this.tblHold.setItems(getPendingTrans());
                    //Main.control.updateHoldBtn();
                }
            }
        }
    }
    
    @FXML
    private void selectBtnAction(ActionEvent event) {
    
        if(tblHold.getSelectionModel().getSelectedIndex() != -1){
            String heldID = tblHold.getSelectionModel().getSelectedItem().getOnHoldID().trim();
            if(Main.lcontrol.closePending(heldID)){
                Main.lcontrol.loadCart(heldID);
                Main.control.updateRegisterTable();
                Main.lcontrol.getCurrentTrans().setWasHeld(Constant.WAS_HELD_YES);
                Main.lcontrol.setCurrHeldID(heldID);
                Main.lcontrol.setInvoiceNum(tblHold.getSelectionModel().getSelectedItem().getInvoice());
                if(Main.control.IsheldItemsOpen()){
                    Main.control.closeHeldItems();
                }
            }
            else {
                error = new Alert(Alert.AlertType.ERROR, "GENERIC : Select BTN Action Error");
                error.show();
            }
        }
    }
    
    @FXML
    private void cancelBtnAction(ActionEvent event) {
        if(Main.control.IsheldItemsOpen()){
            Main.control.closeHeldItems();
        }
    }
    
}

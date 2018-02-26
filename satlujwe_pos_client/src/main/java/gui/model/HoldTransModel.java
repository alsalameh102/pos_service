/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;


import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ETDelacruz
 */
public class HoldTransModel {
    
    private final SimpleStringProperty onHoldID;
    private final SimpleStringProperty Invoice;
    private final SimpleStringProperty TimeStamp;
    private final SimpleStringProperty Employee;
    
    public HoldTransModel(String onHoldID, String iv, String ts, String emp){
        this.onHoldID = new SimpleStringProperty(onHoldID);
        this.Invoice = new SimpleStringProperty(iv);
        this.TimeStamp = new SimpleStringProperty(ts);
        this.Employee = new SimpleStringProperty(emp);
            
    }
    
    public String getOnHoldID(){
        return this.onHoldID.get();
    }
    
    public void setOnHoldID(String heldID){
        this.onHoldID.set(heldID);
    }
    
    public String getInvoice(){
        return this.Invoice.get();
    }
    
    public void setInvoice(String Invoice){
        this.Invoice.set(Invoice);
    }
    
    public String getTimeStamp(){
        return this.TimeStamp.get();
    }
    
    public void setTimeStamp(String timeStamp){
        this.TimeStamp.set(timeStamp);
    }
    
    public String getEmployee(){
        return this.Employee.get();
    }
    
    public void setEmployee(String emp){
        this.Employee.set(emp);
    }
    
}

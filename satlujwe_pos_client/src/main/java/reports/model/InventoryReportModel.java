/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ETDelacruz
 */
public class InventoryReportModel extends Report {
    
    private final SimpleStringProperty itemCode;
    private final SimpleStringProperty prodName;
    private final SimpleIntegerProperty qtyOnFlr;
    private final SimpleIntegerProperty qtyOffFlr;
    
    public InventoryReportModel(String itemCode, String prodName, int qtyOnFlr, int qtyOffFlr){
        this.itemCode = new SimpleStringProperty(itemCode);
        this.prodName = new SimpleStringProperty(prodName);
        this.qtyOnFlr = new SimpleIntegerProperty(qtyOnFlr);
        this.qtyOffFlr = new SimpleIntegerProperty(qtyOffFlr);
   
    }

    public String getItemCode() {
        return itemCode.get();
    }
    
    public void setItemCode(String itemCode){
        this.itemCode.set(itemCode);
    }

    public String getProductName() {
        return prodName.get();
    }
    
    public void setProductName(String prodName){
        this.prodName.set(prodName);
    }

    public int getQuantityOnFlr() {
        return qtyOnFlr.get();
    }
    
    public void setQuantityOnFlr(int qtyOnFlr) {
        this.qtyOnFlr.set(qtyOnFlr);
    }

    public int getQuantityOffFlr() {
        return qtyOffFlr.get();
    }
    
    public void setQuantityOffFlr(int qtyOffFlr) {
        this.qtyOffFlr.set(qtyOffFlr);
    }
    
}

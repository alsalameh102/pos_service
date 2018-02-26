/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ETDelacruz
 */
public class ProductModel {
    
    private final SimpleStringProperty itemCode;
    private final SimpleStringProperty desc;
    private final SimpleStringProperty price;
    private final SimpleIntegerProperty stock;
    private final SimpleStringProperty remarks;
    
    public ProductModel(String itemCode, String desc, String price, int stock, String remarks){
        this.itemCode = new SimpleStringProperty(itemCode);
        this.desc = new SimpleStringProperty(desc);
        this.price = new SimpleStringProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
        this.remarks = new SimpleStringProperty(remarks);
    
    }

    public String getItemCode() {
        return itemCode.get();
    }
    
    public void setItemCode(String itemCode){
        this.itemCode.set(itemCode);
    }

    public String getDesc() {
        return desc.get();
    }
    
    public void setDesc(String desc){
        this.desc.set(desc);
    }

    public String getPrice() {
        return price.get();
    }
    
    public void setPrice(String price) {
        this.price.set(price);
    }

    public int getStock() {
        return stock.get();
    }
    
    public void setStock(int quantity) {
        this.stock.set(quantity);
    }

    public String getRemarks() {
        return remarks.get();
    }
    
    public void setRemarks(String remarks) {
        this.remarks.set(remarks);
    }
    
}

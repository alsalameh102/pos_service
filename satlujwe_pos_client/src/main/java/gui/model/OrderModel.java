/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ETDelacruz
 */
public class OrderModel {
    
    private final SimpleStringProperty itemCode;
    private final SimpleIntegerProperty orderNum;
    private final SimpleStringProperty itemInfo;
    private final SimpleStringProperty price;
    private final SimpleStringProperty quantity;
    private final SimpleStringProperty tax;
    
    public OrderModel(int orderNum, String itemInfo, String quantity, String price, String tax, String itemCode){
        this.orderNum = new SimpleIntegerProperty(orderNum);
        this.itemInfo = new SimpleStringProperty(itemInfo);
        this.quantity = new SimpleStringProperty(quantity);
        this.price = new SimpleStringProperty(price);
        this.tax = new SimpleStringProperty(tax);
        this.itemCode = new SimpleStringProperty(itemCode);
    }
    
    public int getOrderNum() {
        return orderNum.get();
    }
    
    public void setOrderNum(int orderNum){
        this.orderNum.set(orderNum);
    }

    public String getItemInfo() {
        return itemInfo.get();
    }
    
    public void setItemInfo(String ItemInfo){
        this.itemInfo.set(ItemInfo);
    }

    public String getQuantity() {
        return quantity.get();
    }
    
    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getPrice() {
        return price.get();
    }
    
    public void setPrice(String price) {
        this.price.set(price);
    }
    
    public String getTax() {
        return tax.get();
    }
    
    public void setTax(String tax) {
        this.tax.set(tax);
    }
    
    public String getItemCode() {
        return itemCode.get();
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode.set(itemCode);
    }
}

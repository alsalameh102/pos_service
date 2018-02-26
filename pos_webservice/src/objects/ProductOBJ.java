/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Date;

/**
 *
 * @author ETDelacruz
 */
public class ProductOBJ {
    
    private int ID;
    private String PRODUCT_IMG;
    private String PRODUCT_NAME;
    private String SKU;
    private String ITEM_CODE;
    private int VENDOR;
    private double PURCHASE_PRICE;
    private double RETAIL_PRICE;
    private int AISLE;
    private String PERISHABLE;
    private String SUB_CATEGORY;
    private int QUANTITY_ON_FLOOR;
    private int SHELF_LIFE_ON_FLOOR;
    private int QUANTITY_OFF_FLOOR;
    private int SHELF_LIFE_OFF_FLOOR;
    private String TAX;
    private String TAXABLE;
    private String COUPON;
    private String REMARKS;
    private Date CREATED_AT;
    private Date UPDATED_AT;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPRODUCT_IMG() {
        return PRODUCT_IMG;
    }

    public void setPRODUCT_IMG(String PRODUCT_IMG) {
        this.PRODUCT_IMG = PRODUCT_IMG;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
    
    public String getITEM_CODE() {
        return ITEM_CODE;
    }

    public void setITEM_CODE(String ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public int getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(int VENDOR) {
        this.VENDOR = VENDOR;
    }

    public double getRETAIL_PRICE() {
        return RETAIL_PRICE;
    }

    public void setRETAIL_PRICE(double RETAIL_PRICE) {
        this.RETAIL_PRICE = RETAIL_PRICE;
    }
    
    public double getPURCHASE_PRICE() {
        return PURCHASE_PRICE;
    }

    public void setPURCHASE_PRICE(double PURCHASE_PRICE) {
        this.PURCHASE_PRICE = PURCHASE_PRICE;
    }


    public int getAISLE() {
        return AISLE;
    }

    public void setAISLE(int AISLE) {
        this.AISLE = AISLE;
    }

    public String getPERISHABLE() {
        return PERISHABLE;
    }

    public void setPERISHABLE(String PERISHABLE) {
        this.PERISHABLE = PERISHABLE;
    }

    public String getSUB_CATEGORY() {
        return SUB_CATEGORY;
    }

    public void setSUB_CATEGORY(String SUB_CATEGORY) {
        this.SUB_CATEGORY = SUB_CATEGORY;
    }

    public int getQUANTITY_ON_FLOOR() {
        return QUANTITY_ON_FLOOR;
    }

    public void setQUANTITY_ON_FLOOR(int QUANTITY_ON_FLOOR) {
        this.QUANTITY_ON_FLOOR = QUANTITY_ON_FLOOR;
    }

    public int getSHELF_LIFE_ON_FLOOR() {
        return SHELF_LIFE_ON_FLOOR;
    }

    public void setSHELF_LIFE_ON_FLOOR(int SHELF_LIFE_ON_FLOOR) {
        this.SHELF_LIFE_ON_FLOOR = SHELF_LIFE_ON_FLOOR;
    }

    public int getQUANTITY_OFF_FLOOR() {
        return QUANTITY_OFF_FLOOR;
    }

    public void setQUANTITY_OFF_FLOOR(int QUANTITY_OFF_FLOOR) {
        this.QUANTITY_OFF_FLOOR = QUANTITY_OFF_FLOOR;
    }

    public int getSHELF_LIFE_OFF_FLOOR() {
        return SHELF_LIFE_OFF_FLOOR;
    }

    public void setSHELF_LIFE_OFF_FLOOR(int SHELF_LIFE_OFF_FLOOR) {
        this.SHELF_LIFE_OFF_FLOOR = SHELF_LIFE_OFF_FLOOR;
    }

    public String getTAXABLE() {
        return TAXABLE;
    }

    public void setTAXABLE(String TAXABLE) {
        this.TAXABLE = TAXABLE;
    }
    
    public String getTAX() {
        return TAX;
    }

    public void setTAX(String TAX) {
        this.TAX = TAX;
    }

    public String getCOUPON() {
        return COUPON;
    }

    public void setCOUPON(String COUPON) {
        this.COUPON = COUPON;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(Date CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public Date getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setUPDATED_AT(Date UPDATED_AT) {
        this.UPDATED_AT = UPDATED_AT;
    }

    
    
}

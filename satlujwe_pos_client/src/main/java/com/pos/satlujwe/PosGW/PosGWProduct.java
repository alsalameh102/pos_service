/**
 * PosGWProduct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGWProduct  implements java.io.Serializable {
    private int ID;

    private java.lang.String productIMG;

    private java.lang.String productName;

    private java.lang.String SKU;

    private java.lang.String itemCode;

    private int vendor;

    private java.math.BigDecimal purchasePrice;

    private java.math.BigDecimal retailPrice;

    private int aisle;

    private java.lang.String perishable;

    private java.lang.String subCategory;

    private int qtyOnFloor;

    private int shelfLifeOnFloor;

    private int qtyOffFloor;

    private int shelfLifeOffFloor;

    private java.lang.String tax;

    private java.lang.String taxable;

    private java.lang.String coupon;

    private java.lang.String remarks;

    private java.lang.String createdAt;

    private java.lang.String updatedAt;

    public PosGWProduct() {
    }

    public PosGWProduct(
           int ID,
           java.lang.String productIMG,
           java.lang.String productName,
           java.lang.String SKU,
           java.lang.String itemCode,
           int vendor,
           java.math.BigDecimal purchasePrice,
           java.math.BigDecimal retailPrice,
           int aisle,
           java.lang.String perishable,
           java.lang.String subCategory,
           int qtyOnFloor,
           int shelfLifeOnFloor,
           int qtyOffFloor,
           int shelfLifeOffFloor,
           java.lang.String tax,
           java.lang.String taxable,
           java.lang.String coupon,
           java.lang.String remarks,
           java.lang.String createdAt,
           java.lang.String updatedAt) {
           this.ID = ID;
           this.productIMG = productIMG;
           this.productName = productName;
           this.SKU = SKU;
           this.itemCode = itemCode;
           this.vendor = vendor;
           this.purchasePrice = purchasePrice;
           this.retailPrice = retailPrice;
           this.aisle = aisle;
           this.perishable = perishable;
           this.subCategory = subCategory;
           this.qtyOnFloor = qtyOnFloor;
           this.shelfLifeOnFloor = shelfLifeOnFloor;
           this.qtyOffFloor = qtyOffFloor;
           this.shelfLifeOffFloor = shelfLifeOffFloor;
           this.tax = tax;
           this.taxable = taxable;
           this.coupon = coupon;
           this.remarks = remarks;
           this.createdAt = createdAt;
           this.updatedAt = updatedAt;
    }


    /**
     * Gets the ID value for this PosGWProduct.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this PosGWProduct.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the productIMG value for this PosGWProduct.
     * 
     * @return productIMG
     */
    public java.lang.String getProductIMG() {
        return productIMG;
    }


    /**
     * Sets the productIMG value for this PosGWProduct.
     * 
     * @param productIMG
     */
    public void setProductIMG(java.lang.String productIMG) {
        this.productIMG = productIMG;
    }


    /**
     * Gets the productName value for this PosGWProduct.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this PosGWProduct.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the SKU value for this PosGWProduct.
     * 
     * @return SKU
     */
    public java.lang.String getSKU() {
        return SKU;
    }


    /**
     * Sets the SKU value for this PosGWProduct.
     * 
     * @param SKU
     */
    public void setSKU(java.lang.String SKU) {
        this.SKU = SKU;
    }


    /**
     * Gets the itemCode value for this PosGWProduct.
     * 
     * @return itemCode
     */
    public java.lang.String getItemCode() {
        return itemCode;
    }


    /**
     * Sets the itemCode value for this PosGWProduct.
     * 
     * @param itemCode
     */
    public void setItemCode(java.lang.String itemCode) {
        this.itemCode = itemCode;
    }


    /**
     * Gets the vendor value for this PosGWProduct.
     * 
     * @return vendor
     */
    public int getVendor() {
        return vendor;
    }


    /**
     * Sets the vendor value for this PosGWProduct.
     * 
     * @param vendor
     */
    public void setVendor(int vendor) {
        this.vendor = vendor;
    }


    /**
     * Gets the purchasePrice value for this PosGWProduct.
     * 
     * @return purchasePrice
     */
    public java.math.BigDecimal getPurchasePrice() {
        return purchasePrice;
    }


    /**
     * Sets the purchasePrice value for this PosGWProduct.
     * 
     * @param purchasePrice
     */
    public void setPurchasePrice(java.math.BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    /**
     * Gets the retailPrice value for this PosGWProduct.
     * 
     * @return retailPrice
     */
    public java.math.BigDecimal getRetailPrice() {
        return retailPrice;
    }


    /**
     * Sets the retailPrice value for this PosGWProduct.
     * 
     * @param retailPrice
     */
    public void setRetailPrice(java.math.BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }


    /**
     * Gets the aisle value for this PosGWProduct.
     * 
     * @return aisle
     */
    public int getAisle() {
        return aisle;
    }


    /**
     * Sets the aisle value for this PosGWProduct.
     * 
     * @param aisle
     */
    public void setAisle(int aisle) {
        this.aisle = aisle;
    }


    /**
     * Gets the perishable value for this PosGWProduct.
     * 
     * @return perishable
     */
    public java.lang.String getPerishable() {
        return perishable;
    }


    /**
     * Sets the perishable value for this PosGWProduct.
     * 
     * @param perishable
     */
    public void setPerishable(java.lang.String perishable) {
        this.perishable = perishable;
    }


    /**
     * Gets the subCategory value for this PosGWProduct.
     * 
     * @return subCategory
     */
    public java.lang.String getSubCategory() {
        return subCategory;
    }


    /**
     * Sets the subCategory value for this PosGWProduct.
     * 
     * @param subCategory
     */
    public void setSubCategory(java.lang.String subCategory) {
        this.subCategory = subCategory;
    }


    /**
     * Gets the qtyOnFloor value for this PosGWProduct.
     * 
     * @return qtyOnFloor
     */
    public int getQtyOnFloor() {
        return qtyOnFloor;
    }


    /**
     * Sets the qtyOnFloor value for this PosGWProduct.
     * 
     * @param qtyOnFloor
     */
    public void setQtyOnFloor(int qtyOnFloor) {
        this.qtyOnFloor = qtyOnFloor;
    }


    /**
     * Gets the shelfLifeOnFloor value for this PosGWProduct.
     * 
     * @return shelfLifeOnFloor
     */
    public int getShelfLifeOnFloor() {
        return shelfLifeOnFloor;
    }


    /**
     * Sets the shelfLifeOnFloor value for this PosGWProduct.
     * 
     * @param shelfLifeOnFloor
     */
    public void setShelfLifeOnFloor(int shelfLifeOnFloor) {
        this.shelfLifeOnFloor = shelfLifeOnFloor;
    }


    /**
     * Gets the qtyOffFloor value for this PosGWProduct.
     * 
     * @return qtyOffFloor
     */
    public int getQtyOffFloor() {
        return qtyOffFloor;
    }


    /**
     * Sets the qtyOffFloor value for this PosGWProduct.
     * 
     * @param qtyOffFloor
     */
    public void setQtyOffFloor(int qtyOffFloor) {
        this.qtyOffFloor = qtyOffFloor;
    }


    /**
     * Gets the shelfLifeOffFloor value for this PosGWProduct.
     * 
     * @return shelfLifeOffFloor
     */
    public int getShelfLifeOffFloor() {
        return shelfLifeOffFloor;
    }


    /**
     * Sets the shelfLifeOffFloor value for this PosGWProduct.
     * 
     * @param shelfLifeOffFloor
     */
    public void setShelfLifeOffFloor(int shelfLifeOffFloor) {
        this.shelfLifeOffFloor = shelfLifeOffFloor;
    }


    /**
     * Gets the tax value for this PosGWProduct.
     * 
     * @return tax
     */
    public java.lang.String getTax() {
        return tax;
    }


    /**
     * Sets the tax value for this PosGWProduct.
     * 
     * @param tax
     */
    public void setTax(java.lang.String tax) {
        this.tax = tax;
    }


    /**
     * Gets the taxable value for this PosGWProduct.
     * 
     * @return taxable
     */
    public java.lang.String getTaxable() {
        return taxable;
    }


    /**
     * Sets the taxable value for this PosGWProduct.
     * 
     * @param taxable
     */
    public void setTaxable(java.lang.String taxable) {
        this.taxable = taxable;
    }


    /**
     * Gets the coupon value for this PosGWProduct.
     * 
     * @return coupon
     */
    public java.lang.String getCoupon() {
        return coupon;
    }


    /**
     * Sets the coupon value for this PosGWProduct.
     * 
     * @param coupon
     */
    public void setCoupon(java.lang.String coupon) {
        this.coupon = coupon;
    }


    /**
     * Gets the remarks value for this PosGWProduct.
     * 
     * @return remarks
     */
    public java.lang.String getRemarks() {
        return remarks;
    }


    /**
     * Sets the remarks value for this PosGWProduct.
     * 
     * @param remarks
     */
    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }


    /**
     * Gets the createdAt value for this PosGWProduct.
     * 
     * @return createdAt
     */
    public java.lang.String getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the createdAt value for this PosGWProduct.
     * 
     * @param createdAt
     */
    public void setCreatedAt(java.lang.String createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * Gets the updatedAt value for this PosGWProduct.
     * 
     * @return updatedAt
     */
    public java.lang.String getUpdatedAt() {
        return updatedAt;
    }


    /**
     * Sets the updatedAt value for this PosGWProduct.
     * 
     * @param updatedAt
     */
    public void setUpdatedAt(java.lang.String updatedAt) {
        this.updatedAt = updatedAt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PosGWProduct)) return false;
        PosGWProduct other = (PosGWProduct) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ID == other.getID() &&
            ((this.productIMG==null && other.getProductIMG()==null) || 
             (this.productIMG!=null &&
              this.productIMG.equals(other.getProductIMG()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.SKU==null && other.getSKU()==null) || 
             (this.SKU!=null &&
              this.SKU.equals(other.getSKU()))) &&
            ((this.itemCode==null && other.getItemCode()==null) || 
             (this.itemCode!=null &&
              this.itemCode.equals(other.getItemCode()))) &&
            this.vendor == other.getVendor() &&
            ((this.purchasePrice==null && other.getPurchasePrice()==null) || 
             (this.purchasePrice!=null &&
              this.purchasePrice.equals(other.getPurchasePrice()))) &&
            ((this.retailPrice==null && other.getRetailPrice()==null) || 
             (this.retailPrice!=null &&
              this.retailPrice.equals(other.getRetailPrice()))) &&
            this.aisle == other.getAisle() &&
            ((this.perishable==null && other.getPerishable()==null) || 
             (this.perishable!=null &&
              this.perishable.equals(other.getPerishable()))) &&
            ((this.subCategory==null && other.getSubCategory()==null) || 
             (this.subCategory!=null &&
              this.subCategory.equals(other.getSubCategory()))) &&
            this.qtyOnFloor == other.getQtyOnFloor() &&
            this.shelfLifeOnFloor == other.getShelfLifeOnFloor() &&
            this.qtyOffFloor == other.getQtyOffFloor() &&
            this.shelfLifeOffFloor == other.getShelfLifeOffFloor() &&
            ((this.tax==null && other.getTax()==null) || 
             (this.tax!=null &&
              this.tax.equals(other.getTax()))) &&
            ((this.taxable==null && other.getTaxable()==null) || 
             (this.taxable!=null &&
              this.taxable.equals(other.getTaxable()))) &&
            ((this.coupon==null && other.getCoupon()==null) || 
             (this.coupon!=null &&
              this.coupon.equals(other.getCoupon()))) &&
            ((this.remarks==null && other.getRemarks()==null) || 
             (this.remarks!=null &&
              this.remarks.equals(other.getRemarks()))) &&
            ((this.createdAt==null && other.getCreatedAt()==null) || 
             (this.createdAt!=null &&
              this.createdAt.equals(other.getCreatedAt()))) &&
            ((this.updatedAt==null && other.getUpdatedAt()==null) || 
             (this.updatedAt!=null &&
              this.updatedAt.equals(other.getUpdatedAt())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getID();
        if (getProductIMG() != null) {
            _hashCode += getProductIMG().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getSKU() != null) {
            _hashCode += getSKU().hashCode();
        }
        if (getItemCode() != null) {
            _hashCode += getItemCode().hashCode();
        }
        _hashCode += getVendor();
        if (getPurchasePrice() != null) {
            _hashCode += getPurchasePrice().hashCode();
        }
        if (getRetailPrice() != null) {
            _hashCode += getRetailPrice().hashCode();
        }
        _hashCode += getAisle();
        if (getPerishable() != null) {
            _hashCode += getPerishable().hashCode();
        }
        if (getSubCategory() != null) {
            _hashCode += getSubCategory().hashCode();
        }
        _hashCode += getQtyOnFloor();
        _hashCode += getShelfLifeOnFloor();
        _hashCode += getQtyOffFloor();
        _hashCode += getShelfLifeOffFloor();
        if (getTax() != null) {
            _hashCode += getTax().hashCode();
        }
        if (getTaxable() != null) {
            _hashCode += getTaxable().hashCode();
        }
        if (getCoupon() != null) {
            _hashCode += getCoupon().hashCode();
        }
        if (getRemarks() != null) {
            _hashCode += getRemarks().hashCode();
        }
        if (getCreatedAt() != null) {
            _hashCode += getCreatedAt().hashCode();
        }
        if (getUpdatedAt() != null) {
            _hashCode += getUpdatedAt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PosGWProduct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWProduct"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productIMG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProductIMG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProductName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SKU");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SKU"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ItemCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vendor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vendor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchasePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PurchasePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retailPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RetailPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aisle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Aisle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perishable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Perishable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SubCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtyOnFloor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "QtyOnFloor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shelfLifeOnFloor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ShelfLifeOnFloor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtyOffFloor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "QtyOffFloor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shelfLifeOffFloor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ShelfLifeOffFloor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Taxable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coupon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Coupon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remarks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Remarks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdAt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CreatedAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updatedAt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UpdatedAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

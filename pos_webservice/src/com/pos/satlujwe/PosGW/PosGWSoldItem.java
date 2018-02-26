/**
 * PosGWSoldItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGWSoldItem  implements java.io.Serializable {
    private int ID;

    private java.lang.String invoiceNum;

    private java.lang.String prodName;

    private java.lang.String itemCode;

    private java.lang.String sku;

    private java.math.BigDecimal purchasePrice;

    private int qty;

    private java.lang.String remarks;

    private java.lang.String soldDate;

    public PosGWSoldItem() {
    }

    public PosGWSoldItem(
           int ID,
           java.lang.String invoiceNum,
           java.lang.String prodName,
           java.lang.String itemCode,
           java.lang.String sku,
           java.math.BigDecimal purchasePrice,
           int qty,
           java.lang.String remarks,
           java.lang.String soldDate) {
           this.ID = ID;
           this.invoiceNum = invoiceNum;
           this.prodName = prodName;
           this.itemCode = itemCode;
           this.sku = sku;
           this.purchasePrice = purchasePrice;
           this.qty = qty;
           this.remarks = remarks;
           this.soldDate = soldDate;
    }


    /**
     * Gets the ID value for this PosGWSoldItem.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this PosGWSoldItem.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the invoiceNum value for this PosGWSoldItem.
     * 
     * @return invoiceNum
     */
    public java.lang.String getInvoiceNum() {
        return invoiceNum;
    }


    /**
     * Sets the invoiceNum value for this PosGWSoldItem.
     * 
     * @param invoiceNum
     */
    public void setInvoiceNum(java.lang.String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }


    /**
     * Gets the prodName value for this PosGWSoldItem.
     * 
     * @return prodName
     */
    public java.lang.String getProdName() {
        return prodName;
    }


    /**
     * Sets the prodName value for this PosGWSoldItem.
     * 
     * @param prodName
     */
    public void setProdName(java.lang.String prodName) {
        this.prodName = prodName;
    }


    /**
     * Gets the itemCode value for this PosGWSoldItem.
     * 
     * @return itemCode
     */
    public java.lang.String getItemCode() {
        return itemCode;
    }


    /**
     * Sets the itemCode value for this PosGWSoldItem.
     * 
     * @param itemCode
     */
    public void setItemCode(java.lang.String itemCode) {
        this.itemCode = itemCode;
    }


    /**
     * Gets the sku value for this PosGWSoldItem.
     * 
     * @return sku
     */
    public java.lang.String getSku() {
        return sku;
    }


    /**
     * Sets the sku value for this PosGWSoldItem.
     * 
     * @param sku
     */
    public void setSku(java.lang.String sku) {
        this.sku = sku;
    }


    /**
     * Gets the purchasePrice value for this PosGWSoldItem.
     * 
     * @return purchasePrice
     */
    public java.math.BigDecimal getPurchasePrice() {
        return purchasePrice;
    }


    /**
     * Sets the purchasePrice value for this PosGWSoldItem.
     * 
     * @param purchasePrice
     */
    public void setPurchasePrice(java.math.BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    /**
     * Gets the qty value for this PosGWSoldItem.
     * 
     * @return qty
     */
    public int getQty() {
        return qty;
    }


    /**
     * Sets the qty value for this PosGWSoldItem.
     * 
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }


    /**
     * Gets the remarks value for this PosGWSoldItem.
     * 
     * @return remarks
     */
    public java.lang.String getRemarks() {
        return remarks;
    }


    /**
     * Sets the remarks value for this PosGWSoldItem.
     * 
     * @param remarks
     */
    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }


    /**
     * Gets the soldDate value for this PosGWSoldItem.
     * 
     * @return soldDate
     */
    public java.lang.String getSoldDate() {
        return soldDate;
    }


    /**
     * Sets the soldDate value for this PosGWSoldItem.
     * 
     * @param soldDate
     */
    public void setSoldDate(java.lang.String soldDate) {
        this.soldDate = soldDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PosGWSoldItem)) return false;
        PosGWSoldItem other = (PosGWSoldItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ID == other.getID() &&
            ((this.invoiceNum==null && other.getInvoiceNum()==null) || 
             (this.invoiceNum!=null &&
              this.invoiceNum.equals(other.getInvoiceNum()))) &&
            ((this.prodName==null && other.getProdName()==null) || 
             (this.prodName!=null &&
              this.prodName.equals(other.getProdName()))) &&
            ((this.itemCode==null && other.getItemCode()==null) || 
             (this.itemCode!=null &&
              this.itemCode.equals(other.getItemCode()))) &&
            ((this.sku==null && other.getSku()==null) || 
             (this.sku!=null &&
              this.sku.equals(other.getSku()))) &&
            ((this.purchasePrice==null && other.getPurchasePrice()==null) || 
             (this.purchasePrice!=null &&
              this.purchasePrice.equals(other.getPurchasePrice()))) &&
            this.qty == other.getQty() &&
            ((this.remarks==null && other.getRemarks()==null) || 
             (this.remarks!=null &&
              this.remarks.equals(other.getRemarks()))) &&
            ((this.soldDate==null && other.getSoldDate()==null) || 
             (this.soldDate!=null &&
              this.soldDate.equals(other.getSoldDate())));
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
        if (getInvoiceNum() != null) {
            _hashCode += getInvoiceNum().hashCode();
        }
        if (getProdName() != null) {
            _hashCode += getProdName().hashCode();
        }
        if (getItemCode() != null) {
            _hashCode += getItemCode().hashCode();
        }
        if (getSku() != null) {
            _hashCode += getSku().hashCode();
        }
        if (getPurchasePrice() != null) {
            _hashCode += getPurchasePrice().hashCode();
        }
        _hashCode += getQty();
        if (getRemarks() != null) {
            _hashCode += getRemarks().hashCode();
        }
        if (getSoldDate() != null) {
            _hashCode += getSoldDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PosGWSoldItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWSoldItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InvoiceNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prodName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProdName"));
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
        elemField.setFieldName("sku");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Sku"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchasePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PurchasePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Qty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remarks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Remarks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("soldDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SoldDate"));
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

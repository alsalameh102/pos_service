/**
 * PosGWHoldTransaction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGWHoldTransaction  implements java.io.Serializable {
    private int ID;

    private java.lang.String userID;

    private java.lang.String heldID;

    private java.lang.String invoiceNum;

    private java.lang.String loggedby;

    private java.lang.String createdAt;

    private java.lang.String soldAt;

    private java.lang.String status;

    public PosGWHoldTransaction() {
    }

    public PosGWHoldTransaction(
           int ID,
           java.lang.String userID,
           java.lang.String heldID,
           java.lang.String invoiceNum,
           java.lang.String loggedby,
           java.lang.String createdAt,
           java.lang.String soldAt,
           java.lang.String status) {
           this.ID = ID;
           this.userID = userID;
           this.heldID = heldID;
           this.invoiceNum = invoiceNum;
           this.loggedby = loggedby;
           this.createdAt = createdAt;
           this.soldAt = soldAt;
           this.status = status;
    }


    /**
     * Gets the ID value for this PosGWHoldTransaction.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this PosGWHoldTransaction.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the userID value for this PosGWHoldTransaction.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this PosGWHoldTransaction.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }


    /**
     * Gets the heldID value for this PosGWHoldTransaction.
     * 
     * @return heldID
     */
    public java.lang.String getHeldID() {
        return heldID;
    }


    /**
     * Sets the heldID value for this PosGWHoldTransaction.
     * 
     * @param heldID
     */
    public void setHeldID(java.lang.String heldID) {
        this.heldID = heldID;
    }


    /**
     * Gets the invoiceNum value for this PosGWHoldTransaction.
     * 
     * @return invoiceNum
     */
    public java.lang.String getInvoiceNum() {
        return invoiceNum;
    }


    /**
     * Sets the invoiceNum value for this PosGWHoldTransaction.
     * 
     * @param invoiceNum
     */
    public void setInvoiceNum(java.lang.String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }


    /**
     * Gets the loggedby value for this PosGWHoldTransaction.
     * 
     * @return loggedby
     */
    public java.lang.String getLoggedby() {
        return loggedby;
    }


    /**
     * Sets the loggedby value for this PosGWHoldTransaction.
     * 
     * @param loggedby
     */
    public void setLoggedby(java.lang.String loggedby) {
        this.loggedby = loggedby;
    }


    /**
     * Gets the createdAt value for this PosGWHoldTransaction.
     * 
     * @return createdAt
     */
    public java.lang.String getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the createdAt value for this PosGWHoldTransaction.
     * 
     * @param createdAt
     */
    public void setCreatedAt(java.lang.String createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * Gets the soldAt value for this PosGWHoldTransaction.
     * 
     * @return soldAt
     */
    public java.lang.String getSoldAt() {
        return soldAt;
    }


    /**
     * Sets the soldAt value for this PosGWHoldTransaction.
     * 
     * @param soldAt
     */
    public void setSoldAt(java.lang.String soldAt) {
        this.soldAt = soldAt;
    }


    /**
     * Gets the status value for this PosGWHoldTransaction.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this PosGWHoldTransaction.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PosGWHoldTransaction)) return false;
        PosGWHoldTransaction other = (PosGWHoldTransaction) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ID == other.getID() &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID()))) &&
            ((this.heldID==null && other.getHeldID()==null) || 
             (this.heldID!=null &&
              this.heldID.equals(other.getHeldID()))) &&
            ((this.invoiceNum==null && other.getInvoiceNum()==null) || 
             (this.invoiceNum!=null &&
              this.invoiceNum.equals(other.getInvoiceNum()))) &&
            ((this.loggedby==null && other.getLoggedby()==null) || 
             (this.loggedby!=null &&
              this.loggedby.equals(other.getLoggedby()))) &&
            ((this.createdAt==null && other.getCreatedAt()==null) || 
             (this.createdAt!=null &&
              this.createdAt.equals(other.getCreatedAt()))) &&
            ((this.soldAt==null && other.getSoldAt()==null) || 
             (this.soldAt!=null &&
              this.soldAt.equals(other.getSoldAt()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        if (getHeldID() != null) {
            _hashCode += getHeldID().hashCode();
        }
        if (getInvoiceNum() != null) {
            _hashCode += getInvoiceNum().hashCode();
        }
        if (getLoggedby() != null) {
            _hashCode += getLoggedby().hashCode();
        }
        if (getCreatedAt() != null) {
            _hashCode += getCreatedAt().hashCode();
        }
        if (getSoldAt() != null) {
            _hashCode += getSoldAt().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PosGWHoldTransaction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWHoldTransaction"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UserID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("heldID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "HeldID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InvoiceNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loggedby");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Loggedby"));
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
        elemField.setFieldName("soldAt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SoldAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Status"));
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

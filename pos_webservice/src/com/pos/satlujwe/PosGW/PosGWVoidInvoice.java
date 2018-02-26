/**
 * PosGWVoidInvoice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGWVoidInvoice  implements java.io.Serializable {
    private int id;

    private java.lang.String invoiceNum;

    private java.lang.String userID;

    private java.lang.String loggedby;

    private java.lang.String createdAt;

    private java.lang.String status;

    public PosGWVoidInvoice() {
    }

    public PosGWVoidInvoice(
           int id,
           java.lang.String invoiceNum,
           java.lang.String userID,
           java.lang.String loggedby,
           java.lang.String createdAt,
           java.lang.String status) {
           this.id = id;
           this.invoiceNum = invoiceNum;
           this.userID = userID;
           this.loggedby = loggedby;
           this.createdAt = createdAt;
           this.status = status;
    }


    /**
     * Gets the id value for this PosGWVoidInvoice.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this PosGWVoidInvoice.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the invoiceNum value for this PosGWVoidInvoice.
     * 
     * @return invoiceNum
     */
    public java.lang.String getInvoiceNum() {
        return invoiceNum;
    }


    /**
     * Sets the invoiceNum value for this PosGWVoidInvoice.
     * 
     * @param invoiceNum
     */
    public void setInvoiceNum(java.lang.String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }


    /**
     * Gets the userID value for this PosGWVoidInvoice.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this PosGWVoidInvoice.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }


    /**
     * Gets the loggedby value for this PosGWVoidInvoice.
     * 
     * @return loggedby
     */
    public java.lang.String getLoggedby() {
        return loggedby;
    }


    /**
     * Sets the loggedby value for this PosGWVoidInvoice.
     * 
     * @param loggedby
     */
    public void setLoggedby(java.lang.String loggedby) {
        this.loggedby = loggedby;
    }


    /**
     * Gets the createdAt value for this PosGWVoidInvoice.
     * 
     * @return createdAt
     */
    public java.lang.String getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the createdAt value for this PosGWVoidInvoice.
     * 
     * @param createdAt
     */
    public void setCreatedAt(java.lang.String createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * Gets the status value for this PosGWVoidInvoice.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this PosGWVoidInvoice.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PosGWVoidInvoice)) return false;
        PosGWVoidInvoice other = (PosGWVoidInvoice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.invoiceNum==null && other.getInvoiceNum()==null) || 
             (this.invoiceNum!=null &&
              this.invoiceNum.equals(other.getInvoiceNum()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID()))) &&
            ((this.loggedby==null && other.getLoggedby()==null) || 
             (this.loggedby!=null &&
              this.loggedby.equals(other.getLoggedby()))) &&
            ((this.createdAt==null && other.getCreatedAt()==null) || 
             (this.createdAt!=null &&
              this.createdAt.equals(other.getCreatedAt()))) &&
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
        _hashCode += getId();
        if (getInvoiceNum() != null) {
            _hashCode += getInvoiceNum().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        if (getLoggedby() != null) {
            _hashCode += getLoggedby().hashCode();
        }
        if (getCreatedAt() != null) {
            _hashCode += getCreatedAt().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PosGWVoidInvoice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWVoidInvoice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UserID"));
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

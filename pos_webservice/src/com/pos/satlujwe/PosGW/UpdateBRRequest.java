/**
 * UpdateBRRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class UpdateBRRequest  implements java.io.Serializable {
    private java.lang.String inventorySpace;

    private int entryID;

    public UpdateBRRequest() {
    }

    public UpdateBRRequest(
           java.lang.String inventorySpace,
           int entryID) {
           this.inventorySpace = inventorySpace;
           this.entryID = entryID;
    }


    /**
     * Gets the inventorySpace value for this UpdateBRRequest.
     * 
     * @return inventorySpace
     */
    public java.lang.String getInventorySpace() {
        return inventorySpace;
    }


    /**
     * Sets the inventorySpace value for this UpdateBRRequest.
     * 
     * @param inventorySpace
     */
    public void setInventorySpace(java.lang.String inventorySpace) {
        this.inventorySpace = inventorySpace;
    }


    /**
     * Gets the entryID value for this UpdateBRRequest.
     * 
     * @return entryID
     */
    public int getEntryID() {
        return entryID;
    }


    /**
     * Sets the entryID value for this UpdateBRRequest.
     * 
     * @param entryID
     */
    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateBRRequest)) return false;
        UpdateBRRequest other = (UpdateBRRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inventorySpace==null && other.getInventorySpace()==null) || 
             (this.inventorySpace!=null &&
              this.inventorySpace.equals(other.getInventorySpace()))) &&
            this.entryID == other.getEntryID();
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
        if (getInventorySpace() != null) {
            _hashCode += getInventorySpace().hashCode();
        }
        _hashCode += getEntryID();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateBRRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateBRRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventorySpace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InventorySpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EntryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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

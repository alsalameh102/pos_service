/**
 * ChangeSettingRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class ChangeSettingRequest  implements java.io.Serializable {
    private java.lang.String inventorySpace;

    private com.pos.satlujwe.PosGW.PosGWAppSetting[] receiptSettings;

    public ChangeSettingRequest() {
    }

    public ChangeSettingRequest(
           java.lang.String inventorySpace,
           com.pos.satlujwe.PosGW.PosGWAppSetting[] receiptSettings) {
           this.inventorySpace = inventorySpace;
           this.receiptSettings = receiptSettings;
    }


    /**
     * Gets the inventorySpace value for this ChangeSettingRequest.
     * 
     * @return inventorySpace
     */
    public java.lang.String getInventorySpace() {
        return inventorySpace;
    }


    /**
     * Sets the inventorySpace value for this ChangeSettingRequest.
     * 
     * @param inventorySpace
     */
    public void setInventorySpace(java.lang.String inventorySpace) {
        this.inventorySpace = inventorySpace;
    }


    /**
     * Gets the receiptSettings value for this ChangeSettingRequest.
     * 
     * @return receiptSettings
     */
    public com.pos.satlujwe.PosGW.PosGWAppSetting[] getReceiptSettings() {
        return receiptSettings;
    }


    /**
     * Sets the receiptSettings value for this ChangeSettingRequest.
     * 
     * @param receiptSettings
     */
    public void setReceiptSettings(com.pos.satlujwe.PosGW.PosGWAppSetting[] receiptSettings) {
        this.receiptSettings = receiptSettings;
    }

    public com.pos.satlujwe.PosGW.PosGWAppSetting getReceiptSettings(int i) {
        return this.receiptSettings[i];
    }

    public void setReceiptSettings(int i, com.pos.satlujwe.PosGW.PosGWAppSetting _value) {
        this.receiptSettings[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangeSettingRequest)) return false;
        ChangeSettingRequest other = (ChangeSettingRequest) obj;
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
            ((this.receiptSettings==null && other.getReceiptSettings()==null) || 
             (this.receiptSettings!=null &&
              java.util.Arrays.equals(this.receiptSettings, other.getReceiptSettings())));
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
        if (getReceiptSettings() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReceiptSettings());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReceiptSettings(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChangeSettingRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ChangeSettingRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventorySpace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InventorySpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReceiptSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWAppSetting"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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

/**
 * PosGWAppSetting.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGWAppSetting  implements java.io.Serializable {
    private int id;

    private java.lang.String settingName;

    private java.lang.String settingValue;

    private java.lang.String settingDesc;

    public PosGWAppSetting() {
    }

    public PosGWAppSetting(
           int id,
           java.lang.String settingName,
           java.lang.String settingValue,
           java.lang.String settingDesc) {
           this.id = id;
           this.settingName = settingName;
           this.settingValue = settingValue;
           this.settingDesc = settingDesc;
    }


    /**
     * Gets the id value for this PosGWAppSetting.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this PosGWAppSetting.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the settingName value for this PosGWAppSetting.
     * 
     * @return settingName
     */
    public java.lang.String getSettingName() {
        return settingName;
    }


    /**
     * Sets the settingName value for this PosGWAppSetting.
     * 
     * @param settingName
     */
    public void setSettingName(java.lang.String settingName) {
        this.settingName = settingName;
    }


    /**
     * Gets the settingValue value for this PosGWAppSetting.
     * 
     * @return settingValue
     */
    public java.lang.String getSettingValue() {
        return settingValue;
    }


    /**
     * Sets the settingValue value for this PosGWAppSetting.
     * 
     * @param settingValue
     */
    public void setSettingValue(java.lang.String settingValue) {
        this.settingValue = settingValue;
    }


    /**
     * Gets the settingDesc value for this PosGWAppSetting.
     * 
     * @return settingDesc
     */
    public java.lang.String getSettingDesc() {
        return settingDesc;
    }


    /**
     * Sets the settingDesc value for this PosGWAppSetting.
     * 
     * @param settingDesc
     */
    public void setSettingDesc(java.lang.String settingDesc) {
        this.settingDesc = settingDesc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PosGWAppSetting)) return false;
        PosGWAppSetting other = (PosGWAppSetting) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.settingName==null && other.getSettingName()==null) || 
             (this.settingName!=null &&
              this.settingName.equals(other.getSettingName()))) &&
            ((this.settingValue==null && other.getSettingValue()==null) || 
             (this.settingValue!=null &&
              this.settingValue.equals(other.getSettingValue()))) &&
            ((this.settingDesc==null && other.getSettingDesc()==null) || 
             (this.settingDesc!=null &&
              this.settingDesc.equals(other.getSettingDesc())));
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
        if (getSettingName() != null) {
            _hashCode += getSettingName().hashCode();
        }
        if (getSettingValue() != null) {
            _hashCode += getSettingValue().hashCode();
        }
        if (getSettingDesc() != null) {
            _hashCode += getSettingDesc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PosGWAppSetting.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWAppSetting"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settingName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "settingName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settingValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "settingValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settingDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "settingDesc"));
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

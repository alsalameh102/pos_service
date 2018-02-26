/**
 * PosGWLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGWLocator extends org.apache.axis.client.Service implements com.pos.satlujwe.PosGW.PosGW {

    public PosGWLocator() {
    }


    public PosGWLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PosGWLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PosGW_Port
    private java.lang.String PosGW_Port_address = "http://localhost:8080/pos_webservice/services/PosGW_Port";

    public java.lang.String getPosGW_PortAddress() {
        return PosGW_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PosGW_PortWSDDServiceName = "PosGW_Port";

    public java.lang.String getPosGW_PortWSDDServiceName() {
        return PosGW_PortWSDDServiceName;
    }

    public void setPosGW_PortWSDDServiceName(java.lang.String name) {
        PosGW_PortWSDDServiceName = name;
    }

    public com.pos.satlujwe.PosGW.PosGW_PortType getPosGW_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PosGW_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPosGW_Port(endpoint);
    }

    public com.pos.satlujwe.PosGW.PosGW_PortType getPosGW_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.pos.satlujwe.PosGW.PosGW_BindingStub _stub = new com.pos.satlujwe.PosGW.PosGW_BindingStub(portAddress, this);
            _stub.setPortName(getPosGW_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPosGW_PortEndpointAddress(java.lang.String address) {
        PosGW_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.pos.satlujwe.PosGW.PosGW_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.pos.satlujwe.PosGW.PosGW_BindingStub _stub = new com.pos.satlujwe.PosGW.PosGW_BindingStub(new java.net.URL(PosGW_Port_address), this);
                _stub.setPortName(getPosGW_PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PosGW_Port".equals(inputPortName)) {
            return getPosGW_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGW");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGW_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PosGW_Port".equals(portName)) {
            setPosGW_PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

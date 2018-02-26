/**
 * PosGW_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pos.satlujwe.PosGW;

public class PosGW_BindingStub extends org.apache.axis.client.Stub implements com.pos.satlujwe.PosGW.PosGW_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[27];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TK_InsertTR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertTRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertTRRequest"), com.pos.satlujwe.PosGW.InsertTRRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertTRResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.InsertTRResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertTRResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TK_UpdateTR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateTRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateTRRequest"), com.pos.satlujwe.PosGW.UpdateTRRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateTRResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.UpdateTRResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateTRResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TK_InsertBR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertBRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertBRRequest"), com.pos.satlujwe.PosGW.InsertBRRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertBRResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.InsertBRResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertBRResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TK_UpdateBR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateBRRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateBRRequest"), com.pos.satlujwe.PosGW.UpdateBRRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateBRResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.UpdateBRResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateBRResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TK_GetRJEntry");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRJRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRJRequest"), com.pos.satlujwe.PosGW.GetEntryRJRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRJResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.GetEntryRJResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRJResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TK_GetEntryRB");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRBRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRBRequest"), com.pos.satlujwe.PosGW.GetEntryRBRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRBResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.GetEntryRBResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetEntryRBResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInventory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetInventoryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetInventoryRequest"), com.pos.satlujwe.PosGW.GetInventoryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetInventoryResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.PosGWProduct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetInventoryResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "ProductItem"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateInventory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateInventoryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateInventoryRequest"), com.pos.satlujwe.PosGW.UpdateInventoryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateInventoryResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.UpdateInventoryResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "UpdateInventoryResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchInventory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "SearchInventoryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">SearchInventoryRequest"), com.pos.satlujwe.PosGW.SearchInventoryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">SearchInventoryResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.SearchInventoryResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "SearchInventoryResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("InsertSold");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertSoldRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertSoldRequest"), com.pos.satlujwe.PosGW.InsertSoldRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertSoldResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.InsertSoldResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertSoldResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MakeSale");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "MakeSaleRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">MakeSaleRequest"), com.pos.satlujwe.PosGW.MakeSaleRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">MakeSaleResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.MakeSaleResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "MakeSaleResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTransactions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetTransactionsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetTransactionsRequest"), com.pos.satlujwe.PosGW.GetTransactionsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetTransactionsResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.PosGWTransaction[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetTransactionsResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "Transactions"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckHeld");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckHeldTRequest"), com.pos.satlujwe.PosGW.CheckHeldTRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckHeldTResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.CheckHeldTResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckHeldTResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckExistingHeld");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckExistingHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckExistingHeldTRequest"), com.pos.satlujwe.PosGW.CheckExistingHeldTRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckExistingHeldTResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.CheckExistingHeldTResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckExistingHeldTResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("InsertHeld");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldTRequest"), com.pos.satlujwe.PosGW.InsertHeldTRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldTResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.InsertHeldTResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldTResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHeld");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldTRequest"), com.pos.satlujwe.PosGW.GetHeldTRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldTResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.PosGWHoldTransaction[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldTResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "HeldTransactions"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHeldItems");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldItemsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldItemsRequest"), com.pos.satlujwe.PosGW.GetHeldItemsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldItemsResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.PosGWHoldItem[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetHeldItemsResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "HeldItems"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("InsertHeldItems");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldItemRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldItemRequest"), com.pos.satlujwe.PosGW.InsertHeldItemRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldItemResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.InsertHeldItemResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertHeldItemResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelTransaction");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CancelTransactionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CancelTransactionRequest"), com.pos.satlujwe.PosGW.CancelTransactionRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CancelTransactionResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.CancelTransactionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CancelTransactionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OpenCancelled");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "OpenCancelledTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">OpenCancelledTRequest"), com.pos.satlujwe.PosGW.OpenCancelledTRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">OpenCancelledTResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.OpenCancelledTResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "OpenCancelledTResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ClosePending");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "ClosePendingTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ClosePendingTRequest"), com.pos.satlujwe.PosGW.ClosePendingTRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ClosePendingTResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.ClosePendingTResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "ClosePendingTResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UserValidation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckUserRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckUserRequest"), com.pos.satlujwe.PosGW.CheckUserRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckUserResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.CheckUserResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "CheckUserResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllSettings");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetAllSettingsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetAllSettingsRequest"), com.pos.satlujwe.PosGW.GetAllSettingsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetAllSettingsResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.PosGWAppSetting[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetAllSettingsResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "AppSettings"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetReceiptSettings");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetReceiptSettingsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetReceiptSettingsRequest"), com.pos.satlujwe.PosGW.GetReceiptSettingsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetReceiptSettingsResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.PosGWAppSetting[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "GetReceiptSettingsResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "ReceiptSettings"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ChangeSetting");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "ChangeSettingRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ChangeSettingRequest"), com.pos.satlujwe.PosGW.ChangeSettingRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ChangeSettingResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.ChangeSettingResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "ChangeSettingResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("InsertReturnItem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertReturnItemRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertReturnItemRequest"), com.pos.satlujwe.PosGW.InsertReturnItemRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertReturnItemResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.InsertReturnItemResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "InsertReturnItemResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("VoidInvoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "VoidInvoiceRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">VoidInvoiceRequest"), com.pos.satlujwe.PosGW.VoidInvoiceRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">VoidInvoiceResponse"));
        oper.setReturnClass(com.pos.satlujwe.PosGW.VoidInvoiceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "VoidInvoiceResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

    }

    public PosGW_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PosGW_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PosGW_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CancelTransactionRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CancelTransactionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CancelTransactionResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CancelTransactionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ChangeSettingRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.ChangeSettingRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ChangeSettingResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.ChangeSettingResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckExistingHeldTRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CheckExistingHeldTRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckExistingHeldTResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CheckExistingHeldTResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckHeldTRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CheckHeldTRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckHeldTResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CheckHeldTResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckUserRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CheckUserRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">CheckUserResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.CheckUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ClosePendingTRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.ClosePendingTRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">ClosePendingTResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.ClosePendingTResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetAllSettingsRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetAllSettingsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetAllSettingsResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWAppSetting[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWAppSetting");
            qName2 = new javax.xml.namespace.QName("", "AppSettings");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRBRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetEntryRBRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRBResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetEntryRBResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRJRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetEntryRJRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetEntryRJResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetEntryRJResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldItemsRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetHeldItemsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldItemsResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWHoldItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWHoldItem");
            qName2 = new javax.xml.namespace.QName("", "HeldItems");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldTRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetHeldTRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetHeldTResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWHoldTransaction[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWHoldTransaction");
            qName2 = new javax.xml.namespace.QName("", "HeldTransactions");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetInventoryRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetInventoryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetInventoryResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWProduct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWProduct");
            qName2 = new javax.xml.namespace.QName("", "ProductItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetReceiptSettingsRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetReceiptSettingsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetReceiptSettingsResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWAppSetting[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWAppSetting");
            qName2 = new javax.xml.namespace.QName("", "ReceiptSettings");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetTransactionsRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.GetTransactionsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">GetTransactionsResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWTransaction[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWTransaction");
            qName2 = new javax.xml.namespace.QName("", "Transactions");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertBRRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertBRRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertBRResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertBRResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldItemRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertHeldItemRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldItemResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertHeldItemResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldTRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertHeldTRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertHeldTResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertHeldTResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertReturnItemRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertReturnItemRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertReturnItemResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertReturnItemResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertSoldRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertSoldRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertSoldResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertSoldResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertTRRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertTRRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">InsertTRResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.InsertTRResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">MakeSaleRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.MakeSaleRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">MakeSaleResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.MakeSaleResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">OpenCancelledTRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.OpenCancelledTRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">OpenCancelledTResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.OpenCancelledTResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">SearchInventoryRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.SearchInventoryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">SearchInventoryResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.SearchInventoryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateBRRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.UpdateBRRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateBRResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.UpdateBRResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateInventoryRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.UpdateInventoryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateInventoryResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.UpdateInventoryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateTRRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.UpdateTRRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">UpdateTRResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.UpdateTRResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">VoidInvoiceRequest");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.VoidInvoiceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", ">VoidInvoiceResponse");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.VoidInvoiceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWAppSetting");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWAppSetting.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWCartItem");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWCartItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWHoldItem");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWHoldItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWHoldTransaction");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWHoldTransaction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWProduct");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWProduct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWReturnItem");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWReturnItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWSoldItem");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWSoldItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWTransaction");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWTransaction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWUser");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://satlujwe.pos.com/PosGW", "PosGWVoidInvoice");
            cachedSerQNames.add(qName);
            cls = com.pos.satlujwe.PosGW.PosGWVoidInvoice.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.pos.satlujwe.PosGW.InsertTRResponse TK_InsertTR(com.pos.satlujwe.PosGW.InsertTRRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/TK_InsertTR");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TK_InsertTR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.InsertTRResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.InsertTRResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.InsertTRResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.UpdateTRResponse TK_UpdateTR(com.pos.satlujwe.PosGW.UpdateTRRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/TK_UpdateTR");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TK_UpdateTR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.UpdateTRResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.UpdateTRResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.UpdateTRResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.InsertBRResponse TK_InsertBR(com.pos.satlujwe.PosGW.InsertBRRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/TK_InsertBR");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TK_InsertBR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.InsertBRResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.InsertBRResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.InsertBRResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.UpdateBRResponse TK_UpdateBR(com.pos.satlujwe.PosGW.UpdateBRRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/TK_UpdateBR");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TK_UpdateBR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.UpdateBRResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.UpdateBRResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.UpdateBRResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.GetEntryRJResponse TK_GetRJEntry(com.pos.satlujwe.PosGW.GetEntryRJRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/TK_GetRJEntry");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TK_GetRJEntry"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.GetEntryRJResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.GetEntryRJResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.GetEntryRJResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.GetEntryRBResponse TK_GetEntryRB(com.pos.satlujwe.PosGW.GetEntryRBRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/TK_GetEntryRB");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TK_GetEntryRB"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.GetEntryRBResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.GetEntryRBResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.GetEntryRBResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.PosGWProduct[] getInventory(com.pos.satlujwe.PosGW.GetInventoryRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/GetInventory");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetInventory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.PosGWProduct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.PosGWProduct[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.PosGWProduct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.UpdateInventoryResponse updateInventory(com.pos.satlujwe.PosGW.UpdateInventoryRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/UpdateInventory");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateInventory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.UpdateInventoryResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.UpdateInventoryResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.UpdateInventoryResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.SearchInventoryResponse searchInventory(com.pos.satlujwe.PosGW.SearchInventoryRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/SearchInventory");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SearchInventory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.SearchInventoryResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.SearchInventoryResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.SearchInventoryResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.InsertSoldResponse insertSold(com.pos.satlujwe.PosGW.InsertSoldRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/InsertSold");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "InsertSold"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.InsertSoldResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.InsertSoldResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.InsertSoldResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.MakeSaleResponse makeSale(com.pos.satlujwe.PosGW.MakeSaleRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/MakeSale");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "MakeSale"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.MakeSaleResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.MakeSaleResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.MakeSaleResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.PosGWTransaction[] getTransactions(com.pos.satlujwe.PosGW.GetTransactionsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/GetTransactions");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetTransactions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.PosGWTransaction[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.PosGWTransaction[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.PosGWTransaction[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.CheckHeldTResponse checkHeld(com.pos.satlujwe.PosGW.CheckHeldTRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/CheckHeld");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CheckHeld"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.CheckHeldTResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.CheckHeldTResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.CheckHeldTResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.CheckExistingHeldTResponse checkExistingHeld(com.pos.satlujwe.PosGW.CheckExistingHeldTRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/CheckExistingHeld");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CheckExistingHeld"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.CheckExistingHeldTResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.CheckExistingHeldTResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.CheckExistingHeldTResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.InsertHeldTResponse insertHeld(com.pos.satlujwe.PosGW.InsertHeldTRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/InsertHeld");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "InsertHeld"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.InsertHeldTResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.InsertHeldTResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.InsertHeldTResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.PosGWHoldTransaction[] getHeld(com.pos.satlujwe.PosGW.GetHeldTRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/GetHeld");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHeld"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.PosGWHoldTransaction[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.PosGWHoldTransaction[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.PosGWHoldTransaction[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.PosGWHoldItem[] getHeldItems(com.pos.satlujwe.PosGW.GetHeldItemsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/GetHeldItems");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHeldItems"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.PosGWHoldItem[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.PosGWHoldItem[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.PosGWHoldItem[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.InsertHeldItemResponse insertHeldItems(com.pos.satlujwe.PosGW.InsertHeldItemRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/InsertHeldItems");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "InsertHeldItems"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.InsertHeldItemResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.InsertHeldItemResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.InsertHeldItemResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.CancelTransactionResponse cancelTransaction(com.pos.satlujwe.PosGW.CancelTransactionRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/CancelTransaction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CancelTransaction"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.CancelTransactionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.CancelTransactionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.CancelTransactionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.OpenCancelledTResponse openCancelled(com.pos.satlujwe.PosGW.OpenCancelledTRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/OpenCancelled");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "OpenCancelled"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.OpenCancelledTResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.OpenCancelledTResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.OpenCancelledTResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.ClosePendingTResponse closePending(com.pos.satlujwe.PosGW.ClosePendingTRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/ClosePending");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ClosePending"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.ClosePendingTResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.ClosePendingTResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.ClosePendingTResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.CheckUserResponse userValidation(com.pos.satlujwe.PosGW.CheckUserRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/UserValidation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UserValidation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.CheckUserResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.CheckUserResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.CheckUserResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.PosGWAppSetting[] getAllSettings(com.pos.satlujwe.PosGW.GetAllSettingsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/GetAllSettings");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAllSettings"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.PosGWAppSetting[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.PosGWAppSetting[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.PosGWAppSetting[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.PosGWAppSetting[] getReceiptSettings(com.pos.satlujwe.PosGW.GetReceiptSettingsRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/GetReceiptSettings");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetReceiptSettings"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.PosGWAppSetting[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.PosGWAppSetting[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.PosGWAppSetting[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.ChangeSettingResponse changeSetting(com.pos.satlujwe.PosGW.ChangeSettingRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/ChangeSetting");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ChangeSetting"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.ChangeSettingResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.ChangeSettingResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.ChangeSettingResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.InsertReturnItemResponse insertReturnItem(com.pos.satlujwe.PosGW.InsertReturnItemRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/InsertReturnItem");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "InsertReturnItem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.InsertReturnItemResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.InsertReturnItemResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.InsertReturnItemResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.pos.satlujwe.PosGW.VoidInvoiceResponse voidInvoice(com.pos.satlujwe.PosGW.VoidInvoiceRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.examples.com/PosGW/VoidInvoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "VoidInvoice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.pos.satlujwe.PosGW.VoidInvoiceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.pos.satlujwe.PosGW.VoidInvoiceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.pos.satlujwe.PosGW.VoidInvoiceResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}

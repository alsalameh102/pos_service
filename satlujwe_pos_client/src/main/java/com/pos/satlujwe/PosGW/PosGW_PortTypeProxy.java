package com.pos.satlujwe.PosGW;

public class PosGW_PortTypeProxy implements com.pos.satlujwe.PosGW.PosGW_PortType {
  private String _endpoint = null;
  private com.pos.satlujwe.PosGW.PosGW_PortType posGW_PortType = null;
  
  public PosGW_PortTypeProxy() {
    _initPosGW_PortTypeProxy();
  }
  
  public PosGW_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPosGW_PortTypeProxy();
  }
  
  private void _initPosGW_PortTypeProxy() {
    try {
      posGW_PortType = (new com.pos.satlujwe.PosGW.PosGWLocator()).getPosGW_Port();
      if (posGW_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)posGW_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)posGW_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (posGW_PortType != null)
      ((javax.xml.rpc.Stub)posGW_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.pos.satlujwe.PosGW.PosGW_PortType getPosGW_PortType() {
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType;
  }
  
  public com.pos.satlujwe.PosGW.InsertTRResponse TK_InsertTR(com.pos.satlujwe.PosGW.InsertTRRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.TK_InsertTR(parameters);
  }
  
  public com.pos.satlujwe.PosGW.UpdateTRResponse TK_UpdateTR(com.pos.satlujwe.PosGW.UpdateTRRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.TK_UpdateTR(parameters);
  }
  
  public com.pos.satlujwe.PosGW.InsertBRResponse TK_InsertBR(com.pos.satlujwe.PosGW.InsertBRRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.TK_InsertBR(parameters);
  }
  
  public com.pos.satlujwe.PosGW.UpdateBRResponse TK_UpdateBR(com.pos.satlujwe.PosGW.UpdateBRRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.TK_UpdateBR(parameters);
  }
  
  public com.pos.satlujwe.PosGW.GetEntryRJResponse TK_GetRJEntry(com.pos.satlujwe.PosGW.GetEntryRJRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.TK_GetRJEntry(parameters);
  }
  
  public com.pos.satlujwe.PosGW.GetEntryRBResponse TK_GetEntryRB(com.pos.satlujwe.PosGW.GetEntryRBRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.TK_GetEntryRB(parameters);
  }
  
  public com.pos.satlujwe.PosGW.PosGWProduct[] getInventory(com.pos.satlujwe.PosGW.GetInventoryRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.getInventory(parameters);
  }
  
  public com.pos.satlujwe.PosGW.UpdateInventoryResponse updateInventory(com.pos.satlujwe.PosGW.UpdateInventoryRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.updateInventory(parameters);
  }
  
  public com.pos.satlujwe.PosGW.SearchInventoryResponse searchInventory(com.pos.satlujwe.PosGW.SearchInventoryRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.searchInventory(parameters);
  }
  
  public com.pos.satlujwe.PosGW.InsertSoldResponse insertSold(com.pos.satlujwe.PosGW.InsertSoldRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.insertSold(parameters);
  }
  
  public com.pos.satlujwe.PosGW.MakeSaleResponse makeSale(com.pos.satlujwe.PosGW.MakeSaleRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.makeSale(parameters);
  }
  
  public com.pos.satlujwe.PosGW.PosGWTransaction[] getTransactions(com.pos.satlujwe.PosGW.GetTransactionsRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.getTransactions(parameters);
  }
  
  public com.pos.satlujwe.PosGW.CheckHeldTResponse checkHeld(com.pos.satlujwe.PosGW.CheckHeldTRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.checkHeld(parameters);
  }
  
  public com.pos.satlujwe.PosGW.CheckExistingHeldTResponse checkExistingHeld(com.pos.satlujwe.PosGW.CheckExistingHeldTRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.checkExistingHeld(parameters);
  }
  
  public com.pos.satlujwe.PosGW.InsertHeldTResponse insertHeld(com.pos.satlujwe.PosGW.InsertHeldTRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.insertHeld(parameters);
  }
  
  public com.pos.satlujwe.PosGW.PosGWHoldTransaction[] getHeld(com.pos.satlujwe.PosGW.GetHeldTRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.getHeld(parameters);
  }
  
  public com.pos.satlujwe.PosGW.PosGWHoldItem[] getHeldItems(com.pos.satlujwe.PosGW.GetHeldItemsRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.getHeldItems(parameters);
  }
  
  public com.pos.satlujwe.PosGW.InsertHeldItemResponse insertHeldItems(com.pos.satlujwe.PosGW.InsertHeldItemRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.insertHeldItems(parameters);
  }
  
  public com.pos.satlujwe.PosGW.CancelTransactionResponse cancelTransaction(com.pos.satlujwe.PosGW.CancelTransactionRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.cancelTransaction(parameters);
  }
  
  public com.pos.satlujwe.PosGW.OpenCancelledTResponse openCancelled(com.pos.satlujwe.PosGW.OpenCancelledTRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.openCancelled(parameters);
  }
  
  public com.pos.satlujwe.PosGW.ClosePendingTResponse closePending(com.pos.satlujwe.PosGW.ClosePendingTRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.closePending(parameters);
  }
  
  public com.pos.satlujwe.PosGW.CheckUserResponse userValidation(com.pos.satlujwe.PosGW.CheckUserRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.userValidation(parameters);
  }
  
  public com.pos.satlujwe.PosGW.PosGWAppSetting[] getAllSettings(com.pos.satlujwe.PosGW.GetAllSettingsRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.getAllSettings(parameters);
  }
  
  public com.pos.satlujwe.PosGW.PosGWAppSetting[] getReceiptSettings(com.pos.satlujwe.PosGW.GetReceiptSettingsRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.getReceiptSettings(parameters);
  }
  
  public com.pos.satlujwe.PosGW.ChangeSettingResponse changeSetting(com.pos.satlujwe.PosGW.ChangeSettingRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.changeSetting(parameters);
  }
  
  public com.pos.satlujwe.PosGW.InsertReturnItemResponse insertReturnItem(com.pos.satlujwe.PosGW.InsertReturnItemRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.insertReturnItem(parameters);
  }
  
  public com.pos.satlujwe.PosGW.VoidInvoiceResponse voidInvoice(com.pos.satlujwe.PosGW.VoidInvoiceRequest parameters) throws java.rmi.RemoteException{
    if (posGW_PortType == null)
      _initPosGW_PortTypeProxy();
    return posGW_PortType.voidInvoice(parameters);
  }
  
  
}
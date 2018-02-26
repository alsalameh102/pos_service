package com.pos.satlujwe.PosGW.connection;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.axis.AxisFault;

import com.pos.satlujwe.PosGW.CancelTransactionRequest;
import com.pos.satlujwe.PosGW.CancelTransactionResponse;
import com.pos.satlujwe.PosGW.ChangeSettingRequest;
import com.pos.satlujwe.PosGW.ChangeSettingResponse;
import com.pos.satlujwe.PosGW.CheckExistingHeldTRequest;
import com.pos.satlujwe.PosGW.CheckExistingHeldTResponse;
import com.pos.satlujwe.PosGW.CheckHeldTRequest;
import com.pos.satlujwe.PosGW.CheckHeldTResponse;
import com.pos.satlujwe.PosGW.CheckUserRequest;
import com.pos.satlujwe.PosGW.CheckUserResponse;
import com.pos.satlujwe.PosGW.ClosePendingTRequest;
import com.pos.satlujwe.PosGW.ClosePendingTResponse;
import com.pos.satlujwe.PosGW.CreateTKRequest;
import com.pos.satlujwe.PosGW.CreateTKResponse;
import com.pos.satlujwe.PosGW.GetAllSettingsRequest;
import com.pos.satlujwe.PosGW.GetEntryRBRequest;
import com.pos.satlujwe.PosGW.GetEntryRBResponse;
import com.pos.satlujwe.PosGW.GetEntryRJRequest;
import com.pos.satlujwe.PosGW.GetEntryRJResponse;
import com.pos.satlujwe.PosGW.GetHeldItemsRequest;
import com.pos.satlujwe.PosGW.GetHeldTRequest;
import com.pos.satlujwe.PosGW.GetInventoryRequest;
import com.pos.satlujwe.PosGW.GetReceiptSettingsRequest;
import com.pos.satlujwe.PosGW.InsertBRRequest;
import com.pos.satlujwe.PosGW.InsertBRResponse;
import com.pos.satlujwe.PosGW.InsertHeldItemRequest;
import com.pos.satlujwe.PosGW.InsertHeldItemResponse;
import com.pos.satlujwe.PosGW.InsertHeldTRequest;
import com.pos.satlujwe.PosGW.InsertHeldTResponse;
import com.pos.satlujwe.PosGW.InsertReturnItemRequest;
import com.pos.satlujwe.PosGW.InsertReturnItemResponse;
import com.pos.satlujwe.PosGW.InsertSoldRequest;
import com.pos.satlujwe.PosGW.InsertSoldResponse;
import com.pos.satlujwe.PosGW.InsertTRRequest;
import com.pos.satlujwe.PosGW.InsertTRResponse;
import com.pos.satlujwe.PosGW.MakeSaleRequest;
import com.pos.satlujwe.PosGW.MakeSaleResponse;
import com.pos.satlujwe.PosGW.OpenCancelledTRequest;
import com.pos.satlujwe.PosGW.OpenCancelledTResponse;
import com.pos.satlujwe.PosGW.PosGWAppSetting;
import com.pos.satlujwe.PosGW.PosGWCartItem;
import com.pos.satlujwe.PosGW.PosGWHoldItem;
import com.pos.satlujwe.PosGW.PosGWHoldTransaction;
import com.pos.satlujwe.PosGW.PosGWLocator;
import com.pos.satlujwe.PosGW.PosGWProduct;
import com.pos.satlujwe.PosGW.PosGWReturnItem;
import com.pos.satlujwe.PosGW.PosGWSoldItem;
import com.pos.satlujwe.PosGW.PosGWTransaction;
import com.pos.satlujwe.PosGW.PosGWUser;
import com.pos.satlujwe.PosGW.PosGWVoidInvoice;
import com.pos.satlujwe.PosGW.PosGW_BindingStub;
import com.pos.satlujwe.PosGW.UpdateBRRequest;
import com.pos.satlujwe.PosGW.UpdateBRResponse;
import com.pos.satlujwe.PosGW.UpdateTRRequest;
import com.pos.satlujwe.PosGW.UpdateTRResponse;
import com.pos.satlujwe.PosGW.VoidInvoiceRequest;
import com.pos.satlujwe.PosGW.VoidInvoiceResponse;

import config.Constant;
import objects.AppSettingOBJ;
import objects.CartItemOBJ;
import objects.HeldItemsOBJ;
import objects.HoldTransactionOBJ;
import objects.ProductOBJ;
import objects.ReturnItemOBJ;
import objects.SoldItemOBJ;
import objects.TransactionOBJ;
import objects.UserOBJ;
import objects.VoidInvoiceOBJ;
import satlujwe_pos.Main;
import utils.POSCalendar;

public class SoapConnectionPOS implements Constant {
	

	private URL endpoint;
	private PosGWLocator loc;
	private PosGW_BindingStub stub;

	private long lastUsed = 0;
	private int timeout = 0;
	private String name;
	private String url;
	private String beid;
	private String loginCode;
	private String password;
	private String msgSeq;
	private String version;
	/**
	 * Creates Socket Connection
	 * 
	 * @throws EloadException
	 */
	public SoapConnectionPOS() {
		
		/*this.url = sysProp.getProperty(ONE_URL);
		this.beid = sysProp.getProperty(BEID);
		this.loginCode = sysProp.getProperty(LOGIN_SYSTEM_CODE);
		this.password = sysProp.getProperty(PASSWORD);
		this.timeout = Integer.parseInt(sysProp.getProperty(READ_TIMEOUT));
		this.msgSeq = sysProp.getProperty(MESSAGE_SEQ);
		this.version = sysProp.getProperty(VERSION);
		this.createConnectionCBS(poolSize);*/
		this.url = Main.lcontrol.sysProp.getInstance().getProperty(POS_URL).toString();
		createConnectionPOS();
		
	}
	
	
	private void createConnectionPOS() {

		try {
			this.endpoint = new URL(this.url);
			this.loc = new PosGWLocator();
			this.stub = new PosGW_BindingStub(this.endpoint, this.loc);
			this.stub.setTimeout(this.timeout);
			
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
	}	
	
	

	/*
	 * Time Keeping commands
	 * 
	 *
	public boolean newTimeKeepingCommand(String inventorySpace) {
		
		CreateTKRequest timekeepingRequest = new CreateTKRequest(inventorySpace);
		
		try {
			CreateTKResponse tkResponse = this.stub.TK_Create(timekeepingRequest);
			if(tkResponse != null){
				return tkResponse.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}*/
	
	public int getEntryRecordJobCommand(int userID, String inventorySpace) {
		
		GetEntryRJRequest getEntry = new GetEntryRJRequest();
		getEntry.setInventorySpace(inventorySpace);
		getEntry.setUserID(userID);
		
		try {
			GetEntryRJResponse getEntryResponse = this.stub.TK_GetRJEntry(getEntry);
			if(getEntryResponse != null){
				return getEntryResponse.getEntryID();
				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return 0;
	}
	
	public boolean insertTimeRecordCommand(UserOBJ user, String inventorySpace) {
		
		InsertTRRequest request = new InsertTRRequest();
		PosGWUser currentUser = new PosGWUser();
		currentUser.setActivationKey(user.getActivationKey());
		currentUser.setDateCreated(user.getDateCreated());
		currentUser.setEmail(user.getEmail());
		currentUser.setEmailStatus(user.getEmailStatus());
		currentUser.setFirstName(user.getFirstname());
		currentUser.setLastName(user.getLastname());
		currentUser.setPassword(user.getPassword());
		currentUser.setResetKey(user.getResetKey());
		currentUser.setRole(user.getRole());
		currentUser.setUserID(user.getUserid());
		currentUser.setUsername(user.getUsername());
		currentUser.setUserStatus(user.getUserStat());

		request.setCurrentUser(currentUser);
		request.setInventorySpace(inventorySpace);
		
		try {
			InsertTRResponse response = this.stub.TK_InsertTR(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	
	public boolean updateTimeRecordCommand(int userID, String inventorySpace) {
		
		UpdateTRRequest request = new UpdateTRRequest(inventorySpace, userID);
		
		try {
			UpdateTRResponse response = this.stub.TK_UpdateTR(request);
			if(response != null){
				return response.isIsSuccess();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public int getEntryRecordBreakCommand(int userID, String inventorySpace) {
		
		GetEntryRBRequest getEntry = new GetEntryRBRequest();
		getEntry.setInventorySpace(inventorySpace);
		getEntry.setUserID(userID);
		
		try {
			GetEntryRBResponse getResponse = this.stub.TK_GetEntryRB(getEntry);
			if(getResponse != null){
				return getResponse.getEntryID();
				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return 0;
	}
	

	public boolean insertBreakRecordCommand(UserOBJ user, String inventorySpace) {
		
		InsertBRRequest request = new InsertBRRequest();
		PosGWUser currentUser = new PosGWUser();
		currentUser.setActivationKey(user.getActivationKey());
		currentUser.setDateCreated(user.getDateCreated());
		currentUser.setEmail(user.getEmail());
		currentUser.setEmailStatus(user.getEmailStatus());
		currentUser.setFirstName(user.getFirstname());
		currentUser.setLastName(user.getLastname());
		currentUser.setPassword(user.getPassword());
		currentUser.setResetKey(user.getResetKey());
		currentUser.setRole(user.getRole());
		currentUser.setUserID(user.getUserid());
		currentUser.setUsername(user.getUsername());
		currentUser.setUserStatus(user.getUserStat());

		request.setCurrentUser(currentUser);
		request.setInventorySpace(inventorySpace);
		
		try {
			InsertBRResponse response = this.stub.TK_InsertBR(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	
	public boolean updateBreakRecordCommand(int userID, String inventorySpace) {
		
		UpdateBRRequest request = new UpdateBRRequest(inventorySpace, userID);
		
		try {
			UpdateBRResponse response = this.stub.TK_UpdateBR(request);
			if(response != null){
				return response.isIsSuccess();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	//inventory commands
	public ArrayList<ProductOBJ> getInventoryCommand(String inventorySpace) {
		
		ArrayList<ProductOBJ> inventory = new ArrayList<ProductOBJ>();
		GetInventoryRequest request = new GetInventoryRequest(inventorySpace);
		
		try {
			PosGWProduct[] productlist = this.stub.getInventory(request);
			if(productlist != null){
				for (int i = 0; i< productlist.length; i++){
					ProductOBJ product = new ProductOBJ();
					product.setAISLE(productlist[i].getAisle());
					product.setCOUPON(productlist[i].getCoupon());
					//product.setCREATED_AT(new Date(productlist[i].getCreatedAt()));
					product.setID(productlist[i].getID());
					product.setITEM_CODE(productlist[i].getItemCode());
					product.setPERISHABLE(productlist[i].getPerishable());
					product.setPRODUCT_IMG(productlist[i].getProductIMG());
					product.setPRODUCT_NAME(productlist[i].getProductName());
					product.setPURCHASE_PRICE(productlist[i].getPurchasePrice().doubleValue());
					product.setQUANTITY_OFF_FLOOR(productlist[i].getQtyOffFloor());
					product.setQUANTITY_ON_FLOOR(productlist[i].getQtyOnFloor());
					product.setREMARKS(productlist[i].getRemarks());
					product.setRETAIL_PRICE(productlist[i].getRetailPrice().doubleValue());
					product.setSHELF_LIFE_OFF_FLOOR(productlist[i].getShelfLifeOffFloor());
					product.setSHELF_LIFE_ON_FLOOR(productlist[i].getShelfLifeOnFloor());
					product.setSKU(productlist[i].getSKU());
					product.setSUB_CATEGORY(productlist[i].getSubCategory());
					product.setTAX(productlist[i].getTax());
					System.out.println("Tax: "+product.getTAX());
					product.setTAXABLE(productlist[i].getTaxable());
					//product.setUPDATED_AT(new Date(productlist[i].getUpdatedAt()));
					product.setVENDOR(productlist[i].getVendor());
					inventory.add(product);
				}
				
				return inventory;
				
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//System.err.println("Empty Inventory");
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		
		return null;
	}
	
	
	public boolean insertSoldItemCommand(SoldItemOBJ si, String inventorySpace){
		
		InsertSoldRequest request = new InsertSoldRequest();
		PosGWSoldItem psi = new PosGWSoldItem();
		
		psi.setID(si.getId());
		psi.setInvoiceNum(si.getInvoiceNum());
		psi.setItemCode(si.getItemCode());
		psi.setProdName(si.getProdName());
		psi.setPurchasePrice(BigDecimal.valueOf(si.getPurchasePrice()));
		psi.setQty(si.getQty());
		psi.setRemarks(si.getRemarks());
		psi.setSku(si.getRemarks());
		psi.setSoldDate("");
		request.setInventorySpace(inventorySpace);
		request.setItemsSold(psi);
		
		try {
			InsertSoldResponse response = this.stub.insertSold(request);
			if(response != null){
				return response.isIsSuccess();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	//transaction commands
	public boolean makeSaleCommand(String inventorySpace, ArrayList<CartItemOBJ> items, TransactionOBJ trans) {
		
		MakeSaleRequest request = new MakeSaleRequest();
		PosGWCartItem[] citems = new PosGWCartItem[items.size()];
		PosGWTransaction ptrans = new PosGWTransaction();
		
		int ctr = 0;
		for(CartItemOBJ c : items){
			citems[ctr] = new PosGWCartItem();
			citems[ctr].setItemCode(c.getItemCode());
			citems[ctr].setOrderNo(c.getOrderNo());
			citems[ctr].setInvoiceNum(c.getInvoiceNum());
			citems[ctr].setDesc(c.getDesc());
			citems[ctr].setQty(c.getQuantity());
			citems[ctr].setTotalPrice(BigDecimal.valueOf(c.getTotalPrice()));
			ctr++;
			
		}
		
		ptrans.setBalance(BigDecimal.valueOf(trans.getBalance()));
		ptrans.setCashier(trans.getCashier());
		ptrans.setCashTendered(BigDecimal.valueOf(trans.getCashTendered()));
		ptrans.setChange(BigDecimal.valueOf(trans.getChange()));
		ptrans.setID(trans.getId());
		ptrans.setInvoiceNum(trans.getInvoiceNum());
		ptrans.setMonth(trans.getMonth());
		ptrans.setName(trans.getName());
		ptrans.setSubTotal(BigDecimal.valueOf(trans.getSubTotal()));
		ptrans.setTimeStamp("");
		ptrans.setTotalAmount(BigDecimal.valueOf(trans.getTotalAmount()));
		ptrans.setType(trans.getType());
		ptrans.setVAT(trans.getVat());
		ptrans.setWasHeld(trans.getWasHeld());
		ptrans.setYear(trans.getYear());
		
		request.setInventorySpace(inventorySpace);
		request.setItems(citems);
		request.setSale(ptrans);
		
		
		try {
			MakeSaleResponse response = this.stub.makeSale(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public boolean checkHeldTransCommand(String inventorySpace) {
		
		CheckHeldTRequest request = new CheckHeldTRequest();
		request.setInventorySpace(inventorySpace);
		
		try {
			CheckHeldTResponse response = this.stub.checkHeld(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public boolean checkHeldTransExistingCommand(String holdID, String inventorySpace) {
		
		CheckExistingHeldTRequest request = new CheckExistingHeldTRequest(inventorySpace, holdID);
		
		try {
			CheckExistingHeldTResponse response = this.stub.checkExistingHeld(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public ArrayList<HoldTransactionOBJ> getPendingTransCommand(String inventorySpace) throws ParseException{
		
		GetHeldTRequest request = new GetHeldTRequest(inventorySpace);
		ArrayList<HoldTransactionOBJ> heldtrans = new ArrayList<HoldTransactionOBJ>();
		
		try {
			PosGWHoldTransaction[] held = this.stub.getHeld(request);
			if(held != null){
				for (int i = 0 ; i < held.length; i++){
					HoldTransactionOBJ htrans = new HoldTransactionOBJ();
					System.out.println("Created at: "+held[i].getCreatedAt());
					htrans.setCreatedAt(POSCalendar.StringtoDate(held[i].getCreatedAt()));
					htrans.setheldID(held[i].getHeldID());
					htrans.setId(held[i].getID());
					htrans.setInvoice(held[i].getInvoiceNum());
					htrans.setLoggedBy(held[i].getLoggedby());
					htrans.setStatus(held[i].getStatus());
					htrans.setUserid(held[i].getUserID());
					heldtrans.add(htrans);
				}
				return heldtrans;
				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
        return null;
    }
	
	public ArrayList<HeldItemsOBJ> getHeldItemsCommand(String inventorySpace, String heldID) throws ParseException{
		
		GetHeldItemsRequest request = new GetHeldItemsRequest();
		request.setHeldID(heldID);
		request.setInventorySpace(inventorySpace);
		ArrayList<HeldItemsOBJ> hitems = new ArrayList<HeldItemsOBJ>();
		
		try {
			PosGWHoldItem[] helditems = this.stub.getHeldItems(request);
			if(helditems != null){
				for (int i =0 ; i<helditems.length; i++){
					HeldItemsOBJ hi = new HeldItemsOBJ();
					hi.setCreatedAt(POSCalendar.StringtoDate(helditems[i].getCreatedAt()));
					hi.setHeldID(helditems[i].getHeldID());
					hi.setItemCode(helditems[i].getItemCode());
					hi.setQty(helditems[i].getQty());
					hi.setStatus(helditems[i].getStatus());
					hitems.add(hi);
				}
				return hitems;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return null;
		
	}
	
	public boolean insertholdTransCommand(String inventorySpace, HoldTransactionOBJ h){
		
		InsertHeldTRequest request = new InsertHeldTRequest();
		PosGWHoldTransaction phtrans = new PosGWHoldTransaction();
		
		phtrans.setCreatedAt("");
		phtrans.setHeldID(h.getheldID());
		phtrans.setID(h.getId());
		phtrans.setInvoiceNum(h.getInvoice());
		phtrans.setLoggedby(h.getLoggedBy());
		phtrans.setSoldAt("");
		phtrans.setStatus(h.getStatus());
		phtrans.setUserID(h.getUserid());
		request.setHeldTrans(phtrans);
		request.setInventorySpace(inventorySpace);
		
		try {
			InsertHeldTResponse response = this.stub.insertHeld(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
        return false;
    }
	
	public boolean insertheldItemCommand(HeldItemsOBJ hi, String inventorySpace){
		
		InsertHeldItemRequest request = new InsertHeldItemRequest();
		PosGWHoldItem hitem = new PosGWHoldItem();
		
		hitem.setCreatedAt("");
		hitem.setHeldID(hi.getHeldID());
		hitem.setItemCode(hi.getItemCode());
		hitem.setQty(hi.getQty());
		hitem.setStatus(hi.getStatus());
		request.setHeldItem(hitem);
		request.setInventorySpace(inventorySpace);
		
		try {
			InsertHeldItemResponse response = this.stub.insertHeldItems(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
        return false;
    }
	
	public boolean cancelPendingCommand(String inventorySpace, String heldID){
		
		CancelTransactionRequest request = new CancelTransactionRequest();
		request.setHeldID(heldID);
		request.setInventorySpace(inventorySpace);
		
		try {
			CancelTransactionResponse response = this.stub.cancelTransaction(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
        return false;
    }

	public boolean openCancelledCommand(String inventorySpace, String heldID){
		
		OpenCancelledTRequest request = new OpenCancelledTRequest();
		request.setHeldID(heldID);
		request.setInventorySpace(inventorySpace);
		
		try {
			OpenCancelledTResponse response = this.stub.openCancelled(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
        return false;
    }
	
	public boolean closePendingCommand(String inventorySpace, String heldID){
		
		ClosePendingTRequest request = new ClosePendingTRequest();
		request.setHeldID(heldID);
		request.setInventorySpace(inventorySpace);
		
		try {
			ClosePendingTResponse response = this.stub.closePending(request);
			if(response != null){
				return response.isIsSuccess();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
        return false;
    }
	
	
	//users
	
	public UserOBJ validateUserCommand(String username, String password, String inventorySpace){
		
		CheckUserRequest request = new CheckUserRequest();
		request.setInventorySpace(inventorySpace);
		request.setPassword(password);
		request.setUserName(username);
		
		try {
			CheckUserResponse response = this.stub.userValidation(request);
			if(response.getUser() != null){
				
				UserOBJ user = new UserOBJ();
				user.setActivationKey(response.getUser().getActivationKey());
				user.setDateCreated(response.getUser().getDateCreated());
				user.setEmail(response.getUser().getEmail());
				user.setEmailStatus(response.getUser().getEmailStatus());
				user.setFirstname(response.getUser().getFirstName());
				user.setLastname(response.getUser().getLastName());
				user.setPassword(response.getUser().getPassword());
				user.setResetKey(response.getUser().getResetKey());
				user.setRole(response.getUser().getRole());
				user.setUserid(response.getUser().getUserID());
				user.setUsername(response.getUser().getUsername());
				user.setUserStat(response.getUser().getUserStatus());
				
				return user;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
        return null;
    }
	
	//new commands 2018-01-20
	//
	
	public ArrayList<AppSettingOBJ> getAllSettings(String inventorySpace){
	
		ArrayList<AppSettingOBJ> list = new ArrayList<AppSettingOBJ>();
		GetAllSettingsRequest getAll = new GetAllSettingsRequest();
		getAll.setInventorySpace(inventorySpace);
		
		try{
			PosGWAppSetting[] settings = this.stub.getAllSettings(getAll);
			if(settings != null){
				for(int i = 0; i < settings.length; i ++){
					AppSettingOBJ setting = new AppSettingOBJ();
					setting.setId(settings[i].getId());
					setting.setSettingDescription(settings[i].getSettingDesc());
					setting.setSettingName(settings[i].getSettingName());
					setting.setSettingValue(settings[i].getSettingValue());
					list.add(setting);
				}
				return list;
			}
			
		} catch(RemoteException e){
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		
		return null;
	}
	
	public ArrayList<AppSettingOBJ> getReceiptSettings(String inventorySpace){
	
		
		ArrayList<AppSettingOBJ> list = new ArrayList<AppSettingOBJ>();
		GetReceiptSettingsRequest getReceipt = new GetReceiptSettingsRequest();
		getReceipt.setInventorySpace(inventorySpace);
		
		
		try{
			PosGWAppSetting[] settings = this.stub.getReceiptSettings(getReceipt);
			if(settings != null){
				for(int i = 0; i < settings.length; i ++){
					AppSettingOBJ setting = new AppSettingOBJ();
					setting.setId(settings[i].getId());
					setting.setSettingDescription(settings[i].getSettingDesc());
					setting.setSettingName(settings[i].getSettingName());
					setting.setSettingValue(settings[i].getSettingValue());
					list.add(setting);
				}
				return list;
			}
			
		} catch(RemoteException e){
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		
		return null;
	}
	
	public boolean updateSettings(ArrayList<AppSettingOBJ> settings, String inventorySpace){
		
		ChangeSettingRequest csr = new ChangeSettingRequest();
		csr.setInventorySpace(inventorySpace);
		PosGWAppSetting[] possettings = new PosGWAppSetting[settings.size()];
		
		int i = 0;
		for(AppSettingOBJ setting : settings){
			possettings[i] = new PosGWAppSetting();
			possettings[i].setId(0);
			possettings[i].setSettingDesc("");
			possettings[i].setSettingName(setting.getSettingName());
			possettings[i].setSettingValue(setting.getSettingValue());
			i++;
		}
		csr.setReceiptSettings(possettings);
		
		try{
			
			ChangeSettingResponse response = this.stub.changeSetting(csr);
			if(response != null){
				return response.isIsSuccess();
			}
			
		}catch(RemoteException e){
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
	public boolean insertReturnItem(ReturnItemOBJ ri, String inventorySpace){
		
		InsertReturnItemRequest req = new InsertReturnItemRequest();
		PosGWReturnItem posri = new PosGWReturnItem();
		
		posri.setCreatedAt(ri.getCreatedAt());
		posri.setInvoiceNum(ri.getInvoiceNum());
		posri.setItemCode(ri.getItemCode());
		posri.setLoggedby(ri.getLoggedBy());
		posri.setQty(ri.getQty());
		posri.setStatus(ri.getStatus());
		posri.setUserID(String.valueOf(ri.getUserid()));
		
		req.setInventorySpace(inventorySpace);
		req.setReturnItem(posri);
		
		try {
			InsertReturnItemResponse res = this.stub.insertReturnItem(req);
			if(res !=  null){
				return res.isIsSuccess();
			}
			
		} catch(RemoteException e){
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		
		return false;
	}
	
	public boolean voidInvoice(VoidInvoiceOBJ vi, String inventorySpace){
		
		VoidInvoiceRequest req = new VoidInvoiceRequest();
		PosGWVoidInvoice posvi = new PosGWVoidInvoice();
		req.setInventorySpace(inventorySpace);
		
		posvi.setCreatedAt(vi.getCreatedAt());
		posvi.setId(0);
		posvi.setInvoiceNum(vi.getInvoiceNum());
		posvi.setLoggedby(vi.getLoggedBy());
		posvi.setStatus(vi.getLoggedBy());
		posvi.setStatus(vi.getStatus());
		req.setVoidInvoice(posvi);
		
		try {
			VoidInvoiceResponse vir = this.stub.voidInvoice(req);
			if(vir != null){
				return vir.isIsSuccess();
			}
		} catch(RemoteException e){
			e.printStackTrace();
			Main.control.showErrorMessage(e.getMessage());
		}
		
		return false;
	}
	
}

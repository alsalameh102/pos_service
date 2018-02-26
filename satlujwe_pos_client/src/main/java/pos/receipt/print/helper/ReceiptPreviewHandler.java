/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.receipt.print.helper;

import config.Constant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import objects.CartItemOBJ;
import pos.receipt.bean.BeanFactory;
import pos.receipt.bean.ReceiptBean;
import satlujwe_pos.Main;

/**
 *
 * @author ETDelacruz
 */
public class ReceiptPreviewHandler {
    
    private double totalTax = 0, grandTotal = 0, subTotal = 0, change = 0;
    private String invoiceNumber;
    private List<CartItemOBJ> orderList;
    
    
    public ReceiptPreviewHandler(){
    
        orderList = new ArrayList<>();
        
        //set dummy data for preview
        CartItemOBJ item = new CartItemOBJ(1, "111111", "INVOICE-1111", "2 x sample product", 2, 10, "yes");
        orderList.add(item);
        
        this.prepareReceiptDataAndPrint(orderList, invoiceNumber, ""+totalTax, ""+grandTotal);
    }
    
    
    private void prepareReceiptDataAndPrint(List<CartItemOBJ> orderList, String invoiceNumber, String totalTax, String grandTotal){
				Map<String, String> parameters= new HashMap<String,String>();
				prepareParameters(parameters,invoiceNumber, totalTax, grandTotal);
				startThreadForPreview(orderList, parameters);
	}

	private void startThreadForPreview(List<CartItemOBJ> orderList, Map<String, String> parameters){
		Collection<ReceiptBean> receiptBeanList;
		try {
			receiptBeanList = BeanFactory.getReceiptBean(orderList);
			if (receiptBeanList != null) {
				ReceiptPrintHelper printHelperObj = new ReceiptPrintHelper();
         
                                JRPrintPreview jp = new JRPrintPreview(printHelperObj.fillReceiptDataPreview(receiptBeanList, parameters));
                                jp.showAndWait();
				// printHelperObj.printReportToPrinter(jsprint);

			}
		} catch (Exception e) {
                    e.printStackTrace();
			//throw new JRException("Receipt Cannot be printed :" + e);
		}
	}
	
	private void prepareParameters(Map<String,String> parameters, String invoiceNumber, String totalTax, String grandTotal) {
		parameters.put("storeName",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STORENAME));
		parameters.put("storeAddress1",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STOREADDRESS1));
		parameters.put("storeAddress2",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_STOREADDRESS1));
		parameters.put("footerMessage",Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_FOOTERMESSAGE));
		parameters.put("subTotal", ""+this.subTotal);
		parameters.put("changeDue", ""+this.change);
		parameters.put("invoiceNumber", invoiceNumber);
		System.out.println("Invoice Number "+invoiceNumber);
		parameters.put("stationNumber", Main.lcontrol.getAppProperties().getProperty(Constant.POS_STATION_NUMBER));
		parameters.put("grandTotal", grandTotal);
		parameters.put("totalTax", totalTax);
		parameters.put("copyType", "***");
	}
    
}

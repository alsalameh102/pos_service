/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import config.Constant;
import satlujwe_pos.Main;

/**
 *
 * @author ETDelacruz
 */
public class CodeGenerator implements Constant{
    
    public CodeGenerator(){
    
    }
    
    public static String getInvoiceNumber(){
        
        StringBuilder sb = new StringBuilder();
        long timeNow = System.currentTimeMillis();
        //String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date(timeNow));
        
        sb.append(Main.lcontrol.getAppProperties().getProperty(Constant.RECEIPT_INVOICEPREF));
        sb.append(timeNow);
    
        return sb.toString();
    }
    
    public String getBarcode(){
        
        
        return null;
    }
    
}

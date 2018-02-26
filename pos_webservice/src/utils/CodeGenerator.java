/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import config.Constant;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        
        sb.append(Constant.INVOICE_PREF);
        sb.append(timeNow);
    
        return sb.toString();
    }
    
    public String getBarcode(){
        
        
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author ETDelacruz
 */
public class Numbers {
    static Locale locale;
    static NumberFormat currencyFormatter;
    
    public Numbers(){
        
    }
    
    public static double roundUp(double val){   
        locale = new Locale("en", "US");
        currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        //System.out.println(Double.parseDouble(currencyFormatter.format(val).replace("$", "")));
        return Double.parseDouble(currencyFormatter.format(val).replace("$", ""));
    }
    
    public static String roundUpS(double val){   
        locale = new Locale("en", "US");
        currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        //System.out.println(Double.parseDouble(currencyFormatter.format(val).replace("$", "")));
        return currencyFormatter.format(val).replace("$", "");
    }
    
}

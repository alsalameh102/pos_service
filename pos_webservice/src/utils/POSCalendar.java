/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author ETDelacruz
 */
public class POSCalendar {
    static int year, month, day;
    static Calendar mCalendar = Calendar.getInstance();
    public POSCalendar(){
           
    }
    
    public static String getMonth(){
        mCalendar = Calendar.getInstance();
        return mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    }
    
    public static String getYear(){
        mCalendar = Calendar.getInstance();   // Gets the current date and time
        int year = mCalendar.get(Calendar.YEAR);
        return String.valueOf(year);
    }
    
    public static String getYYYYMMDD(){

        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
        return sdf.format(mCalendar.getTime());
    }
    
    public static String getYYYYMMDD2(LocalDate date){

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(dateFormatter);
    }
    
    public static String DatetoString(Date date){
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    	return dateFormat.format(date);
    }
    
    public static Date StringtoDate(String date) throws ParseException{
    	
    	return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(date);
    }
    
}

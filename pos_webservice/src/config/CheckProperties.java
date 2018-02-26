/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author ETDelacruz
 */
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CheckProperties extends Exception implements Constant {
	
	private static final Log log = LogFactory.getLog(CheckProperties.class);
	private static final SysProp sysProp = new SysProp();
	ArrayList<String> eloadProperty = new ArrayList<>();
	
	
	public void checkPropertyFile() throws Exception{
		eloadProperty.add(DBSQLDRIVER);
		eloadProperty.add(DBURL);
		eloadProperty.add(DBNAME);
		eloadProperty.add(DBHOST);
		eloadProperty.add(DBPORT);
		eloadProperty.add(DBUSER);
		eloadProperty.add(DBPASS);
		eloadProperty.add(POS_INVOICE_PREF);
		eloadProperty.add(POS_VAT);
                eloadProperty.add(POS_TITLE);
                eloadProperty.add(POS_BG_IMG);
		
		for(int i=0; i<eloadProperty.size(); i++){
			if (sysProp.getInstance().getProperty(eloadProperty.get(i)) == null){
                            
                            log.error("Missing Property - "+eloadProperty.get(i));
                            throw new Exception("Missing Property - "+eloadProperty.get(i));
			}
                        else {
                            System.out.println(sysProp.getInstance().getProperty(eloadProperty.get(i)));
                        }
			
		}
		
		log.debug("Done checking property file...");
	}
}

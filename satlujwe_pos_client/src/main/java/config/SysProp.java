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

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import satlujwe_pos.Main;

public class SysProp  {
	
	public static PropertiesConfiguration INSTANCE;

	public SysProp() {

            try {

                INSTANCE = new PropertiesConfiguration("config/pos.properties");
                INSTANCE.setAutoSave(true);
  
            } catch (ConfigurationException ex) {
               // Main.control.showErrorMessage(ex.toString());
                //System.err.println(ex.toString());
            }
                
	}
        
        public void reload(){
            
            try {
                
                INSTANCE = new PropertiesConfiguration("config/pos.properties");
                INSTANCE.setAutoSave(true);
                
            } catch (ConfigurationException ex) {
                Main.control.showErrorMessage(ex.toString());
            }
        }
	
	public static PropertiesConfiguration getInstance() {
		return INSTANCE;
	}
	
        
        public void updateProperty(String key, String value){
            
            PropertiesConfiguration conf;
            
            try {

                //System.out.println("PATH : "+INSTANCE.getFile().getPath());
                INSTANCE.setProperty(key,value);
                INSTANCE.save();
                
                
            } catch (ConfigurationException ex) {
                Main.control.showErrorMessage(ex.toString());
            }
                
        
        }
        
}

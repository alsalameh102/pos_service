package config;

import java.util.ArrayList;
import java.util.Properties;

import com.pos.satlujwe.PosGW.connection.SoapConnectionPOS;

import objects.AppSettingOBJ;

public class SysPropConn {

	Properties appProp;
	SoapConnectionPOS conn;
	ArrayList<AppSettingOBJ> list;
	
	public SysPropConn(SoapConnectionPOS conn){
		
		this.conn = conn;
		appProp = new Properties();
		
	}
	
	public void initAppProperties(){
		
		list = this.conn.getAllSettings("");
		for(AppSettingOBJ setting : list){
			System.out.println(setting.getSettingName() + ":" + setting.getSettingValue());
			appProp.setProperty(setting.getSettingName(), setting.getSettingValue());
			
		}
		
	}
	
	public boolean updateAppProperties(ArrayList<AppSettingOBJ> list){
		return this.conn.updateSettings(list, "");
	}
	
	public Properties getAppProp(){
		
		return appProp;
	}
	
}

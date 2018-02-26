package db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.tables.AppSettingsDB;
import objects.AppSettingOBJ;

public class AppSettingMapper implements RowMapper<AppSettingOBJ>{

	@Override
	public AppSettingOBJ mapRow(ResultSet rs, int rowNum) {
		// TODO Auto-generated method stub
		AppSettingOBJ as = new AppSettingOBJ();
		try {
			as.setId(rs.getInt(AppSettingsDB.SETTINGID));
			if(rs.getString(AppSettingsDB.SETTINGDESCRIPTION).isEmpty()){
				as.setSettingDescription("-");
			}
			else{
				as.setSettingDescription(rs.getString(AppSettingsDB.SETTINGDESCRIPTION));
			}
			as.setSettingName(rs.getString(AppSettingsDB.SETTINGNAME));
			as.setSettingValue(rs.getString(AppSettingsDB.SETTINGVALUE));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getErrorCode() + ":" +e.getMessage() );
		}
		
		
		return as;
	}

}

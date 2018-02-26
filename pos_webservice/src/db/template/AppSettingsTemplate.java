package db.template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import db.dao.AppSettingsDAO;
import db.mapper.AppSettingMapper;
import db.tables.AppSettingsDB;
import db.tables.ProductsDB;
import objects.AppSettingOBJ;
import objects.CartItemOBJ;

public class AppSettingsTemplate implements AppSettingsDAO{

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public boolean create(String key, String value, String desc) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( AppSettingsDB.CREATESETTING, key, value, desc);
		if(result == 1){
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public AppSettingOBJ getAppSetting(String key) {
		// TODO Auto-generated method stub
		AppSettingOBJ as = jdbcTemplateObject.queryForObject(AppSettingsDB.GETRECEIPTSETTINGS, new Object[]{key}, new AppSettingMapper());
		return as;
	}

	@Override
	public List<AppSettingOBJ> listSettings() {
		// TODO Auto-generated method stub
		System.out.println("Before listSettings");
		List<AppSettingOBJ> list = jdbcTemplateObject.query(AppSettingsDB.GETALLSETTINGS, new AppSettingMapper());
		System.out.println("After listSettings");
		return list;
	}
	
	@Override
	public List<AppSettingOBJ> receiptSettings() {
		// TODO Auto-generated method stub
		List<AppSettingOBJ> list = jdbcTemplateObject.query(AppSettingsDB.GETRECEIPTSETTINGS, new AppSettingMapper());
		return list;
	}
	

	@Override
	public boolean delete(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ArrayList<AppSettingOBJ> updateSettings) {
		// TODO Auto-generated method stub
		int[] result = jdbcTemplateObject.batchUpdate(AppSettingsDB.UPDATESETTING, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement updateSetting, int i) throws SQLException {
				AppSettingOBJ setting = updateSettings.get(i);
				updateSetting.setString(1, setting.getSettingValue());
				updateSetting.setString(2, setting.getSettingName());
			}

			@Override
			public int getBatchSize() {
				return updateSettings.size();
			}
		  });
		
		for (int i = 0; i < result.length; i++){
			if(result[i] == 0){
				return false;
			}
		}
		
		return true;
		
	}



}

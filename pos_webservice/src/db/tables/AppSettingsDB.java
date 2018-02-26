package db.tables;

public class AppSettingsDB {

	 public static final String SETTINGID = "id";
	 public static final String SETTINGNAME = "SettingName";
	 public static final String SETTINGVALUE = "SettingValue";
	 public static final String SETTINGDESCRIPTION = "SettingDescription";
	 
	 public static final String GETALLSETTINGS = "select * from appsettings";
	 public static final String GETRECEIPTSETTINGS = "select * from appsettings where SettingName like ?";
	 public static final String CREATESETTING = "insert into appsettings (SettingName, SettingValue, SettingDescription) values (?,?,?)";
	 public static final String UPDATESETTING = "update appsettings set SettingValue = ? where SettingName like ?";
}

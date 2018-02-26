package db.template;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import config.Constant;
import db.dao.TimeKeepingDAO;
import db.tables.AppSettingsDB;
import db.tables.TimeKeepingDB;
import objects.UserOBJ;

public class TimeKeepingTemplate implements TimeKeepingDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public boolean createTimeRecord(UserOBJ user) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( TimeKeepingDB.TIME_IN_FINAL, user.getUserid(), user.getFirstname(), user.getLastname(), user.getUsername(), Constant.RECORD_TYPE_JOB);
		if(result == 1){
			System.out.println("createTimeRecord TRUE");
			return true;
		}
		else {
			System.out.println("createTimeRecord FALSE");
			return false;
		}
	}

	@Override
	public boolean createBreakRecord(UserOBJ user) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( TimeKeepingDB.START_BREAK_FINAL, user.getUserid(), user.getFirstname(), user.getLastname(), user.getUsername(), Constant.RECORD_TYPE_BREAK);
		if(result == 1){
			System.out.println("createBreakRecord TRUE");
			return true;
		}
		else {
			System.out.println("createBreakRecord FALSE");
			return false;
		}
	}

	@Override
	public boolean updateTimeRecord(int entry) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( TimeKeepingDB.TIME_OUT_FINAL, "end of shift", entry, Constant.RECORD_TYPE_JOB);
		if(result == 1){
			System.out.println("updateTimeRecord TRUE");
			return true;
		}
		else {
			System.out.println("updateTimeRecord FALSE");
			return false;
		}
	}

	@Override
	public boolean updateBreakRecord(int entry) {
		// TODO Auto-generated method stub
		int result = jdbcTemplateObject.update( TimeKeepingDB.END_BREAK_FINAL, "end of shift", entry, Constant.RECORD_TYPE_BREAK);
		if(result == 1){
			System.out.println("updateBreakRecord TRUE");
			return true;
		}
		else {
			System.out.println("updateBreakRecord FALSE");
			return false;
		}
	}

	@Override
	public int entryTimeRecord(Integer id) {
		// TODO Auto-generated method stub
		int entry;
		try{
			entry = jdbcTemplateObject.queryForObject(TimeKeepingDB.GET_RECORD_TODAY_FINAL, new Object[] { id, Constant.RECORD_TYPE_JOB }, Integer.class);
		}catch(EmptyResultDataAccessException e){
			entry = 0;
		}
		
		return entry;
	}

	@Override
	public int entryBreakRecord(Integer id) {
		// TODO Auto-generated method stub
		int entry = 0;
		
		try{
			entry = jdbcTemplateObject.queryForObject(TimeKeepingDB.GET_RECORD_TODAY_FINAL, new Object[] { id, Constant.RECORD_TYPE_BREAK }, Integer.class);
		}catch(EmptyResultDataAccessException e){
			entry = 0;
		}
		
		return entry;
	}

}

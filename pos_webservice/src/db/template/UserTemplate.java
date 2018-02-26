package db.template;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import db.dao.UserDAO;
import db.mapper.UserMapper;
import db.tables.UsersDB;
import objects.UserOBJ;
import utils.Password;

public class UserTemplate implements UserDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public UserOBJ getUserIfExisting(String user, String password) {
		// TODO Auto-generated method stub
		UserOBJ usr;
		
		try{
			usr = jdbcTemplateObject.queryForObject(UsersDB.GET_USER_DETAILS, new Object[]{user, Password.getEncryptedPw(password)}, new UserMapper());
		}catch(EmptyResultDataAccessException e){
			usr = null;
		}
		
		return usr;
	}

}

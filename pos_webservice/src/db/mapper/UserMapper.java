package db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.tables.UsersDB;
import objects.UserOBJ;

public class UserMapper implements RowMapper<UserOBJ>{

	@Override
	public UserOBJ mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserOBJ account = new UserOBJ();
        account.setUserid(rs.getInt(UsersDB.ID));
        account.setFirstname(rs.getString(UsersDB.FIRSTNAME));
        account.setLastname(rs.getString(UsersDB.LASTNAME));
        account.setUsername(rs.getString(UsersDB.USERNAME));
        account.setPassword(rs.getString(UsersDB.PASSWORD));
        account.setEmail(rs.getString(UsersDB.EMAIL));
        account.setRole(rs.getString(UsersDB.ROLE));
        account.setActivationKey(rs.getString(UsersDB.ACT_KEY));
        account.setResetKey(rs.getString(UsersDB.RESET_KEY));
        account.setEmailStatus(rs.getString(UsersDB.EMAIL_STATUS));
        account.setUserStat(rs.getString(UsersDB.USER_STATUS));
        account.setDateCreated(rs.getString(UsersDB.DATE_CREATED));
		
		return account;
	}

}

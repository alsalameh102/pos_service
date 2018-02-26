package db.dao;


import javax.sql.DataSource;

import objects.UserOBJ;

public interface TimeKeepingDAO {

  /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  

  public boolean createTimeRecord(UserOBJ user);
  public boolean createBreakRecord(UserOBJ user);
  public boolean updateTimeRecord(int entry);
  public boolean updateBreakRecord(int entry);

  public int entryTimeRecord(Integer id);
  public int entryBreakRecord(Integer id);

 
	
}

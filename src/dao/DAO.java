package dao;

import java.sql.ResultSet;

public interface DAO {
	public ResultSet fetch(Object o);
	public void closeConnection();
}


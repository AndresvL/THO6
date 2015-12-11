package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import dbutil.DBcon;
import dbutil.Oraclecon;

public class DAOAttribute implements DAO{
	private Connection con;
	/**
	 * 
	 * An empty constructor
	 */
	public DAOAttribute(){}

	/**
	 * The method fetch fetches a resultset from the database, specifically created for the Attribute object
	 * @param o This is the name of the businessrule.
	 * @return returns the resultSet from the database.
	 */
	@Override
	public ResultSet fetch(Object o) {
		Logger logger = Logger.getLogger("defaultLogger");
		logger.info("fetching attributes in DAOAttribute");
		String name = (String)o;
		DBcon db = new Oraclecon("tool");
		con = db.getConnection();
		Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();		
			rs = st.executeQuery("SELECT * FROM Attribute WHERE businessrulenaam='"+name+"'");
		} catch (SQLException e) {
			logger.severe("Error executing DAO fetch statement");
		}

		return rs;
	}
	
	public void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
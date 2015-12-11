package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import dbutil.DBcon;
import dbutil.Oraclecon;

public class DAOBusinessrule implements DAO{
	private Connection con;
	
	/**
	 * The method fetch fetches a resultset from the database, specifically created for the BusinessRule object
	 * @param o The object to store the resultset in.
	 * @return returns the resultSet from the database.
	 */
	public ResultSet fetch(Object o){
		Logger logger = Logger.getLogger("defaultLogger");
		logger.info("fetching businessrules in DAOBusinessrule");
		String name = (String)o;
		DBcon db = new Oraclecon("tool");
		con = db.getConnection();	
		ResultSet rs = null;
		try{
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT br.*, op.annotation FROM Businessrule br, operator op WHERE br.BUSINESSRULENAAM='" + name + "' AND br.OPERATORNAAM = op.OPERATORNAAM");
		} catch(SQLException e) {
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
	
	public void executeStatement(String database, String sqlStatement, String type) {
		DBcon db = null;
			Logger logger = Logger.getLogger("defaultLogger");
			if(type.equals("ORA")) {
				db = new Oraclecon(database);
			} else if(type.equals("MYS")) {
				//TODO: do something with MySQL
			} else {
				Logger.getLogger("defaultLogger").severe("error "+type);
			}

			Logger.getLogger("defaultLogger").severe("");
		
		con = db.getConnection();
		Statement st;
		try {
			st = con.createStatement();		
			st.executeQuery(sqlStatement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.severe("Error executing DAO fetch statement");
		}

		db.closeConnection();
	}
}
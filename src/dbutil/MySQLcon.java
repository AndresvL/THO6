package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class MySQLcon extends DBcon {
	
	public MySQLcon(String databasename) {
		super();
		super.setProperties(databasename,"Xml/Db/mysql-properties.xml");
	}
	public final Connection getConnection(){
		Logger logger = Logger.getLogger("defaultLogger");
		Connection conn = null;
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", super.userName);
		connectionProps.put("password", super.password);
	
		String currentUrlString = null;
			currentUrlString = "jdbc:" + super.dbms + "://" + super.serverName + "/" + super.dbName + "?user=" + super.userName + "&password=" + super.password;
			logger.info(currentUrlString);
			//				  jdbc:oracle:thin:@" + host + ":" + port + ":" + sid, user, password);
			// String test = jdbc:mysql://localhost/test?user=super.userName&password=super.password
			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());			
				conn = DriverManager.getConnection(currentUrlString,
					connectionProps);
	
			this.urlString = currentUrlString + this.dbName;
			conn.setCatalog(this.dbName);
			return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		
		logger.info("Connected to mysql database");
		return conn;
	}
}

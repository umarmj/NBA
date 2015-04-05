package project.dao;

import javax.naming.*;
import javax.sql.*;

public class OracleConnection {
	
	private static DataSource OracleConnection = null; //hold the database object
	private static Context context = null; //used to lookup the database connection in tomcat
	
	
	public static DataSource OracleConnectionConn() throws Exception {
		
		
		if (OracleConnection != null) {
			return OracleConnection;
		}
		
		try {
			
			
			if (context == null) {
				context = new InitialContext();
			}
			
			
			OracleConnection = (DataSource) context.lookup("java:comp/env/jdbc/confluence");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return OracleConnection;
		
	}
	

}

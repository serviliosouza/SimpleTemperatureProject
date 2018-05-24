package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Database
{
	private static Connection connection = null;
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String portNumber = "3306";
	
	synchronized public static Connection getConnection()  throws SQLException
	{
		
		try
		{
			if (connection == null)
			{
				String endpoint = System.getenv("DB_ENDPOINT");
				String databaseName = System.getenv("DB_SCHEMA");
				String username = System.getenv("DB_USERNAME");
				String password = System.getenv("DB_PASSWORD");

				String url = 
					"jdbc:mysql://" +
					endpoint        + ":" +
					portNumber      + "/" +
					databaseName    + "?autoReconnect=true";
				
				Class.forName(driverName);
				connection = DriverManager.getConnection(url, username, password);
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			throw new SQLException();
		}
		
		return (connection);
	}
	
	public static void insertReg(String sensor, String value) throws SQLException {
		PreparedStatement cookedStmt = null;
		try {		
			
			String query =
			"insert into tempdata(sensor_id, temperature)" +
			"values (?, ?)";
		
			Connection connection = getConnection();
			
			cookedStmt = connection.prepareStatement(query);
			
			cookedStmt.setString(1, sensor);
			cookedStmt.setString(2, Integer.parseInt(value));
		
			cookedStmt.executeUpdate();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if (cookedStmt != null) {
				cookedStmt.close();
			}
		}
	}
}

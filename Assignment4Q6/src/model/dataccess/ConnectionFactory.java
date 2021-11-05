package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// PARK TWO AND THREE FOR THE HOMEWORK
public class ConnectionFactory
{
	private final static String URL = "jdbc:postgresql://localhost:5433/postgres"; 
	private final static String USER = "postgres";
	private final static String PWD = "password";
	private static Connection connection;
	
	private static ConnectionFactory instance;
	
	private ConnectionFactory() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(URL, USER, PWD);
	}
	
	public static ConnectionFactory getInstance() throws ClassNotFoundException, SQLException
	{
		if(instance == null)
		{
			instance = new ConnectionFactory();
		}
		return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		return connection;	
	}
}


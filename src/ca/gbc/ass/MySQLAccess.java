package ca.gbc.ass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class MySQLAccess {
	
	private static String username = "root";
	private static String password = "password";
	private static String database = "COMP3095";
	private static Connection connect = null;
	  
	  public static Connection connectDataBase() throws Exception {
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?useTimezone=true&serverTimezone=UTC", username, password);
	      return connect;
	    } catch (Exception e) 
	    {
	      throw e;
	    } 
	    }
	  }
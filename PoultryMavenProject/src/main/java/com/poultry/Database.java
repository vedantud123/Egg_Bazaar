package com.poultry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public static Connection con() throws SQLException
	{
//		Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/poutry_testdb","root","ROOT");
		Connection  connection=DriverManager.getConnection("jdbc:mysql://poultry.sunfra.in:3306/sunfra_poultry","sunfra_poultry","VWB7K2JSLLEPSPO2V2");

		return connection;
	}
	public static void clos(Connection connection) throws SQLException
	{
		connection.close();	
	}


}

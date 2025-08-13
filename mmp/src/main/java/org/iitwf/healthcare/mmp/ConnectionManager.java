package org.iitwf.healthcare.mmp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ConnectionManager {

	private static String url = "jdbc:mysql://localhost:3306/mmp";    
	private static String driverName = "com.mysql.jdbc.Driver";   
	private static String username = "root";   
	private static String password = "root";
	private static Connection con;
	private static String[][] inputArr;
	/*
	 * 	<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.21</version>
		</dependency>
	 */
 
	public static void main(String args[])
	{
		try {
			Class.forName(driverName);
			try {
				//Create a connection to DB by passing Url,Username,Password as parameters
				con = DriverManager.getConnection(url, username, password);
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				//Executing the Queries
				stmt.executeUpdate("INSERT INTO mmp.patient_data VALUES (2,'Alexander','18-07-1986')");
				//stmt.executeUpdate("truncate table testDB.employee");
				ResultSet rs = stmt.executeQuery("SELECT * FROM mmp.patient_data");
				rs.last();
				int rows = rs.getRow();
				 
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				int cols = rsmd.getColumnCount();
				System.out.println(rows +"--" + cols);
				inputArr= new String[rows][cols];
 
				int i =0;
				rs.beforeFirst();
				//Iterating the data in the Table
				while (rs.next())
				{
					for(int j=0;j<cols;j++)
					{
						inputArr[i][j]=rs.getString(j+1);
						System.out.print("values:: " + inputArr[i][j] +":::"+i +":::"+j); 
 
					}
					System.out.println();
					i++;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("Failed to create the database connection."); 
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Driver not found."); 
		}
//		return inputArr;
 
	}
 
}

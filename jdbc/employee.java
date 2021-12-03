package jdbc;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class employee {
  

  
public static void main(String[] args)
{
	try
	{
		try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			System.out.println("Could not load driver");
		}
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","mmills20","oartoado");
	//Statement st = con.createStatement();
	String sql = "Select Lname,Ssn from EMPLOYEE,DEPARTMENT where Dno = Dnumber and Dname = ?";
	PreparedStatement ps= con.prepareStatement(sql);
	ps.setString(1, "Research");
	ResultSet r=ps.executeQuery();
	
	while(r.next()){
	    String lname=r.getString("lname");
	    String ssn=r.getString("ssn"); 
	    System.out.println("LASTNAME: "+lname +" SSN: " + ssn);
	   System.out.println("\n");
	}
	}
	catch (Exception e)
	{
		System.out.println("Error Connecting");
		e.printStackTrace();
	}
}

}

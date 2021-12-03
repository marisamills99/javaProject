package jdbc;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class query2 {
  

  
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
	String sql = "select Lname,Ssn,Hours from EMPLOYEE,DEPT_LOCATIONS,PROJECT,WORKS_ON where Dno = Dnumber and Dnumber = Dnum and Pnumber = Pno and Dlocation = ? and Pname = ?";
	PreparedStatement ps= con.prepareStatement(sql);
	ps.setString(1, "Houston");
	ps.setString(2, "ProductZ");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		String lname=rs.getString("Lname");
		String ssn=rs.getString("Ssn");
		float hours=rs.getFloat("Hours");
		System.out.println("LASTNAME: "+lname +" SSN: " + ssn+" HOURS: "+hours);
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

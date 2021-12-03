package jdbc;

import java.awt.EventQueue;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MyGUIProgram  {
	private JFrame frame;
	private JTextField textField;
	static NewJFrame firstframe = new NewJFrame();
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
		
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter your ssn: ");
				String managerssn = scanner.nextLine();
				String sql = "Select Ssn,mgrssn from EMPLOYEE,DEPARTMENT where ssn = ?and ssn = mgrssn ";
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1,managerssn );
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					System.out.println("you may proceed");
					System.out.println("\n");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								
								firstframe.setVisible(true);
								con.close();
								try {
									Class.forName("oracle.jdbc.driver.OracleDriver");
									Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","mmills20","oartoado");
									String query =  "SELECT * FROM EMPLOYEE";
									String worksOnquery= "SELECT * FROM WORKS_ON";
									String dependantquery =  "SELECT * FROM DEPENDENT";
									String query2 =  "UPDATE employee SET SSN=? AND SET FirstName= ? AND SET MINIT= ? AND SET LASTNAME= ? AND SET BIRTHDAY=? AND SET ADDRESS=? AND SET AND SEX=? SALARY=?  \"MANAGER SSN\" + \"\\t\"+\"DEPARTMENT\" +  \"\\t\" +  \"EMAIL\" + \"\\t\" WHERE ssn = '888665555';";
									Statement stmt = conn.createStatement();
									//int count = stmt.executeUpdate(query2);
									//System.out.println("Number of rows updated by executing query1 =  " + count);
									System.out.println("Employee table");
									ResultSet rs = stmt.executeQuery(query);
									DBTablePrinter.printResultSet(rs);
									System.out.println("Works_on table");
									ResultSet res = stmt.executeQuery(worksOnquery);
									DBTablePrinter.printResultSet(res);
									System.out.println("Dependent table");
									ResultSet r = stmt.executeQuery(dependantquery);
									DBTablePrinter.printResultSet(r);
									/*System.out.println("SSN " + "\t" + "FirstName" +  "\t" +"MIDDLE INT" +  "\t" +  "LASTNAME" + "\t" + "BIRTHDAY"+ "\t"+ "ADDRESS"+ "\t"+"SEX" +"\t"+"SALARY" +  "\t" +  "MANAGER SSN" + "\t"+"DEPARTMENT" +  "\t" +  "EMAIL" + "\t");
									ResultSet rs = stmt.executeQuery(query);
									while(rs.next()) 
									{
									System.out.print(rs.getString("ssn") + "\t");
									System.out.print(rs.getString("fname") + "\t");
									System.out.print(rs.getString("minit")+ "\t" );
									System.out.print(rs.getString("lname") + "\t");
									System.out.print(rs.getString("bdate") + "\t");
									System.out.print(rs.getString("address") + "\t");
									System.out.print(rs.getString("sex")+ "\t" );
									System.out.print(rs.getString("salary") + "\t");
									System.out.print(rs.getString("superssn") + "\t");
									System.out.print(rs.getString("dno")+ "\t" );
									System.out.println(rs.getString("email") + "\t");
									
									}
									System.out.println("Works_on table");
									System.out.println("ESSN " + "\t" + "PNO" +  "\t" +"HOURS" +  "\t" );
									ResultSet r = stmt.executeQuery(worksOnquery);
									while(r.next()) 
									{
									System.out.print(r.getString("essn") + "\t");
									System.out.print(r.getString("pno") + "\t");
									System.out.println(r.getString("hours")+ "\t" );

									}
									System.out.println("Dependant table");
									System.out.println("ESSN " + "\t"+"\t" + "Dependent Name" +  "\t" +"Sex" +  "\t" + "Birthday" +  "\t" +"Relationship" +  "\t"  );
									ResultSet res = stmt.executeQuery(dependantquery);
									while(res.next()) 
									{
									System.out.print(res.getString("essn") + "\t" + "\t");
									System.out.print(res.getString("dependent_name") + "\t" +"\t");
									System.out.print(res.getString("sex")+ "\t" );
									System.out.print(res.getString("bdate") + "\t"+"\t");
									System.out.println(res.getString("relationship")+ "\t" );

									}*/
									conn.close();

						        } catch (Exception e) {

						            System.out.println("Connection Failed! Check output console");
						            e.printStackTrace();
						            return;

						        }
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else {
					System.out.println("Error only managers can insert employees");
					//System.out.print("Enter your ssn: ");
					//String ssn = scanner.nextLine();
				}
				
			}catch (Exception e)
			{
				System.out.println("Error only managers can insert employees");
				e.printStackTrace();
			}
		
		
		}
		catch (Exception e)
		{
			System.out.println("Error Connecting");
			e.printStackTrace();
		}
	}



}

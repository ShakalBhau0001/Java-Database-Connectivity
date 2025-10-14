package dynamicJdbc;

import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.OracleDriver;

public class InsertingRecord {
	public static void main(String[] args) throws Exception{
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter Employee Id:-");
			int id= sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Employee Name:-");
			String name= sc.nextLine();
			System.out.println("Enter Employee Address:-");
			String address = sc.nextLine();
			System.out.println("Enter Employee Mobile No:");
			long mobile_no= sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Employee Designation:");
			String designation= sc.nextLine();
			System.out.println("Enter Employee Department:");
			String department= sc.nextLine();
			System.out.println("Enter Employee Salary:");
			float salary = sc.nextFloat();
			sc.nextLine();
			
			PreparedStatement ps = con.prepareStatement("insert into EMP values(?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setLong(4, mobile_no);
			ps.setString(5, designation);
			ps.setString(6, department);
			ps.setFloat(7, salary);
			int count = ps.executeUpdate();
			System.out.println(count+" "+"row created");
			
        	System.out.println("Do You Want To Record Insert [Y/N]");			
			String ch = sc.nextLine();
			if(ch.equalsIgnoreCase("N"))
				break;
		}
		con.close();
	}
}

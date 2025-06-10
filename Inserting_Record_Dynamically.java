// Inserting Multiple Records

package jdbc;

import java.io.*;
import java.sql.*;

public class jdbc7 {

	public static void main(String[] args) {
		try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            PreparedStatement stmt = con.prepareStatement("insert into std1 values(?,?,?)");
            BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
            while(true)
            {
            	System.out.println("Enter Roll Number:->");
            	int rno = Integer.parseInt(br.readLine());
            	System.out.println("Enter Student Name:->");
            	String sname = br.readLine();
            	System.out.println("Enter Fees :->");
            	int fees = Integer.parseInt(br.readLine());
            	stmt.setInt(1, rno);
            	stmt.setString(2, sname);
            	stmt.setLong(3, fees);
            	int cnt = stmt.executeUpdate();
            	System.out.println(cnt +" Record Inserted");
            	System.out.println("Do You Want To Record Insert [Y/N]");
            	String ch = br.readLine();
            	if(ch.equalsIgnoreCase("N"))
            		break;
            }
            con.close();
        }
		catch (Exception e)
		{
            System.out.println(e);			
		}

	}

}

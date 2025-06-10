// Updating Record

package jdbc;

import java.sql.*;

public class jdbc3 {

	public static void main(String[] args) {
		try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("update std1 set sname='Sunny' where rno=1");
            System.out.println("Record Updated Successfully..");
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

	}

}

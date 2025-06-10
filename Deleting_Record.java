// Deleting Record

package jdbc;

import java.sql.*;

public class jdbc4 {

	public static void main(String[] args) {
		try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("delete from std1 where rno=5");
            System.out.println("Record Deleted Successfully..");
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

	}

}

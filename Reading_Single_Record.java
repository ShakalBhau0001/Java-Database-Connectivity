// Reading Single Record

package jdbc;

import java.sql.*;

public class jdbc5 {

	public static void main(String[] args) {
		try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from std1");
            rs.absolute(3);
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3));
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }	
	}

}

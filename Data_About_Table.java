// Data About Table

package jdbc;

import java.sql.*;

public class jdbc8 {

	public static void main(String[] args) {
		try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            PreparedStatement stmt = con.prepareStatement("select * from std1");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData  rsm = rs.getMetaData();
            System.out.println("Total Column:- "+ rsm.getColumnCount());
            System.out.println("Column Name:- "+ rsm.getColumnName(3));
            System.out.println("Column DataType:- "+ rsm.getColumnTypeName(2));
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }	

	}

}

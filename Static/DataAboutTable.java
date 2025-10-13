package staticJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class DataAboutTable {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
    PreparedStatement stmt = con.prepareStatement("select * from student");
    ResultSet rs = stmt.executeQuery();
    ResultSetMetaData  rsm = rs.getMetaData();
    System.out.println("Total Column:- "+ rsm.getColumnCount());
    System.out.println("Column Name:- "+ rsm.getColumnName(3));        
    System.out.println("Column DataType:- "+ rsm.getColumnTypeName(2));
		con.close();
	}
}

package staticJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class ReadingMultipleRecords {
	public static void main(String[] args) throws Exception {
	DriverManager.registerDriver(new OracleDriver());
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
  Statement stmt=con.createStatement();
  ResultSet rs = stmt.executeQuery("select * from student");
  while(rs.next())
    {
      System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3));
    }
    con.close();
  }
}

package staticJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class DeletingRecord {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
    Statement stmt=con.createStatement();
    stmt.executeUpdate("delete from student where roll_number=5");
    System.out.println("Record Deleted Successfully..");
    con.close();
  }
}

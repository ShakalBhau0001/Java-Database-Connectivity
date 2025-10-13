package staticJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class UpdatingRecord {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
    Statement stmt=con.createStatement();
    stmt.executeUpdate("update student set student_name ='Sunny' where roll_number=1");
    System.out.println("Record Updated Successfully..");
    con.close();
  }
}

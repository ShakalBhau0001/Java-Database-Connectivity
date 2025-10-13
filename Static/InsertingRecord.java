package staticJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class InsertingRecord {
  public static void main(String[] args) throws Exception {
    DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
    Statement stmt=con.createStatement();
    stmt.executeUpdate("insert into student values(1,'John',20000)");
    stmt.executeUpdate("insert into student values(2,'Sam',18000)");
    stmt.executeUpdate("insert into student values(3,'Elia',16000)");
    stmt.executeUpdate("insert into student values(4,'David',14000)");
    stmt.executeUpdate("insert into student values(5,'Tom',12000)");
    System.out.println("Record Inserted Successfully..");
    con.close();
  }
}

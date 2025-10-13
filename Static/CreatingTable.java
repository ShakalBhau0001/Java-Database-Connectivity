package staticJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class CreatingTable {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
		Statement st = con.createStatement();
    	st.executeUpdate("create table student(roll_number number primary key, student_name varchar2(20),college_fees number(5))");
    	System.out.println("Table Created Successfully..");
    	con.close();
  	}
}

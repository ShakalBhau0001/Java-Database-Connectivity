package staticJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class ConnectionEstablish {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
    	System.out.println("Connection Established Successfully");
		con.close();
	}
}

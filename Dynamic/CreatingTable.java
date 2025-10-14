package dynamicJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class CreatingTable {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","test","test");
		Statement st = con.createStatement();
		st.execute("create table EMP(empid number primary key,empname varchar2(50),address varchar2(50),mobileno number(10),designation varchar2(20),department varchar2(20),salary number(7,2))");
		System.out.println("Table Created");
		con.close();
	}
}

package dynamicJdbc;

import java.sql.*;
import oracle.jdbc.OracleDriver;

public class DisplayRecord {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test", "test");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%-6s %-20s %-15s %-12s %-15s %-15s %-10s\n",
            "EMPID", "EMPNAME", "ADDRESS", "MOBILENO", "DESIGNATION", "DEPARTMENT", "SALARY");
        System.out.println("---------------------------------------------------------------------------------------------------");

        while (rs.next()) {
            int empid = rs.getInt("empid");
            String empname = rs.getString("empname");
            String address = rs.getString("address");
            long mobileno = rs.getLong("mobileno");
            String designation = rs.getString("designation");
            String department = rs.getString("department");
            float salary = rs.getFloat("salary");

            System.out.printf("%-6d %-20s %-15s %-12d %-15s %-15s %-10.2f\n",empid, empname, address, mobileno, designation, department, salary);
        }
        con.close();
    }
}

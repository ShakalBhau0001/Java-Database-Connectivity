package dynamicJdbc;

import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.OracleDriver;

public class DeletingRecord {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test", "test");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Employee Id to delete:");
            int id = sc.nextInt();
            sc.nextLine();

            PreparedStatement ps = con.prepareStatement("DELETE FROM EMP WHERE empid = ?");
            ps.setInt(1, id);

            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("Record with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No record found with ID: " + id);
            }

            System.out.println("Do you want to delete another record? [Y/N]");
            String ch = sc.nextLine();
            if (ch.equalsIgnoreCase("N"))
                break;
        }
        con.close();
    }
}

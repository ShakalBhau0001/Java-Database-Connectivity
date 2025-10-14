package dynamicJdbc;

import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.OracleDriver;

public class UpdatingRecord {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test", "test");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Employee Id to update: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            PreparedStatement fetch = con.prepareStatement("SELECT * FROM EMP WHERE empid=?");
            fetch.setInt(1, id);
            ResultSet rs = fetch.executeQuery();

            if (!rs.next()) {
                System.out.println("No record found with ID: " + id);
            } else {
                String currentName = rs.getString("empname");
                String currentAddress = rs.getString("address");
                long currentMobile = rs.getLong("mobileno");
                String currentDesignation = rs.getString("designation");
                String currentDepartment = rs.getString("department");
                float currentSalary = rs.getFloat("salary");

                System.out.println("Press Enter to keep existing value.");
                System.out.print("Enter New Employee Name [" + currentName + "]: ");
                String name = sc.nextLine();
                if (name.isEmpty()) name = currentName;

                System.out.print("Enter New Employee Address [" + currentAddress + "]: ");
                String address = sc.nextLine();
                if (address.isEmpty()) address = currentAddress;

                System.out.print("Enter New Employee Mobile No [" + currentMobile + "]: ");
                String mobileInput = sc.nextLine();
                long mobile_no = mobileInput.isEmpty() ? currentMobile : Long.parseLong(mobileInput);

                System.out.print("Enter New Employee Designation [" + currentDesignation + "]: ");
                String designation = sc.nextLine();
                if (designation.isEmpty()) designation = currentDesignation;

                System.out.print("Enter New Employee Department [" + currentDepartment + "]: ");
                String department = sc.nextLine();
                if (department.isEmpty()) department = currentDepartment;

                System.out.print("Enter New Employee Salary [" + currentSalary + "]: ");
                String salaryInput = sc.nextLine();
                float salary = salaryInput.isEmpty() ? currentSalary : Float.parseFloat(salaryInput);

                PreparedStatement ps = con.prepareStatement("UPDATE EMP SET empname=?, address=?, mobileno=?, designation=?, department=?, salary=? WHERE empid=?");
                ps.setString(1, name);
                ps.setString(2, address);
                ps.setLong(3, mobile_no);
                ps.setString(4, designation);
                ps.setString(5, department);
                ps.setFloat(6, salary);
                ps.setInt(7, id);

                int count = ps.executeUpdate();
                System.out.println(count + " row(s) updated.");
            }

            System.out.print("Do you want to update another record? [Y/N]: ");
            String ch = sc.nextLine();
            if (ch.equalsIgnoreCase("N"))
                break;
        }
        con.close();
    }
}

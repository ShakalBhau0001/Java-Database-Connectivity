// Inserting Record

package jdbc;

import java.sql.*;

public class jdbc2 
{
    public static void main(String[] args)
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into std1 values(1,'John',20000)");
            stmt.executeUpdate("insert into std1 values(2,'Sam',18000)");
            stmt.executeUpdate("insert into std1 values(3,'Elia',16000)");
            stmt.executeUpdate("insert into std1 values(4,'David',14000)");
            stmt.executeUpdate("insert into std1 values(5,'Tom',12000)");
            System.out.println("Record Inserted Successfully..");
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}

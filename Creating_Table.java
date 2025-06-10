// Creating Table

package jdbc;

import java.sql.*;

public class jdbc1 
{
    public static void main(String[] args)
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("create table std1(rno number, sname varchar2(20),fees number(5))");
            System.out.println("Table Created Successfully..");
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}

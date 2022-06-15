package parking.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector 
{
    static Connection con=null;
    static Statement st=null;
    static
    {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","root");
        st=con.createStatement();
    }
    catch(SQLException e)
    {
        System.out.println("error in making connection");
    }
    catch(ClassNotFoundException e)
    {
        System.out.println("error in loading drivers");
    }
    }
    static Statement getStatement()
    {
        return st;
    }
}

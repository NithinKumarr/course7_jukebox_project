package databaseConnection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection
{
    public java.sql.Connection sqlConnection()
    {
        java.sql.Connection con=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // load the driver
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/jukebox_project", "root", "Bunny@123");
        }

        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return con;
    }

}
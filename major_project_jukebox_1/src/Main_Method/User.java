package Main_Method;
import Exceptions.Email_Exception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class User
{
    Connection con;
    public static int CheckUser(Connection con, String user_Name) {
        int found = 0;
        try {
            String sql = "Select * from checking_user where user_Name=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user_Name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                found++;
                break;
            }
        }
       catch (SQLException e) {System.out.println(e);}
       if (found == 1) {
        return 1;
        } else
            return 0;
    }
    public int signUp(Connection con, String user_Name, String password, String email, long phone_Number)
    {
        {
            int exist = CheckUser(con, user_Name);
            if (exist == 1)
            {
//                throw new Email_Exception("Email not found");
                System.out.println(".....................User Already Exist........................");
                return exist;
            }
        }
        try {
            String sql = "insert into checking_user(user_Name,password,email,phone_Number) values(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user_Name);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setLong(4, phone_Number);
            statement.executeUpdate();
           System.out.println(" ---------------Successfully REGISTERED--------------");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return 1;
    }
    public boolean Login(Connection conn, String user_Name, String password) {
        Scanner src = new Scanner(System.in);
        try {
            String sql = "Select * from checking_user where user_Name=? and password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user_Name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                System.out.println("\n  WELCOME USER:  "+  user_Name.toUpperCase());
            }
            else
            {
                System.out.println("................Your Entered Wrong User Name or  Password..................");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
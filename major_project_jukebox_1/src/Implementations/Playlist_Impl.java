package Implementations;
import java.sql.*;

public class Playlist_Impl
{
    Connection con;
    public void displayplaylist( int user_id,Connection con)
    {
        try
        {
            boolean found = false;
            String sql = "Select * from playlist where user_id =?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,user_id);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(" PLAYLIST ID        PLAYLIST NAME "    );
            System.out.println(" ----------------------------------------------");
            while (resultSet.next())
            {
               found=true;
                System.out.format(" %-15s %-25s  %n",resultSet.getInt(1),
                        resultSet.getString(2));
            }
            if(found==false)
                System.out.println("no data found for "+user_id);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
   public void addsongtoplaylist(int playlist_Id,int song_id,int user_id,Connection con)
   {
        try {
            String sql = "insert into  playlist_display values (?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playlist_Id);
            statement.setInt(2, song_id);
            statement.setInt(3, user_id);
            statement.executeUpdate();
            System.out.println("---------Records added----------");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void PlaylistSongs(int playList_Id,Connection con){
        try {
            String sql = "select * from songs_list where song_Id in(select song_Id from playlist_display where playlist_Id=?)";
            PreparedStatement statement1 = con.prepareStatement(sql);
            statement1.setInt(1, playList_Id);
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()) {
                System.out.format("%-5s %-25s %-25s %-25s %-10s  %n", resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
       public void CreatePlayList(String playlist_Name, int user_Id,Connection con)
       {
        try {
        String sql = "insert into  playList(playlist_Name,user_Id) values  (?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, playlist_Name);
        statement.setInt(2, user_Id);
        statement.executeUpdate();
        System.out.println("--------Records added--------");
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
        }
}

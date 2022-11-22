//package Play_music;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class playlist_id_music
//{
//    Connection con;
//    String path;
//    Scanner s=new Scanner(System.in);
//
//    public String showSongPath(Connection con)
//    {
//        try{
//
//            int choice=s.nextInt();
//            String pl_song_Name ="create table playlist_display(playlist_Id int, foreign key(playList_Id) references playList(playList_Id)";
//            PreparedStatement statement1= con.prepareStatement(pl_song_Name);
//            statement1.setInt(1,choice);
//            ResultSet result=statement1.executeQuery();
//            while (result.next())
//            {
//                path=result.getString(7);
//            }
//        }
//        catch (SQLException e)
//        {
//            System.out.println("Table not showing");
//        }
//        return path;
//    }
//}

package Implementations;

import Exceptions.Incorrect_Exception;
import details.songs_list_details;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//public class songslistTest {
////    Connection getConnection = new Connection();
//    java.sql.Connection con = getConnection.sqlConnection();
//    songs_list_Impl songsList=new songs_list_Impl();
//    List<songs_list_details> list=songsList.AllSongInList(Connection con);
//
//
//    @Test
//    public void sortByArtistName() throws SQLException, ClassNotFoundException, Incorrect_Exception {
//        List<songs_list_details> artist=songsList.sortbyArtist("Honey Singh", list);
//        assertEquals(2,artist.size());    }
//
//    @Test
//    public   void sortByGenre() throws SQLException, ClassNotFoundException, Incorrect_Exception {
//        List<songs_list_details> genre = songsList.sortbygenre("Romantic", list);
//        assertEquals(3, genre.size());}
//}

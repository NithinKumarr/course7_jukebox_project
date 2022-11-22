package Implementations;

import details.songs_list_details;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Exceptions.Incorrect_Exception;
public class songs_list_Impl
{
public List<songs_list_details> AllSongInList(Connection con)
{
List<songs_list_details> list1=new ArrayList<>();
        try {
            String sql = "select * from songs_list";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            songs_list_details songs1;
            while (resultSet.next()) {
                int songId = resultSet.getInt(1);
                String songName = resultSet.getString(2);
                String artistName = resultSet.getString(3);
                String album = resultSet.getString(4);
                String genre = resultSet.getString(5);
                Time duration = resultSet.getTime(6);
                songs1 = new songs_list_details(songId, songName, artistName, album, genre, duration);
                list1.add(songs1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list1;
    }
    public void showAllSongs(Connection con)
    {
        try {
            String sql = "select * from songs_list";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("                                        ALL SONGS                                          ");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("ID        SONG NAME               ARTIST                     ALBUM                 GENRE                      TIME");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            while (resultSet.next())
            {
                System.out.format("%-5s %-25s %-25s %-25s %-15s %-30s %n", resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getTime(6));
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public List<songs_list_details> sortbysongName (String song_Name, List<songs_list_details> songs) throws Incorrect_Exception
    {
        List<songs_list_details> BySong_Name = new ArrayList<>();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("ID         SONG NAME             ARTIST                       ALBUM                        GENRE              " );
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (songs_list_details songs1 : songs)
        {
            if (songs1.getSong_Name().equalsIgnoreCase(song_Name))
            {
                BySong_Name.add(songs1);
            }
                                                                                                                    //            BySong_Name.sort((o1, o2) ->
                                                                                                                           //            {
                                                                                                                        //                return o1.getSong_Name().compareToIgnoreCase(o2.getSong_Name());
                                                                                                                           //            });
            try {
                if (song_Name.isEmpty())
                {
                    throw new Incorrect_Exception("NO song found" ) ;
                }
            }
            catch (Incorrect_Exception o)
            {
                System.out.println(o.getMessage());
            }

        }
        return BySong_Name;
    }

    public List<songs_list_details>sortbyArtist (String artist_Name, List<songs_list_details> songs) throws Incorrect_Exception
    {
        List<songs_list_details> Artist_Name = new ArrayList<>();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("ID         SONG NAME             ARTIST                       ALBUM                        GENRE              " );
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (songs_list_details songs1 : songs)
        {
            if (songs1.getArtist().equalsIgnoreCase(artist_Name))
            {
                Artist_Name.add(songs1);
            }
                                                                                                                      //            Artist_Name.sort((o1, o2) ->
                                                                                                                      //            {
                                                                                                                        //                return o1.getArtist().compareToIgnoreCase(o2.getArtist());
                                                                                                                          //            });
        }
        try {
            if (Artist_Name.isEmpty())
            {
                throw new Incorrect_Exception("NO song is found by this Search" ) ;
            }
        }
        catch (Incorrect_Exception o)
        {
            System.out.println(o.getMessage());
        }
    return Artist_Name;
    }
    public List<songs_list_details> sortbygenre(String genre, List<songs_list_details> songs) throws Incorrect_Exception
    {
        List<songs_list_details> ByGenre = new ArrayList<>();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("ID         SONG NAME             ARTIST                       ALBUM                        GENRE              " );
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (songs_list_details songs1 : songs)
        {
            if (songs1.getGenre().equalsIgnoreCase(genre))
            {
                ByGenre.add(songs1);
            }
                                                                                                                           //            ByGenre.sort((o1, o2) ->
                                                                                                                             //            {

                                                                                                                            //                return o1.getGenre().compareToIgnoreCase(o2.getGenre());
                                                                                                                        //            });
        }
        try {
            if (ByGenre.isEmpty())
            {
                throw new Incorrect_Exception("NO song is found by this Search" ) ;
            }
        }
        catch (Incorrect_Exception o)
        {
            System.out.println(o.getMessage());
        }
        return ByGenre;
    }
    public List<songs_list_details> sortbyAlbum (String album_Name, List<songs_list_details> songs) throws Incorrect_Exception
    {
        List<songs_list_details> album = new ArrayList<>();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("ID         SONG NAME             ARTIST                       ALBUM                             GENRE              " );
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (songs_list_details songs1 : songs)
        {
            if (songs1.getAlbum_Name().equalsIgnoreCase(album_Name))
            {
                album.add(songs1);
            }
                                                                                                                             //            album.sort((o1, o2) ->
                                                                                                                              //            {
                                                                                                                             //                return o1.getAlbum_Name().compareToIgnoreCase(o2.getAlbum_Name());
                                                                                                                             //            });
        }
        return album;
    }
        }



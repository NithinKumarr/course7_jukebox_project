package Main_Method;
import Implementations.Playlist_Impl;
import Implementations.songs_list_Impl;
import databaseConnection.Connection;
import Play_music.Play_Song;
import Play_music.song_path;

import java.util.Scanner;
public class main extends user_main
{
    public static int menu()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println( "\nPlease Select from Following");
        System.out.println("\n1) Display All Available Songs ");
        System.out.println("2) Filter by Artist Name  ");
        System.out.println("3) Filter by Album Name ");
        System.out.println("4) Filter by Genre   ");
        System.out.println("5) Filter by Song Name");
        System.out.println("6) Display  Your playlist ");
        System.out.println("7) Create Your own Playlist ");
        System.out.println("8) Add Song to Your Existing Playlist ");
        System.out.println("9) Exit "   );
         int option = sc.nextInt();
        return option;
    }
public static short case7()
{
    Scanner sc = new Scanner(System.in);

    Connection getConnection = new Connection();
    java.sql.Connection con = getConnection.sqlConnection();
    song_path url1 = new song_path();
    String path1;
    songs_list_Impl music_obj = new songs_list_Impl();
    Playlist_Impl pl_obj=new Playlist_Impl();

    System.out.println("Enter your user Id");
    int user_id = sc.nextInt();
    System.out.println(" Create  your Playlist Name ");
    String play_name = sc.next();
    System.out.println();
    pl_obj.CreatePlayList(play_name, user_id, con);   //calling method
    System.out.println("     ---  Playlist created Sucessfully   ----");
    pl_obj.displayplaylist(user_id, con);
    System.out.println();

    System.out.println("\n Enter playlist id  to add");
    int pl_id = sc.nextInt();
    music_obj.showAllSongs(con);

    System.out.println("Enter Song Id to add song to your playlist");
    int song_id = sc.nextInt();
    pl_obj.addsongtoplaylist(pl_id, song_id, user_id, con);
    System.out.println("     --- Songs Added Succesfully   ----");
    System.out.println("\nPLAYLIST NAME :- "+play_name.toUpperCase()+ " HAS THESE SONGS \n U CAN CHOOSE FROM THEM");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
   System.out.println("ID        SONG NAME               ARTIST                     ALBUM                 GENRE                      TIME");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
   // song_heading();

    pl_obj.PlaylistSongs(pl_id,con);
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("\nChoose the song id you want to play ");
    path1 = url1.showSongPath(con);
    Play_Song.playSong(path1);

    return 0;
}
public static String case8()
    {
        Scanner sc = new Scanner(System.in);

        Connection getConnection = new Connection();
        java.sql.Connection con = getConnection.sqlConnection();
        User userCheck = new User();
        song_path url1 = new song_path();
        String path1;
        Playlist_Impl pl_obj=new Playlist_Impl();
        songs_list_Impl music_obj = new songs_list_Impl();
        System.out.println(" Enter your User id to enter song to your Existing Playlist ");
        int user_id = sc.nextInt();
        pl_obj.displayplaylist(user_id, con);
        System.out.println();
        music_obj.showAllSongs(con);
        System.out.println("Enter playlist id on which you want to add");
        int pl_id = sc.nextInt();
        System.out.println("Enter Song Id to add song to your playlist");
        int song_id = sc.nextInt();
        pl_obj.addsongtoplaylist(pl_id, song_id, user_id, con);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ID        SONG NAME               ARTIST                     ALBUM                 GENRE                      TIME");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        pl_obj.PlaylistSongs(pl_id,con);
        System.out.println(" Enter your song Id ");
        path1 = url1.showSongPath(con);
        Play_Song.playSong(path1);
        System.out.println("     --- Songs Added to Existing Playlist Succesfully   ----");
        System.out.println("\nEnter Your User id TOinsert song to playlist ");
        return path1;
    }
}


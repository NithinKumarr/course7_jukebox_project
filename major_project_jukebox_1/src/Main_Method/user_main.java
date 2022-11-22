package Main_Method;
import databaseConnection.Connection;
import Play_music.*;
import Implementations.songs_list_Impl;
import java.util.List;
import java.util.Scanner;
import details.songs_list_details;
import Implementations.Playlist_Impl;
import Exceptions.Email_Exception;
import Exceptions.Incorrect_Exception;
import Exceptions.Password_Exception;
import static Main_Method.main.*;

public class user_main
{
    public static void main(String[] args) throws Email_Exception, Incorrect_Exception, Password_Exception {
        Scanner sc = new Scanner(System.in);
        Connection getConnection = new Connection();
        java.sql.Connection con = getConnection.sqlConnection();
        User userCheck = new User();
        song_path songpath = new song_path();
        String path1;
        songs_list_Impl songslist = new songs_list_Impl();
        Playlist_Impl playlist = new Playlist_Impl();
        int b, flag = 1, option;
        System.out.println();
        System.out.println("       ️    WELCOME TO  JUKEBOX                ");
        System.out.println("PRESS 1)   To Continue ");
        System.out.println("PRESS 0)   To Exit ");
        option = sc.nextInt();
        while (option == 1) {
            System.out.println("============Welcome to JUKEBOX=============");
            System.out.println("  \n  1) LOG IN ");
            System.out.println("  2) SIGN UP");
            int choice = sc.nextInt();
            int k = 1, j = 1;
            switch (choice)                 //1st switchcase
            {
                case 1: {
                    System.out.println(" Enter user Name");
                    String name = sc.next();
                    System.out.println("Enter Your Password  ");
                    String password = sc.next();
                    boolean a = userCheck.Login(con, name, password);
                    if (a == false) {
                        System.out.println("=================================================================");
                        break;
                    }
                    while (k == 1) {
                        int cho = menu();
                        switch (cho)                        //inner switch 2nd case
                        {
                            case 1: {
                                songslist.showAllSongs(con);
                                System.out.println(" Enter your song Id ");
                                path1 = songpath.showSongPath(con);
                                Play_Song.playSong(path1);
                                System.out.println("  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           " + "\u001B[0m");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    continue;
                                }
                                k = 0;
                                break;
                            }
                            case 2: {
                                try {
                                    System.out.println("Enter Artist Name ");
                                    String artist_name = sc.next();
                                    List<songs_list_details> list = songslist.AllSongInList(con);
                                    List<songs_list_details> song = songslist.sortbyArtist(artist_name, list);
                                    for (songs_list_details list1 : song) {
                                        System.out.format("%-10s %-20s %-28s %-30s  %-20s  %n", list1.getSongs_id(),
                                                list1.getSong_Name(), list1.getArtist(), list1.getAlbum_Name(), list1.getGenre());
                                    }
                                    if (song.isEmpty()) {
                                        throw new Incorrect_Exception("--------------------------");

                                    }
                                } catch (Incorrect_Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("    FOR MAIN MENU  Enter 1) TO MAIN MENU                2) TO EXIT           ");
                                    b = sc.nextInt();
                                    if (b == 1) {
                                        k = 1;
                                        option = 0;
                                        continue;
                                    }
                                    break;
                                }
                                while (flag == 1) {
                                    System.out.println("\n Enter Song Id   to listen ");
                                    path1 = songpath.showSongPath(con);
                                    Play_Song.playSong(path1);
                                    System.out.println("  PRESS  \n 1) to PLAY ANOTHER SONG ️ " +
                                            "         0) TO GO  MAIN MENU  ");
                                    flag = sc.nextInt();
                                }
                                System.out.println("  FOR MAIN MENU  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    option = 0;
                                    continue;
                                }
                                k = 0;
                                break;
                            }
                            case 3: {
                                try {
                                    System.out.println("Enter Album Name ");
                                    String album_Name = sc.next();
                                    List<songs_list_details> list = songslist.AllSongInList(con);
                                    List<songs_list_details> song = songslist.sortbyAlbum(album_Name, list);
                                    for (songs_list_details list1 : song) {
                                        System.out.format("%-10s %-20s %-28s %-25s  %-20s %-20s %n", list1.getSongs_id(),
                                                list1.getSong_Name(), list1.getArtist(), list1.getAlbum_Name(), list1.getGenre(), list1.getDuration());
                                    }
                                    if (song.isEmpty()) {
                                        throw new Incorrect_Exception("No Search Data Found");
                                    }
                                } catch (Incorrect_Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("  DO YOU WANT TO GO BACK TO MAIN MENU  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                    b = sc.nextInt();
                                    if (b == 1) {
                                        k = 1;
                                        option = 0;
                                        continue;
                                    }
                                    break;
                                }
                                while (flag == 1) {
                                    System.out.println("\n Enter Song Id which you want to play:-");
                                    path1 = songpath.showSongPath(con);
                                    Play_Song.playSong(path1);
                                    System.out.println("  PRESS  \n 1) to PLAY ANOTHER SONG   " +
                                            "         0) TO GO TO MAIN MENU  ");
                                    flag = sc.nextInt();
                                }
                                System.out.println("\n Enter Song Id which you want to listen  :-");
                                path1 = songpath.showSongPath(con);
                                Play_Song.playSong(path1);
                                System.out.println(" DO YOU WANT TO GO BACK TO MAIN MENU \n Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    continue;
                                }
                                k = 0;
                                break;
                            }
                            case 4: {
                                try {
                                    System.out.println("Enter Genre ");
                                    String genre = sc.next();
                                    List<songs_list_details> list = songslist.AllSongInList(con);
                                    List<songs_list_details> song = songslist.sortbygenre(genre, list);
                                    for (songs_list_details list1 : song) {
                                        System.out.format("%-10s %-20s %-28s %-30s  %-20s %n", list1.getSongs_id(),
                                                list1.getSong_Name(), list1.getArtist(), list1.getAlbum_Name(), list1.getGenre(), list1.getDuration());
                                    }
                                    if (song.isEmpty()) {
                                        throw new Incorrect_Exception("No Search Data Found");
                                    }

                                } catch (Incorrect_Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("  DO YOU WANT TO GO BACK TO MAIN MENU  Enter 1)   GO TO MAIN MENU                2) TO EXIT           ");
                                    b = sc.nextInt();
                                    if (b == 1) {
                                        k = 1;
                                        option = 0;
                                        continue;
                                    }
                                    break;
                                }
                                while (flag == 1) {
                                    System.out.println("\n Enter Song Id  to play:  ️");
                                    path1 = songpath.showSongPath(con);
                                    Play_Song.playSong(path1);
                                    System.out.println("  PRESS  \n 1) to PLAY ANOTHER SONG   " +
                                            "         0) tO  MAIN MENU  ");
                                    flag = sc.nextInt();
                                }
                                System.out.println("\n Enter Song Id:- ️  ");
                                path1 = songpath.showSongPath(con);
                                Play_Song.playSong(path1);
                                System.out.println("  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    continue;
                                }
                                k = 0;
                                break;
                            }
                            case 5: {
                                try {
                                    songslist.showAllSongs(con);
                                    List<songs_list_details> list = songslist.AllSongInList(con);
                                    System.out.println("Enter Song Name ");
                                    String songName = sc.next();
                                    List<songs_list_details> song = songslist.sortbysongName(songName, list);
                                    for (songs_list_details list1 : song) {
                                        System.out.format("%-10s %-20s %-28s %-30s  %-25s %n", list1.getSongs_id(),
                                                list1.getSong_Name(), list1.getArtist(), list1.getAlbum_Name(), list1.getGenre(), list1.getDuration());
                                    }
                                    if (song.isEmpty()) {
                                        throw new Incorrect_Exception("No Search Data Found");
                                    }

                                } catch (Incorrect_Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("  DO YOU WANT TO GO BACK TO MAIN MENU  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                    b = sc.nextInt();
                                    if (b == 1) {
                                        k = 1;
                                        option = 0;
                                        continue;
                                    }
                                    break;
                                }
                                while (flag == 1) {
                                    System.out.println("\n Enter Song Id to play: ️-");
                                    path1 = songpath.showSongPath(con);
                                    Play_Song.playSong(path1);
                                    System.out.println("  PRESS  \n 1) to PLAY ANOTHER SONG   " +
                                            "         0) TO GO TO MAIN MENU  ");
                                    flag = sc.nextInt();
                                }
                                System.out.println("\n Enter Song Id:-");
                                path1 = songpath.showSongPath(con);
                                Play_Song.playSong(path1);
                                System.out.println("  Enter1)    TO GO TO MAIN MENU       \n         Enter 2) TO EXIT           ");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    continue;
                                }
                                k = 0;
                                break;
                            }
                            case 6: {

                                System.out.println("Enter your user Id");
                                int user_id = sc.nextInt();
                                playlist.displayplaylist(user_id, con);
                                System.out.println("----------------------------------");
                                System.out.println("Enter PlayList Id");
                                int playlist_id = sc.nextInt();
                                System.out.printf("%-5s%-30s%-22s%-20s%-15s%n", "ID", "SONG NAME", "ARTIST", "ALBUM", "GENRE");
                                System.out.println("=================================================================================");
                                playlist.PlaylistSongs(playlist_id, con);
                                System.out.println("\n Enter Song Id");
                                path1 = songpath.showSongPath(con);
                                Play_Song.playSong(path1);
                                System.out.println("  Enter 1)   TO GO TO MAIN MENU       \n     Enter 2) TO EXIT           ");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    continue;
                                } else if (b == 2) {
                                    break;
                                }
                                break;

                            }
                            case 7: {
                                case7();
                                System.out.println(" Enter 1)   TO GO TO MAIN MENU     \n           Enter 2) TO EXIT           ");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    continue;
                                }
                                k = 0;
                                break;
                            }
                            case 8: {
                                case8();
                                System.out.println("  Enter 1)   TO GO TO MAIN MENU    \n          Enter 2) TO EXIT           ");
                                b = sc.nextInt();
                                if (b == 1) {
                                    k = 1;
                                    continue;
                                }
                                k = 0;
                                break;
                            }
                            case 9: {
                                System.out.println("-----------------THANK-YOU---------------");
                                break;
                            }
                            default:
                                System.out.println("  =====   WRONG INPUT====   ");
                        }         //exit of inner switch
                        break;
                    }             //end of inner while
                    break;
                }                 // end of 1st case of outer switch

                case 2: {
                    System.out.println("Enter Details TO Signup");
                    System.out.println("-----------------------");
                    System.out.println("\nEnter User Name");
                    String name1 = sc.next();

                    System.out.println("Enter User Password  must contain '@' ");
                    String password1 = sc.next();

                    try {
                        boolean s = (password1.contains("@"));
                        if (s == false) {
                            throw new Password_Exception("Password Must Contain @");
                        }
                    } catch (Password_Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    System.out.println("Enter Email ");
                    String email = sc.next();
                    try {
                        boolean pass_exp = (password1.contains("@"));
                        if (pass_exp == false) {
                            throw new Email_Exception("Email  Must Contain Special Character '@'");
                        }
                    } catch (Email_Exception e) {
                        System.out.println(e.getMessage());

                    }
                    System.out.println("Enter Mobile Number");
                    long phone_Number = sc.nextLong();
                    userCheck.signUp(con, name1, password1, email, phone_Number);
                    System.out.println("PRESS 1) To  HOME PAGE  \n PRESS 0) To EXIT");
                    b = sc.nextInt();
                    if (b == 0) {
                        break;
                    }
                    option = 1;
                }
                default:
                    //System.out.println("------WRONG   INPUT CHOICE-------");
            }
        }
        if (option == 0) {
            System.out.println("-------------THANK-YOU-------------------");
        } else
        System.out.println();
    }
    }



package Implementations;

import databaseConnection.Connection;
import details.songs_list_details;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class songs_list_ImplTest {
Connection con;
    @BeforeEach
    void setUp() {
        songs_list_Impl obj=new songs_list_Impl();
        java.sql.Connection Connection = null;
        obj.AllSongInList(Connection);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void allSongInList() {
        songs_list_Impl obj = null;
        List<songs_list_details>obj1=obj.AllSongInList((java.sql.Connection) con);
        Assertions.assertEquals(6,6);
    }
}
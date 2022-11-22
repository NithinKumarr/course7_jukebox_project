package details;

public class playlist_display_details
{
    private int playlistId;
    private int userId;
    private int songId;

    public playlist_display_details(int playlistId, int userId, int songId) {
        this.playlistId = playlistId;
        this.userId = userId;
        this.songId = songId;
    }


    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "playlist_display_info{" +
                "playlistId=" + playlistId +
                ", userId=" + userId +
                ", songId=" + songId +
                '}';
    }
}

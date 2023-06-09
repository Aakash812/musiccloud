package com.example.musicloud.persistence.hsqldb;

import com.example.musicloud.objects.Playlist;
import com.example.musicloud.persistence.PlaylistPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPersistenceHSQLDB implements PlaylistPersistence {
    private final String dbPath;
    private static boolean wasCreated = false;

    /**
     * constructor
     */
    public PlaylistPersistenceHSQLDB(String dbPath) {
        this.dbPath = dbPath;
    }

    /**
     * Makes and returns connection to HSQLDB
     */
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }



    /**
     * @return list of playlists in database
     */
    @Override
    public List<Playlist> getPlaylist() {
        List<Playlist> playlists = new ArrayList<>();
        try (final Connection conn = connection();
             final Statement stmt = conn.createStatement();
             final ResultSet rs = stmt.executeQuery("SELECT * FROM playlist")) {
            while (rs.next()) {
                Playlist playlist = new Playlist(rs.getInt("playlist_id"), rs.getString("playlist_name"), rs.getString("description"));
                playlists.add(playlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playlists;
    }

    /**
     * inserts playlist into database
     */
    @Override
    public Playlist insertPlaylist(Playlist currentPlaylist) {
        try (final Connection conn = connection();
             final PreparedStatement stmt = conn.prepareStatement("INSERT INTO playlist VALUES (NULL, ?, ?)")) {
            stmt.setString(1, currentPlaylist.getPlaylistName());
            stmt.setString(2, currentPlaylist.getDescription());
            stmt.executeUpdate();
            return currentPlaylist;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return currentPlaylist;
    }

    /**
     * updates playlist in database with object passed to method
     */
    @Override
    public Playlist updatePlaylist(Playlist currentPlaylist) {
        return null;
    }

    /**
     * deletes playlist from database
     */
    @Override
    public void deletePlaylist(Playlist currentPlaylist) {
        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM playlist WHERE playlist_id = ?");
            sc.setInt(1, currentPlaylist.getId());
            sc.executeUpdate();
            sc.close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}

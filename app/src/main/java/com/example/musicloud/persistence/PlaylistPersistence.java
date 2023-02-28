package com.example.musicloud.persistence;

import com.example.musicloud.objects.Playlist;

import java.util.List;

public interface PlaylistPersistence {
    List<Playlist> getPlaylist();

    Playlist insertPlaylist (final Playlist currentPlaylist);

    Playlist updatePlaylist(final Playlist currentPlaylist);

    void deletePlaylist(final Playlist currentPlaylist);
}

package com.example.musicloud.business;

import com.example.musicloud.application.MyApp;
import com.example.musicloud.objects.Playlist;
import com.example.musicloud.objects.SP;
import com.example.musicloud.objects.Song;
import com.example.musicloud.persistence.SPPersistence;

import java.util.ArrayList;
import java.util.List;

public class AccessSP {

    /**
     * instance of SPPersistence
     */
    private SPPersistence dataAccess;

    /**
     * list of all SP elements
     */
    private List<SP> elements;

    /**
     * place holder for an instance of songPlaylist
     */
    private SP songPlaylist;

    /**
     * counter for current Song in SongPlaylist
     */
    private int currentSP;

    /**
     * counter for current Playlist in SongPlaylist
     */
    private int currentPS;

    /**
     * constructor
     */
    public AccessSP() {
        dataAccess = MyApp.getSpPersistence();
        elements = null;
        currentSP = 0;
        currentPS = 0;
    }

    /**
     * constructor
     * @param spPersistence instance of SPPersistence to access data
     */
    public AccessSP (final SPPersistence spPersistence) {
        this();
        this.dataAccess = spPersistence;
    }

    /**
     * Get instance of SP that contains desired song
     * @param songName name of desired song in SP
     * @return SP object containing song passed to method and corresponding playlist
     */
    public SP getSP (String songName){
        if (elements == null) {
            elements = dataAccess.getSP(songName);
            currentSP = 0;
        }
        if (currentSP < elements.size()){
            songPlaylist = elements.get(currentSP);
            currentSP++;
        } else {
            elements = null;
            songPlaylist = null;
            currentSP = 0;
        }
        return songPlaylist;
    }

    /**
     * Get instance of SP that contains desired playlist
     * @param playlistName name of desired playlist in SP
     * @return SP object containing playlist passed to method and corresponding song
     */
    public SP getPS(String playlistName){
        if (elements == null){
            elements = dataAccess.getPS(playlistName);
            currentPS = 0;
        }
        if (currentPS < elements.size()){
            songPlaylist = elements.get(currentPS);
            currentPS++;
        } else {
            elements = null;
            songPlaylist = null;
            currentPS = 0;
        }
        return songPlaylist;
    }

    /**
     * returns a list of all the songs of a given playlist
     * @param playlistName name of the playlist
     * @return a list of Song objects
     */
    public List<Song> allSongs(String playlistName){
        if (elements == null){
            elements = dataAccess.getPS(playlistName);
        }

        List<Song> songs = new ArrayList<Song>();
        for(int i=0; i<elements.size();i++){
            songs.add(elements.get(i).getSong());
        }

        return songs;
    }

    /**
     * removes all the data of a given playlist
     * @param current playlist objects
     */
    public void removeData(Playlist current){
       dataAccess.deletePairs(current);
    }


    public void insertData(int pId, String playlistName, int sId, String songName){
        dataAccess.insertPairs(pId, playlistName, sId, songName);}
}

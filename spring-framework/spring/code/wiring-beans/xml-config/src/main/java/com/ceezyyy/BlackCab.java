package com.ceezyyy;

import java.util.List;

public class BlackCab implements CompactDisc {

    private String album;
    private String artist;
    private List<String> tracks;

    public BlackCab() {
    }

    public BlackCab(String album, String artist, List<String> tracks) {
        this.album = album;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + album + " by " + artist);
        tracks.forEach(System.out::println);
    }

}

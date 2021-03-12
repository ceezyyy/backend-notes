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

    public void play() {
        tracks.forEach(System.out::println);
    }

    public void playTrack(int index) {
        System.out.println(tracks.get(index));
    }

    @Override
    public int numOfTracks() {
        return tracks.size();
    }

}

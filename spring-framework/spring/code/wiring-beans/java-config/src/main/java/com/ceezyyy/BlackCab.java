package com.ceezyyy;

public class BlackCab implements CompactDisc {

    private String album = "Black Cab";
    private String artist = "Higher Brothers";

    public void play() {
        System.out.println("Playing " + album + " by " + artist);
    }
}

package com.ceezyyy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc disc;

    @Autowired
    public CDPlayer(CompactDisc disc) {
        this.disc = disc;
    }

    public void play() {
        disc.play();
    }

    @Override
    public void playTrack(int index) {
        disc.playTrack(index);
    }

    @Override
    public int numOfTracks() {
        return disc.numOfTracks();
    }

}

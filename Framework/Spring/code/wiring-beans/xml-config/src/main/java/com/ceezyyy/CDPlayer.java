package com.ceezyyy;

public class CDPlayer implements MediaPlayer {

    private CompactDisc CD;

    public CDPlayer(CompactDisc CD) {
        this.CD = CD;
    }

    public void setCD(CompactDisc CD) {
        this.CD = CD;
    }

    public void play() {
        CD.play();
    }

}

package com.ceezyyy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.ceezyyy.CDPlayerConfig.class)
public class TestAdviceArgs {

    @Autowired
    private MediaPlayer player;
    @Autowired
    private TrackCounter counter;

    @Test
    public void testBlackCab() {
        player.play();
    }

    @Test
    public void testTrackCounter() {

        player.playTrack(0);
        player.playTrack(0);
        player.playTrack(1);
        player.playTrack(2);

        for (int i = 0; i < player.numOfTracks(); i++) {
            System.out.println(counter.getCount(i));
        }

    }

}

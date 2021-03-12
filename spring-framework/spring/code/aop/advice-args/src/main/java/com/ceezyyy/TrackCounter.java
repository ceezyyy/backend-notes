package com.ceezyyy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class TrackCounter {

    private Map<Integer, Integer> map = new HashMap<>();

    @Pointcut(value = "execution(* com.ceezyyy.MediaPlayer.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }

    @Before("trackPlayed(trackNumber)")
    public void update(int trackNumber) {
        int currentCount = getCount(trackNumber);
        map.put(trackNumber, currentCount + 1);
    }

    public int getCount(int trackNumber) {
        return map.containsKey(trackNumber) ? map.get(trackNumber) : 0;
    }

}

package com.ceezyyy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class CDPlayerConfig {

    @Bean
    public CompactDisc disc() {
        List<String> tracks = new ArrayList<>();
        tracks.add("711");
        tracks.add("Mine");
        tracks.add("Wudidong");
        tracks.add("Yahh");
        return new BlackCab("Black Cab", "Higher Brothers", tracks);
    }

}

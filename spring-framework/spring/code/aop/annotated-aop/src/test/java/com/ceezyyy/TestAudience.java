package com.ceezyyy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.ceezyyy.AopConfig.class)
public class TestAudience {

    @Autowired
    private Performance live;

    @Test
    public void testLiveShouldBePlayed() {
        live.perform();
    }

}

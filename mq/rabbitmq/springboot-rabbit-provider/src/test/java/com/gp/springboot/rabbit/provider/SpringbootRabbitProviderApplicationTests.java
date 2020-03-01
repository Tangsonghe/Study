package com.gp.springboot.rabbit.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitProviderApplicationTests {

    @Autowired
    RabbitSend rabbitSend;

    @Test
    public void contextLoads() {
        rabbitSend.send();
    }

}

package com.rabbit.consumer.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: liuhao
 * @Date: 2018/12/25 09:53
 * @Description:
 */
@Component
public class Consumer {

    @RabbitListener(queues = {"queue1","queue3"})
    public void receive(String message) {
        System.out.println(message);
    }
}

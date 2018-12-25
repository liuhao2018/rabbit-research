package com.rabbit.producer.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: liuhao
 * @Date: 2018/12/25 09:47
 * @Description:
 */
@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void basic() {
        rabbitTemplate.convertAndSend("queue1","hello world");
    }


    public void ps() {
        rabbitTemplate.convertAndSend("amq.fanout","","发布订阅模式生成的数据");
    }

    public void routing(String routingKey) {
        if ("sms".equals(routingKey)) {
            rabbitTemplate.convertAndSend("amq.direct",routingKey,"发送到短信服务");
        }else if("email".equals(routingKey)) {
            rabbitTemplate.convertAndSend("amq.direct",routingKey,"发送到邮件服务");
        }else {
            rabbitTemplate.convertAndSend("amq.direct","common","发送公共消息");
        }
    }
}

package com.rabbit.producer.controller;

import com.rabbit.producer.component.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: liuhao
 * @Date: 2018/12/25 09:50
 * @Description:
 */
@RestController
@RequestMapping
public class SendController {

    @Autowired
    Producer producer;

    @GetMapping("/basic")
    public String basic() {
        producer.basic();
        return "ok";
    }

    @GetMapping("/ps")
    public String ps() {
        producer.ps();
        return "ok";
    }

    @GetMapping("/routing/{key}")
    public String routing(@PathVariable String key) {
        producer.routing(key);
        return "ok";
    }

}

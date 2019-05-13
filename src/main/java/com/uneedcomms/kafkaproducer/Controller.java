package com.uneedcomms.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        System.out.println("test param="+what);
        this.kafkaTemplate.send("topic1", new Foo1(what));
        System.out.println("after send");
    }
}

package com.onlineshopping.onlineshoppingproject.controller;

import com.onlineshopping.onlineshoppingproject.model.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/publish")
    public void jsonPublish(@RequestBody Json json){
        kafkaTemplate.send("test1", json.getFname()+" "+json.getFname()+" "+ json.getAge());
    }
}

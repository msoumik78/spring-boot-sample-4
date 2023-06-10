package org.demo.controller;

import lombok.RequiredArgsConstructor;
import org.demo.services.KafkaProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/kafka-controllers")
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    @PostMapping(produces = {"application/json"})
    public void createCustomer() {
        kafkaProducer.send("NewTopic", "Test message 1");
    }
}

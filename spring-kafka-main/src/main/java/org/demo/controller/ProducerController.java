package org.demo.controller;

import org.demo.event.UserProfileChangeEvent;
import org.demo.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/kafka")
public class ProducerController {
    private final KafkaProducerService kafkaProducer;
    private final String topicName;

    public ProducerController(KafkaProducerService kafkaProducer, @Value("${topic.name}") String topicName) {
        this.kafkaProducer = kafkaProducer;
        this.topicName = topicName;
    }

    @PostMapping(produces = {"application/json"})
    public void postMessage(@RequestBody UserProfileChangeEvent userProfileChangeEvent) {
        kafkaProducer.send(topicName, userProfileChangeEvent);
    }
}

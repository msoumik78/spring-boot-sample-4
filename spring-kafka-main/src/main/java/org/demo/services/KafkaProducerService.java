package org.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.demo.event.UserProfileChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, UserProfileChangeEvent> kafkaTemplate;

    public void send(String topic, UserProfileChangeEvent payload) {
        kafkaTemplate.send(topic, payload);
        log.info("Payload posted to topic : {}", topic);
    }
}

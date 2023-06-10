package org.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "${topic.name}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("received payload={}", consumerRecord.value());
    }

}

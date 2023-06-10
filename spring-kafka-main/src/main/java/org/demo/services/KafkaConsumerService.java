package org.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.demo.event.UserProfileChangeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "${topic.name}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
         UserProfileChangeEvent userProfileChangeEvent = (UserProfileChangeEvent) consumerRecord.value();
         log.info("Event received type = {}, actual event = {}",
                 userProfileChangeEvent.getEventType(), userProfileChangeEvent.getEventDescription());
    }

}

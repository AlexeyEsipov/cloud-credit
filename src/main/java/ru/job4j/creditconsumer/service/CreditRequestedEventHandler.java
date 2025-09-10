package ru.job4j.creditconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.job4j.core.events.DepositRequestedEvent;

@Component
@KafkaListener(topics = "credit-money-topic", containerFactory = "kafkaListenerContainerFactory")
public class CreditRequestedEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handle(@Payload DepositRequestedEvent depositRequestedEvent) {
        LOGGER.info("Received a new deposit event: {} ", depositRequestedEvent.getAmount());
    }
}

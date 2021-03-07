package com.easys.kafka.entrypoint.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

	@SuppressWarnings("rawtypes")
	@KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(final ConsumerRecord consumerRecord) {
		LOGGER.info("Mensagem: " + consumerRecord.value());
		LOGGER.info("Particao: " + consumerRecord.partition());
		LOGGER.info("Data: " + consumerRecord.timestamp());
		LOGGER.info("Topico: " + consumerRecord.topic());
	}
}

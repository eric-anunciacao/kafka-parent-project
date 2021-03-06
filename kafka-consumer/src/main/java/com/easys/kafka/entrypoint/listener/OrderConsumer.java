package com.easys.kafka.entrypoint.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

	@KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(String order) {
		LOGGER.info(order);
	}
}

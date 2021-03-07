package com.easys.kafka.usecase.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.easys.kafka.usecase.OrderProducerUseCase;

@Component
public class OrderProducerUseCaseImpl implements OrderProducerUseCase {

	@Value("${order.topic}")
	private String orderTopic;

	@SuppressWarnings("rawtypes")
	private final KafkaTemplate kafkaTemplate;

	@SuppressWarnings("rawtypes")
	public OrderProducerUseCaseImpl(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void send(final @RequestBody String order) {
		final var mesageKey = UUID.randomUUID().toString();
		kafkaTemplate.send(orderTopic, mesageKey, order);
	}

}

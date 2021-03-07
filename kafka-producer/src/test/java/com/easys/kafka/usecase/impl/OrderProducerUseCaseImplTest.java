package com.easys.kafka.usecase.impl;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class OrderProducerUseCaseImplTest {

	@InjectMocks
	private OrderProducerUseCaseImpl useCase;

	@Mock
	@SuppressWarnings("rawtypes")
	private KafkaTemplate kafkaTemplate;

	@SuppressWarnings("unchecked")
	@Test
	void shouldSendOrder() {
		ReflectionTestUtils.setField(useCase, "orderTopic", "ordertopic");
		useCase.send("Any message");
		BDDMockito.verify(kafkaTemplate, times(1)).send(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
	}

}

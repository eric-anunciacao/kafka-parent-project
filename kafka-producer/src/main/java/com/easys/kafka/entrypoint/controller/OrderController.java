package com.easys.kafka.entrypoint.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easys.kafka.usecase.OrderProducerUseCase;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderProducerUseCase orderProducerUseCase;

	public OrderController(OrderProducerUseCase orderProducerUseCase) {
		this.orderProducerUseCase = orderProducerUseCase;
	}

	@PostMapping
	public void send(@RequestBody String order) {
		this.orderProducerUseCase.send(order);
	}

}

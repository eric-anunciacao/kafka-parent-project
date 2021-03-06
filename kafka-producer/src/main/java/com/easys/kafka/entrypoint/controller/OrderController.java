package com.easys.kafka.entrypoint.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easys.kafka.producer.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderProducer orderProducer;

	public OrderController(OrderProducer orderProducer) {
		this.orderProducer = orderProducer;
	}

	@PostMapping
	public void send(@RequestBody String order) {
		this.orderProducer.send(order);
	}

}

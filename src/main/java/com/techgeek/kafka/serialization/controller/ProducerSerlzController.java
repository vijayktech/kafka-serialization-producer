package com.techgeek.kafka.serialization.controller;


import com.techgeek.kafka.serialization.dto.Customer;
import com.techgeek.kafka.serialization.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-srlz")
public class ProducerSerlzController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @PostMapping("/customer")
    public void producerCustomers(@RequestBody Customer cust) {
        publisher.sendCustomerTopic(cust);
    }
}

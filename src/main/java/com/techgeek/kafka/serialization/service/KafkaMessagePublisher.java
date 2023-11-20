package com.techgeek.kafka.serialization.service;

import com.techgeek.kafka.serialization.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendCustomerTopic(Customer customer) {
        CompletableFuture<SendResult<String, Object>> send = template.send("techgeek-topic2", customer);
        send.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + customer.toString() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        customer.toString() + "] due to : " + ex.getMessage());
            }
        });
    }

}

package com.example.PatientDemo.Service;

import com.example.PatientDemo.Entities.PatientDetailsEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "patient-topic", groupId = "patient-group")
    public void consume(PatientDetailsEntity patient) {
        System.out.println("🩺 Received from Kafka: " + patient);
    }
}

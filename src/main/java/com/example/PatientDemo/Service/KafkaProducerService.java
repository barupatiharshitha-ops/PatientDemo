package com.example.PatientDemo.Service;


import com.example.PatientDemo.Entities.PatientDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "patient-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPatientData(PatientDetailsEntity patient) {
        kafkaTemplate.send(TOPIC, patient);
        System.out.println("✅ Sent to Kafka: " + patient);
    }
}



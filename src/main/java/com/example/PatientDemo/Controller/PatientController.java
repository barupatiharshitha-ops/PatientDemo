package com.example.PatientDemo.Controller;


import com.example.PatientDemo.Repository.PatientRepository;
import com.example.PatientDemo.Entities.PatientDetailsEntity;
import com.example.PatientDemo.Service.KafkaConsumerService;
import com.example.PatientDemo.Service.KafkaProducerService;
import com.example.PatientDemo.models.PatientDetailResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    private final KafkaProducerService kafkaProducerService;


    // Constructor-based injection (recommended)
    public PatientController(PatientRepository patientRepository,
                             KafkaProducerService kafkaProducerService,KafkaConsumerService kafkaConsumerService) {
        this.patientRepository = patientRepository;
        this.kafkaProducerService = kafkaProducerService;
    }


    @GetMapping("/getdata")
    public List<PatientDetailResponseDTO> getAllPatients() {
        List<PatientDetailsEntity> entities = patientRepository.findAll();
        List<PatientDetailResponseDTO> dtoList = new ArrayList<>();

        for (PatientDetailsEntity p : entities) {
            dtoList.add(new PatientDetailResponseDTO(
                    p.getId(),
                    p.getName(),
                    p.getAge(),
                    p.getDisease()
            ));
        }

        return dtoList;  // Now dtoList contains actual data
    }


    @GetMapping("/byid/{id}")
    public List<PatientDetailResponseDTO> getPatientById(@PathVariable Long id) {
        List<PatientDetailsEntity> entities = patientRepository.getPatientDetailsById(id);
        List<PatientDetailResponseDTO> dtoList = new ArrayList<>();

        for (PatientDetailsEntity p : entities) {
            dtoList.add(new PatientDetailResponseDTO(
                    p.getId(),
                    p.getName(),
                    p.getAge(),
                    p.getDisease()
            ));
        }

        return dtoList;
    }



    @GetMapping("/name/{name}")
    public List<PatientDetailResponseDTO> getPatientByName(@PathVariable String name){
        List<PatientDetailsEntity> en = patientRepository.getPatientByName(name);
        List<PatientDetailResponseDTO> d = new ArrayList<>();

        for(PatientDetailsEntity p: en){
            d.add( new PatientDetailResponseDTO(
                    p.getId(),
                    p.getName(),
                    p.getAge(),
                    p.getDisease()
            ));
        }
        return d;

    }

//
//    @PostMapping("/postdata")
//    public PatientDetailsEntity createPatient(@RequestBody PatientDetailsEntity patient) {
//        return patientRepository.save(patient);
//    }
//
//


    @PostMapping("/postdata")
    public PatientDetailsEntity createPatient(@RequestBody PatientDetailsEntity patient) {
        PatientDetailsEntity savedPatient = patientRepository.save(patient);
        kafkaProducerService.sendPatientData(savedPatient);  // will work now
        return savedPatient;
    }










}







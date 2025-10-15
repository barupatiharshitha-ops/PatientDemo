package com.example.PatientDemo.models;

public class PatientDetailResponseDTO {

    private Long id;
    private String name;
    private int age;
    private String disease;

    // Constructor
    public PatientDetailResponseDTO(Long id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }
}



//DTO -> entity -> response mapping

// Data layer -> service - > controller
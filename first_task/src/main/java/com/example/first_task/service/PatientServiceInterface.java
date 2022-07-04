package com.example.first_task.service;

import com.example.first_task.entity.Patient;

import java.util.List;

public interface PatientServiceInterface {

    Patient save(Patient patient);
    void delete(Long id);
    Patient update(Long id, Patient patient);
    List<Patient> findAll();

    Patient findById(Long id);

}

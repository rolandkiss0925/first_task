package com.example.first_task.service;

import com.example.first_task.entity.Patient;
import com.example.first_task.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements PatientServiceInterface {

    @Autowired
    private PatientRepository repository;

    @Override
    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Patient update(Long id, Patient patient) {
        Optional<Patient> patientOptional = repository.findById(id);
        if (patientOptional.isPresent()) {
            patient.setId(id);
            repository.save(patient);
        }
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) repository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}



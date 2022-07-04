package com.example.first_task.service;

import com.example.first_task.entity.Patient;
import com.example.first_task.entity.ServicePoint;
import com.example.first_task.repository.PatientRepository;
import com.example.first_task.repository.ServicePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePointService implements ServicePointServiceInterface{

    @Autowired
    private ServicePointRepository repository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public ServicePoint saveServicePoint(ServicePoint servicePoint) {
        return repository.save(servicePoint);
    }

    @Override
    public ServicePoint getServicePoint(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteServicePoint(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ServicePoint updateServicePoint(Long id, ServicePoint servicePoint) {
        Optional<ServicePoint> servicePointOptional = repository.findById(id);
        if (servicePointOptional.isPresent()) {
            servicePoint.setId(id);
            repository.save(servicePoint);
        }
        return servicePoint;
    }

    @Override
    public List<ServicePoint> findAllServicePoint() {
        return (List<ServicePoint>) repository.findAll();
    }

    @Override
    public void addPatientToServicePoint(Long servicePointId, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        ServicePoint servicePoint = repository.findById(servicePointId).orElse(null);
        if (servicePoint != null && patient != null) {
            servicePoint.getPatients().add(patient);
            repository.save(servicePoint);
        }
    }

    @Override
    public void removePatientToServicePoint(Long servicePointId, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        ServicePoint servicePoint = repository.findById(servicePointId).orElse(null);
        if (servicePoint != null && patient != null) {
            servicePoint.getPatients().remove(patient);
            repository.save(servicePoint);
        }
    }
}

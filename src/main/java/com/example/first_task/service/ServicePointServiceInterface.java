package com.example.first_task.service;

import com.example.first_task.entity.ServicePoint;

import java.util.List;

public interface ServicePointServiceInterface {

    ServicePoint saveServicePoint(ServicePoint servicePoint);
    ServicePoint getServicePoint(Long id);
    void deleteServicePoint(Long id);
    ServicePoint updateServicePoint(Long id, ServicePoint servicePoint);
    List<ServicePoint> findAllServicePoint();
    void addPatientToServicePoint(Long servicePointId, Long patientId);
    void removePatientToServicePoint(Long servicePointId, Long patientId);
}

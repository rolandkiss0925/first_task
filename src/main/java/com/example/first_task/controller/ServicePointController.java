package com.example.first_task.controller;

import com.example.first_task.entity.ServicePoint;
import com.example.first_task.service.ServicePointServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/service_point")
public class ServicePointController {

    @Autowired
    private ServicePointServiceInterface service;

    @PutMapping("{id}/patient/{patient_id}")
    public void addPatientToServicePoint(@PathVariable("id") Long id, @PathVariable("patient_id") Long patient_id) {
        service.addPatientToServicePoint(id, patient_id);
    }

    @DeleteMapping("{id}/patient/{patient_id}")
    public void removePatientFromServicePoint(@PathVariable("id") Long id, @PathVariable("patient_id") Long patient_id) {
        service.removePatientFromServicePoint(id, patient_id);
    }

    @GetMapping
    public List<ServicePoint> findAll() {
        return service.findAllServicePoint();
    }

    @GetMapping("/{id}")
    public ServicePoint findById(@PathVariable("id") Long id) {
        return service.getServicePoint(id);
    }

    @PostMapping("/{id}")
    public ServicePoint update(@PathVariable("id") Long id, @RequestBody ServicePoint servicePoint) {
        return service.updateServicePoint(id, servicePoint);
    }

    @PostMapping
    public ServicePoint save(@RequestBody ServicePoint servicePoint) {
        return service.saveServicePoint(servicePoint);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteServicePoint(id);
    }
}

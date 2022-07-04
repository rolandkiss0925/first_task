package com.example.first_task.dto.controller;

import com.example.first_task.entity.Patient;
import com.example.first_task.service.PatientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {

    @Autowired
    private PatientServiceInterface service;

    @GetMapping
    public List<Patient> findAll() {
        return service.findAll();
    }

    @PostMapping("/{id}")
    public Patient update(@PathVariable("id") Long id, @RequestBody Patient patient) {
        return service.update(id, patient);
    }

    @PostMapping
    public void save(@RequestBody Patient patient) {
        service.save(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
package com.example.first_task.controller;

import com.example.first_task.dto.CalendarDTO;
import com.example.first_task.dto.CalendarPeriodQueryDTO;
import com.example.first_task.entity.Calendar;
import com.example.first_task.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/calendar")
public class CalendarController {

    @Autowired
    private CalendarServiceInterface service;

    @Autowired
    private PatientServiceInterface patientService;

    @Autowired
    private ServicePointServiceInterface servicePointService;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @PostMapping
    public Calendar save(@RequestBody CalendarDTO calendar) {
        Calendar entity = new Calendar();
        entity.setStatus(calendar.getStatus().map());
        entity.setFromDate(calendar.getFrom());
        entity.setToDate(calendar.getTo());
        entity.setPatient(patientService.findById(calendar.getPatientId()));
        entity.setServicePoint(servicePointService.getServicePoint(calendar.getServicePointId()));
        entity.setCreatorUser(userServiceInterface.getUser(calendar.getCreatorUserId()));

        service.save(entity);
        return entity;
    }

    @GetMapping(path = "/service_point_id/{id}")
    public List<Calendar> getAllByServicePoint(@PathVariable("id") Long servicePointId) {
        return service.findAllByServicePoint(servicePointId);
    }

    @GetMapping(path = "/patient_id/{id}")
    public List<Calendar> getAllByPatientId(@PathVariable("id") Long patientId) {
        return service.findAllByPatient(patientId);
    }

    @GetMapping(path = "/creator_user_id/{id}")
    public List<Calendar> getAllByCreatorUser(@PathVariable("id") Long creatorUserId) {
        return service.findAllByCreatorUser(creatorUserId);
    }

    @PostMapping(path = "/period")
    public List<Calendar> getAllInPeriod(@RequestBody CalendarPeriodQueryDTO queryDTO) {
        return service.findAllInPeriod(queryDTO.getFrom(), queryDTO.getTo());
    }

    @PostMapping (path = "/{id}/status/{status}")
    public void modifyStatus(@PathVariable("id") Long calendarId, @PathVariable("status") String status) {
        CalendarDTO.Status calendarStatus = CalendarDTO.Status.valueOf(status);
        service.updateStatus(calendarId, calendarStatus.map());
    }
}

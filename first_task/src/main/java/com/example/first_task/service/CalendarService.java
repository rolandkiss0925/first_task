package com.example.first_task.service;

import com.example.first_task.entity.Calendar;
import com.example.first_task.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CalendarService implements CalendarServiceInterface {

    @Autowired
    private CalendarRepository repository;

    @Override
    public Calendar save(Calendar calendar) {
        repository.save(calendar);
        return calendar;
    }

    @Override
    public List<Calendar> findAllByServicePoint(Long servicePointId) {
        return (List<Calendar>) repository.findAllByServicePoint(servicePointId);
    }

    @Override
    public List<Calendar> findAllByPatient(Long patientId) {
        return (List<Calendar>) repository.findAllByPatient(patientId);
    }

    @Override
    public List<Calendar> findAllByCreatorUser(Long userId) {
        return (List<Calendar>) repository.findAllByCreatorUser(userId);
    }

    @Override
    public List<Calendar> findAllInPeriod(Date from, Date to) {
        return (List<Calendar>) repository.findAllInPeriod(from, to);
    }

    @Override
    public void updateStatus(Long calendarId, Calendar.Status status) {
        Calendar calendar = repository.findById(calendarId).orElse(null);
        if (calendar != null) {
            calendar.setStatus(status);
            repository.save(calendar);
        }
    }
}

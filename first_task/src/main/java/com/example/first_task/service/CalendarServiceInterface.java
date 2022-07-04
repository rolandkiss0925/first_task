package com.example.first_task.service;

import com.example.first_task.entity.Calendar;

import java.util.Date;
import java.util.List;

public interface CalendarServiceInterface {
    Calendar save(Calendar calendar);
    List<Calendar> findAllByServicePoint(Long servicePointId);
    List<Calendar> findAllByPatient(Long patientId);
    List<Calendar> findAllByCreatorUser(Long userId);
    List<Calendar> findAllInPeriod(Date from, Date to);
    void updateStatus(Long calendarId, Calendar.Status status);
}

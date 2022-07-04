package com.example.first_task.repository;

import com.example.first_task.entity.Calendar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {

    @Query("SELECT c FROM Calendar c WHERE c.servicePoint.id = ?1")
    Iterable<Calendar> findAllByServicePoint(Long servicePointId);

    @Query("SELECT c FROM Calendar c WHERE c.patient.id = ?1")
    Iterable<Calendar> findAllByPatient(Long patientId);

    @Query("SELECT c FROM Calendar c WHERE c.creatorUser.id = ?1")
    Iterable<Calendar> findAllByCreatorUser(Long userId);

    @Query("SELECT c FROM Calendar c WHERE c.fromDate > ?1 AND c.toDate < ?2")
    Iterable<Calendar> findAllInPeriod(Date from, Date to);
}

package com.example.first_task.repository;

import com.example.first_task.entity.ServicePoint;
import org.springframework.data.repository.CrudRepository;

public interface ServicePointRepository extends CrudRepository<ServicePoint, Long> {
}

package com.example.first_task.service;

import com.example.first_task.entity.ServicePoint;
import com.example.first_task.entity.User;

import java.util.List;

public interface UserServiceInterface {

    User getUser(String username);
    User getUser(Long id);
    User registerUser(User user);
    void deactivateUser(Long id);
    List<User> findAllUser();
    User updateUser(Long id, User user);
    void addServicePointToUser(String username, Long servicePointId);
    void removeServicePointFromUser(String username, Long servicePointId);
}

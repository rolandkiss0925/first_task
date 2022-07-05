package com.example.first_task.service;

import com.example.first_task.entity.ServicePoint;
import com.example.first_task.entity.User;
import com.example.first_task.repository.ServicePointRepository;
import com.example.first_task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ServicePointRepository servicePointRepository;

    @Override
    public User getUser(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User registerUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deactivateUser(Long id) {
        User user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setIsActive(false);
            repository.save(user);
        }
    }

    @Override
    public List<User> findAllUser() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            user.setId(id);
            repository.save(user);
        }
        return user;
    }

    @Override
    public void addServicePointToUser(String username, Long servicePointId) {
        ServicePoint servicePoint = servicePointRepository.findById(servicePointId).orElse(null);
        if (servicePoint != null) {
            User user = repository.findByUsername(username);
            user.getServicePoints().add(servicePoint);
            repository.save(user);
        }
    }

    @Override
    public void removeServicePointFromUser(String username, Long servicePointId) {
        ServicePoint servicePoint = servicePointRepository.findById(servicePointId).orElse(null);
        if (servicePoint != null) {
            User user = repository.findByUsername(username);
            user.getServicePoints().remove(servicePoint);
            repository.save(user);
        }
    }
}

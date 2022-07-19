package com.example.first_task.controller;

import com.example.first_task.entity.User;
import com.example.first_task.model.FirstTaskUserDetails;
import com.example.first_task.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @GetMapping("/me")
    public User me(Principal principal) {
        return userService.getUser(((FirstTaskUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername());
    }

    @PutMapping("/service_point/{id}")
    public void addServicePointToUser(@PathVariable("id") Long id, Principal principal) { // Az eppen belepett User adatait tartalmazza a principal
        userService.addServicePointToUser(((FirstTaskUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername(), id);
    }

    @DeleteMapping("/service_point/{id}")
    public void removeServicePointFromUser(@PathVariable("id") Long id, Principal principal) {
        userService.removeServicePointFromUser(((FirstTaskUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername(), id);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deactivateUser(id);
    }
}
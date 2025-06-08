package com.example.thesisbe.controller;

import com.example.thesisbe.entity.UserProfile;
import com.example.thesisbe.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserProfileRepository repository;

    @GetMapping
    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile user) {
        return repository.save(user);
    }

    @GetMapping("/{id}")
    public UserProfile getUser(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public UserProfile updateUser(@PathVariable Long id, @RequestBody UserProfile user) {
        user.setId(id);
        return repository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

package com.example.eduwheels.Controller; // ✅ Fixed package name (lowercase)

import com.example.eduwheels.Entity.UserEntity; // ✅ Fixed import (lowercase)
import com.example.eduwheels.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
class UserController {

    @Autowired
    private UserService userService;  // Fixed casing for 'userService'000

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    private UserService UserService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return UserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
        return UserService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/signup")  // Modified to /signup endpoint
    public ResponseEntity<UserEntity> signUp(@RequestBody UserEntity user) {
        try {
            // Check if user already exists
            if (userService.userExists(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);  // Return bad request if email exists
            }

            // Create the user
            UserEntity createdUser = userService.createUser(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);  // Return an error response if any issues
        }
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
      
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return UserService.createUser(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
        UserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

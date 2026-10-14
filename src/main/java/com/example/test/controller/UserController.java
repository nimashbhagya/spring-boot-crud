package com.example.test.controller;

import com.example.test.dto.UserDTO;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public List<UserDTO> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/getuser/{userId}")
    public UserDTO getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/adduser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {

        return userService.saveUser(userDTO); // Placeholder return statement
    }
    @PutMapping ("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO); // Placeholder return statement
    }

    @DeleteMapping("/deleteuser/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId); // Placeholder return statement
    }


}

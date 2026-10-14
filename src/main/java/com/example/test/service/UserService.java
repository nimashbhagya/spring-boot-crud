package com.example.test.service;

import com.example.test.dto.UserDTO;
import com.example.test.model.User;
import com.example.test.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {}.getType());
    }

    public UserDTO getUserById(Integer userId) {
        User user = userRepo.findById(userId).orElse(null);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO saveUser(UserDTO userDTO) {

        User user = modelMapper.map(userDTO, User.class);

        User savedUser = userRepo.save(user);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User updatedUser = userRepo.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    public String deleteUser(Integer userId) {
        userRepo.deleteById(userId);
        return "User deleted successfully";
    }
}

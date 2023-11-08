package com.projectems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.UserConverter;
import com.projectems.dao.UserRepository;
import com.projectems.dto.UserDTO;
import com.projectems.entities.User;
import com.projectems.exceptions.UserNotFoundException;
import com.projectems.service.UserService;

import java.util.List; 

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findUserById(id);
        if (user == null) { // Corrected null check
            throw new UserNotFoundException("User not found with id: " + id);
        }
        return userConverter.userToUserDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userConverter.userDTOToUser(userDTO);
        user = userRepository.save(user);
        return userConverter.userToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findUserById(id);
        if (existingUser == null) { // Corrected null check
            throw new UserNotFoundException("User not found with id: " + id);
        }

        // Update user fields from userDTO
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setRole(userDTO.getRole());

        User updatedUser = userRepository.save(existingUser);
        return userConverter.userToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findUserById(id);
        if (user == null) { // Corrected null check
            throw new UserNotFoundException("User not found with id: " + id);
        }
        userRepository.delete(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userConverter.usersToUserDTOs(users);
    }
}

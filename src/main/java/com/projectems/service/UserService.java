package com.projectems.service;

import java.util.List;

import com.projectems.dto.UserDTO;

public interface UserService {

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> getAllUsers();
}

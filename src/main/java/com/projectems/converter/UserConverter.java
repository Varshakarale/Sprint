package com.projectems.converter;

import org.springframework.stereotype.Component;

import com.projectems.dto.UserDTO;
import com.projectems.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        return users.stream()
                .map(this::userToUserDTO)
                .collect(Collectors.toList());
    }
}

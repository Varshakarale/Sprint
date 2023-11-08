package com.projectems.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.UserRepository;
import com.projectems.dto.UserDTO;
import com.projectems.entities.User;
import com.projectems.service.impl.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetUserById() {
        // Create a sample User
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");
      //  user.setEmail("test@example.com");

        when(userRepository.findUserById(1L)).thenReturn(user);

        UserDTO userDTO = userService.getUserById(1L);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getUsername(), userDTO.getUsername());
       // assertEquals(user.getEmail(), userDTO.getEmail());
    }

    @Test
    public void testCreateUser() {
        // Create a sample UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("newUser");
        //userDTO.setEmail("new@example.com");

        // Create a sample User entity
        User user = new User();
        user.setUsername(userDTO.getUsername());
        //user.setEmail(userDTO.getEmail());

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO createdUser = userService.createUser(userDTO);

        assertEquals(userDTO.getUsername(), createdUser.getUsername());
       // assertEquals(userDTO.getEmail(), createdUser.getEmail());
    }

    @Test
    public void testUpdateUser() {
        // Create a sample UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUsername("updatedUser");
       // userDTO.setEmail("updated@example.com");

        // Create a sample User entity
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
       // user.setEmail(userDTO.getEmail());

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO updatedUser = userService.updateUser(1L, userDTO);

        assertEquals(userDTO.getId(), updatedUser.getId());
        assertEquals(userDTO.getUsername(), updatedUser.getUsername());
       // assertEquals(userDTO.getEmail(), updatedUser.getEmail());
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser(1L);

        verify(userRepository).delete(any(User.class));
    }
}

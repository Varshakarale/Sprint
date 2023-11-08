package com.projectems.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projectems.controller.UserController;
import com.projectems.dto.UserDTO;
import com.projectems.service.UserService;

@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void testGetUserById() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUsername("testUser");
       // userDTO.setEmail("test@example.com");

        when(userService.getUserById(1L)).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.getUserById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDTO, response.getBody());
    }

    @Test
    public void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("newUser");
       // userDTO.setEmail("new@example.com");

        when(userService.createUser(userDTO)).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.createUser(userDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userDTO, response.getBody());
    }

    @Test
    public void testUpdateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUsername("updatedUser");
       // userDTO.setEmail("updated@example.com");

        when(userService.updateUser(1L, userDTO)).thenReturn(userDTO);

      
        //Call the controller method to update the user
        ResponseEntity<UserDTO> response1 = userController.updateUser(1L, userDTO);

        // Check if the response status is OK (200)
        assertEquals(HttpStatus.OK, response1.getStatusCode());

        // Check if the returned UserDTO matches the expected data
        UserDTO updatedUser = response1.getBody();
        assertNotNull(updatedUser);
        assertEquals(userDTO.getId(), updatedUser.getId());
        assertEquals(userDTO.getUsername(), updatedUser.getUsername());
       // assertEquals(userDTO.getEmail(), updatedUser.getEmail());
    }
}
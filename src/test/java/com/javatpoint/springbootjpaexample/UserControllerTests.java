package com.javatpoint.springbootjpaexample;

import com.javatpoint.controller.*;
import com.javatpoint.model.User;
import com.javatpoint.repository.UserRepository;
import com.javatpoint.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void getAllUsersShouldReturnOk() throws Exception {
    	
        User user1=   new User();
        user1.setId(1L);
        user1.setUname("vashu");
    	List<User> mockUsers = new ArrayList<User>();
    			mockUsers.add(user1);
    			
        
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1));

        mockMvc.perform(get("/users"))
               .andExpect(status().isOk());
    }

//    @Test
//    void getUserByIdShouldReturnOk() throws Exception {
//        long userId = 1L;
//        when(userService.getUserById(userId)).thenReturn(Optional.of(null/* Mock a user here */));
//
//        mockMvc.perform(get("/users/{userId}", userId))
//               .andExpect(status().isOk());
//    }

//    @Test
//    void createUserShouldReturnCreated() throws Exception {
//        UserDTO userDTO = new UserDTO(/* Provide necessary user data */);
//        when(userService.createUser(any())).thenReturn(/* Mock the created user here */);
//
//        mockMvc.perform(post("/users")
//               .contentType(MediaType.APPLICATION_JSON)
//               .content(objectMapper.writeValueAsString(userDTO)))
//               .andExpect(status().isCreated());
//    }

//    @Test
//    void updateUserShouldReturnOk() throws Exception {
//        long userId = 1L;
//        UserDTO updatedUserDTO = new UserDTO(/* Provide updated user data */);
//        when(userService.updateUser(eq(userId), any())).thenReturn(/* Mock the updated user here */);
//
//        mockMvc.perform(put("/users/{userId}", userId)
//               .contentType(MediaType.APPLICATION_JSON)
//               .content(objectMapper.writeValueAsString(updatedUserDTO)))
//               .andExpect(status().isOk());
//    }

    @Test
    void deleteUserShouldReturnNoContent() throws Exception {
        long userId = 1L;
        doNothing().when(userService).deleteUser(userId);

        mockMvc.perform(delete("/users/{userId}", userId))
               .andExpect(status().isOk());
    }
}

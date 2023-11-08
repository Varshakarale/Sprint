package com.projectems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.dao.UserRepository;
import com.projectems.entities.User;

@Service
public class UserServices {
	 @Autowired
	    private  UserRepository userRepository ;
	    
	    public UserServices(UserRepository userRepository) 
	    {
	        this.userRepository = userRepository;
	    }

	    public User saveUser(User user)
	    {
	        return userRepository.save(user);
	    }

	    public List<User> getAllUser() 
	    {
	        return userRepository.findAll();
	    }

	    public Optional<User> getUserById(Long userId) 
	    {
	        return userRepository.findById(userId);
	    }

	    public User updateUser(User user) 
	    {
	        return userRepository.save(user);
	    }

	    


}

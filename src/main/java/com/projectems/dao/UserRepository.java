package com.projectems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectems.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
    
    User findByUsername(String username);

    
}

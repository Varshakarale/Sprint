package com.projectems.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // The Employee entity can have a one-to-one relationship with the User entity
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    private String email;

    //Many-to-One relationship with Manager
    //Each Employee is linked to one Manager within the same department
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
    
    //Many-to-One relationship with Department
    //Each Employee is associated with one Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

package com.example.backend.model;

import com.example.backend.enumration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotEmpty(message = "first name cannot be empty or null")
    private String first_name;
    private String last_name;
    @NotEmpty(message = "Gender cannot be empty")
    private String gender;
    @Column(unique=true)
    @NotEmpty(message = "email address cannot be empty or null")
    private String email;
    @Column(unique=true)
    @NotEmpty(message = "phone number cannot be empty or null")
    private String phone;
    private String headline;
    private String profile_url;
    private Date Date_of_birth;
    private Status status;
    @NotEmpty(message = "password cannot be empty or null")
    private String password;

}

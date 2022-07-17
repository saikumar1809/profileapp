package com.example.backend.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="education")
public class Education {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private long userId;
    @NotEmpty(message = "school cannot be empty or null")
    private String school;
    @NotEmpty(message = "Degree cannot be empty or null")
    private String degree;
    @NotEmpty(message = "field of study cannot be empty or null")
    private String fieldOfStudy;
    private Date startDate;
    private Date endDate;
    private String description;
    private String grade;

}

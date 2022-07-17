package com.example.backend.experience.model;

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
@Table(name="experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private long userId;
    @NotEmpty(message = "title cannot be null")
    private String title;
    @JoinColumn(name="employment_type_id",referencedColumnName = "id")
    private long employmentTypeId;
    @NotEmpty(message = "company name cannot be null")
    private String companyName;
    private String location;

    private Date startDate;
    private Date endDate;





}

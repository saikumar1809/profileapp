package com.example.backend.experience.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employment_type")
public class EmploymentType {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @NotEmpty(message = "employment type cannot be null")
    String type;

}

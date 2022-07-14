package com.example.backend.address.model;

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
@Table(name="address_type")
public class Address_Type {
    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    @NotEmpty(message = "Addres type cannot be null")
    String type;
}

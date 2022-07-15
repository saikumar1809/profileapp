package com.example.backend.address.model;

import com.example.backend.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
   private  String house_number;
   private String city;
   private String state;
   private  String country;
   private int postalcode;

   //@OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="address_type_id",referencedColumnName = "id")
   private long addressTypeId;
    //@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private long userId;



}

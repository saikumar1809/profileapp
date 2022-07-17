package com.example.backend.skill.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @JoinColumn(name="user_id",referencedColumnName = "id")
    private long userId;

    @JoinColumn(name="skill_name_id",referencedColumnName = "id")
    private long skillNameId;
    @JoinColumn(name="proficiency_id",referencedColumnName = "id")
    private long proficiencyId;


}

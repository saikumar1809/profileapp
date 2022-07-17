package com.example.backend.skill.repo;

import com.example.backend.skill.model.Proficiency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProficiencyRepo extends JpaRepository<Proficiency,Long> {

   // List<Proficiency> findAllByUserId(long userId);
}

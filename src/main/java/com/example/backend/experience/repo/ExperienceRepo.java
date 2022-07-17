package com.example.backend.experience.repo;

import com.example.backend.experience.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepo extends JpaRepository<Experience,Long> {

    List<Experience> findAllByUserId(long userId);
}

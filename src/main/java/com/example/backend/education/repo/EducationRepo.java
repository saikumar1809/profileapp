package com.example.backend.education.repo;

import com.example.backend.education.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepo extends JpaRepository<Education,Long> {

    List<Education> findAllByUserId(long userId);
}

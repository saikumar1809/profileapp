package com.example.backend.education.service;

import com.example.backend.education.model.Education;

import java.util.List;

public interface EducationService {
    Education create(Education education);
    Education get(long id);
    List<Education> getAllByUserId(long userId);
}

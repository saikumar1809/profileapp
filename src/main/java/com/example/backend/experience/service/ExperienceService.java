package com.example.backend.experience.service;

import com.example.backend.experience.model.Experience;

import java.util.List;

public interface ExperienceService {
    Experience create(Experience experience);
    Experience get(long id);
    List<Experience> getAllByUserId(long userId);
}

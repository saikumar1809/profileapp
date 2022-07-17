package com.example.backend.experience.service;

import com.example.backend.experience.model.EmploymentType;

import java.util.Collection;

public interface EmploymentTypeService {
    EmploymentType create(EmploymentType employmentType);
    EmploymentType get(long id);
    Collection<EmploymentType> list(int limit);
}

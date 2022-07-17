package com.example.backend.experience.service.implementation;

import com.example.backend.experience.model.EmploymentType;
import com.example.backend.experience.repo.EmploymentTypeRepo;
import com.example.backend.experience.service.EmploymentTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class EmploymentTypeServiceImplementation  implements EmploymentTypeService {
    private final EmploymentTypeRepo employmentTypeRepo;
    @Override
    public EmploymentType create(EmploymentType employmentType) {
        return employmentTypeRepo.save(employmentType);
    }

    @Override
    public EmploymentType get(long id) {
        return employmentTypeRepo.findById(id).get();
    }

    @Override
    public Collection<EmploymentType> list(int limit) {
        return employmentTypeRepo.findAll(PageRequest.of(0,limit)).toList();
    }
}

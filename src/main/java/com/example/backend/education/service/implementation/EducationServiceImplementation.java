package com.example.backend.education.service.implementation;

import com.example.backend.education.model.Education;
import com.example.backend.education.repo.EducationRepo;
import com.example.backend.education.service.EducationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class EducationServiceImplementation  implements EducationService {
    private final EducationRepo educationRepo;

    @Override
    public Education create(Education education) {
        return educationRepo.save(education);
    }

    @Override
    public Education get(long id) {
        return educationRepo.findById(id).get();
    }

    @Override
    public List<Education> getAllByUserId(long userId) {
        return educationRepo.findAllByUserId(userId);
    }
}

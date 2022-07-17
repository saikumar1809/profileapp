package com.example.backend.experience.service.implementation;

import com.example.backend.experience.model.Experience;
import com.example.backend.experience.repo.ExperienceRepo;
import com.example.backend.experience.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ExperienceServiceImplementation implements ExperienceService {
    private final ExperienceRepo experienceRepo;

    @Override
    public Experience create(Experience experience) {
        return experienceRepo.save(experience);
    }


    @Override
    public Experience get(long id) {
        return experienceRepo.findById(id).get();
    }




    @Override
    public List<Experience> getAllByUserId(long userId) {
        return experienceRepo.findAllByUserId(userId);
    }
}

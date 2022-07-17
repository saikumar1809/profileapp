package com.example.backend.skill.service.implementation;


import com.example.backend.skill.model.Proficiency;
import com.example.backend.skill.repo.ProficiencyRepo;
import com.example.backend.skill.service.ProficiencyService;
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
public class ProficiencyServiceImplementation implements ProficiencyService {
    private final ProficiencyRepo proficiencyRepo;
    @Override
    public Proficiency create(Proficiency proficiency) {
        return proficiencyRepo.save(proficiency);
    }

    @Override
    public Proficiency get(long id) {
        return proficiencyRepo.findById(id).get();
    }

    @Override
    public Collection<Proficiency> list(int limit) {
        return proficiencyRepo.findAll(PageRequest.of(0,limit)).toList();
    }
}

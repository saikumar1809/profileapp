package com.example.backend.skill.service.implementation;

import com.example.backend.experience.model.Experience;
import com.example.backend.experience.repo.ExperienceRepo;
import com.example.backend.skill.model.Skill;
import com.example.backend.skill.repo.SkillRepo;
import com.example.backend.skill.service.SkillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SkillServiceImplementation implements SkillService {
    private final SkillRepo skillRepo;

    @Override
    public Skill create(Skill skill) {
        return skillRepo.save(skill);
    }



    @Override
    public Skill  get(long id) {
        return skillRepo.findById(id).get();
    }




    @Override
    public List<Skill> getAllByUserId(long userId) {
        return skillRepo.findAllByUserId(userId);
    }
}

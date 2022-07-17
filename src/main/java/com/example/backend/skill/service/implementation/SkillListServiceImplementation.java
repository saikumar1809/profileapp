package com.example.backend.skill.service.implementation;


import com.example.backend.skill.model.SkillList;
import com.example.backend.skill.repo.SkillListRepo;
import com.example.backend.skill.repo.SkillRepo;
import com.example.backend.skill.service.SkillListService;
import com.example.backend.skill.service.SkillListService;
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
public class SkillListServiceImplementation implements SkillListService {
    private final SkillListRepo skillListRepo;
    @Override
    public SkillList create(SkillList skillList) {
        return skillListRepo.save(skillList);
    }

    @Override
    public SkillList get(long id) {
        return skillListRepo.findById(id).get();
    }

    @Override
    public Collection<SkillList> list(int limit) {
        return skillListRepo.findAll(PageRequest.of(0,limit)).toList();
    }
}

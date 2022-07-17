package com.example.backend.skill.service;

import com.example.backend.experience.model.Experience;
import com.example.backend.skill.model.Skill;

import java.util.List;

public interface SkillService {
    Skill create(Skill skill);
    Skill get(long id);
    List<Skill> getAllByUserId(long userId);
}

package com.example.backend.skill.service;

import com.example.backend.skill.model.Proficiency;
import com.example.backend.skill.model.SkillList;

import java.util.Collection;

public interface ProficiencyService {
    Proficiency create(Proficiency proficiency);
    Proficiency get(long id);
    Collection<Proficiency> list(int limit);
}

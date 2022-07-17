package com.example.backend.skill.service;

import com.example.backend.skill.model.SkillList;

import java.util.Collection;

public interface SkillListService {
    SkillList create(SkillList skillList);
    SkillList get(long id);
    Collection<SkillList> list(int limit);
}

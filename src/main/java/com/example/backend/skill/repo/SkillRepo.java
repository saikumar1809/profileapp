package com.example.backend.skill.repo;

import com.example.backend.skill.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepo extends JpaRepository<Skill,Long> {

    List<Skill> findAllByUserId(long userId);
}

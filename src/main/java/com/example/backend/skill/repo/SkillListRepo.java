package com.example.backend.skill.repo;

import com.example.backend.skill.model.SkillList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillListRepo extends JpaRepository<SkillList,Long> {

   // List<SkillList> findAllByUserId(long userId);
}

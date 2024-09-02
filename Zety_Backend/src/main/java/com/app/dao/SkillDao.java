package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Skill;

public interface SkillDao extends JpaRepository<Skill,Long> {

}

package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Education;

public interface EducationDao extends JpaRepository<Education, Long> {

}

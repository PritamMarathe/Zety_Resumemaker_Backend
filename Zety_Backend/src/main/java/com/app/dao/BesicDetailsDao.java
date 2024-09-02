package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entity.BasicDetails;

public interface BesicDetailsDao extends JpaRepository<BasicDetails, Long> {
    // JpaRepository already provides save and findById methods
}

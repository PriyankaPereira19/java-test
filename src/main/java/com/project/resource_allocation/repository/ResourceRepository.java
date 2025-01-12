package com.project.resource_allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.resource_allocation.model.Resource;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    List<Resource> findBySkillsetContainingIgnoreCaseAndExperienceLessThan(String skill, Integer experience);
    List<Resource> findBySkillsetContainingIgnoreCase(String skill);
}


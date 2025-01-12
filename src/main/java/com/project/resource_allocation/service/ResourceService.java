package com.project.resource_allocation.service;

import org.springframework.stereotype.Service;

import com.project.resource_allocation.model.Resource;
import com.project.resource_allocation.repository.ResourceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    private final ResourceRepository repository;

    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    public List<String> getResourcesForMicroService(String... skills) {
        return repository.findAll().stream()
                .filter(resource -> hasAllSkills(resource.getSkillset(), skills))
                .map(Resource::getResourceName)
                .collect(Collectors.toList());
    }

    public List<String> getResourcesForCloudProject(int maxExperience, String... skills) {
        return repository.findAll().stream()
                .filter(resource -> resource.getExperience() < maxExperience && hasAllSkills(resource.getSkillset(), skills))
                .map(Resource::getResourceName)
                .collect(Collectors.toList());
    }

    private boolean hasAllSkills(String skillset, String... requiredSkills) {
        for (String skill : requiredSkills) {
            if (!skillset.toLowerCase().contains(skill.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}

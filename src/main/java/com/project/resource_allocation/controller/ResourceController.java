package com.project.resource_allocation.controller;

import org.springframework.web.bind.annotation.*;

import com.project.resource_allocation.service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping("/microservice")
    public List<String> getMicroServiceResources(@RequestParam List<String> skills) {
        return service.getResourcesForMicroService(skills.toArray(new String[0]));
    }

    @GetMapping("/cloudproject")
    public List<String> getCloudProjectResources(
            @RequestParam int maxExperience,
            @RequestParam List<String> skills) {
        return service.getResourcesForCloudProject(maxExperience, skills.toArray(new String[0]));
    }
}


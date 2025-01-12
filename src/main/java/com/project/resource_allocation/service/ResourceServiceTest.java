package com.project.resource_allocation.service;

import org.junit.jupiter.api.Test;
import com.project.resource_allocation.model.Resource;
import com.project.resource_allocation.repository.ResourceRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ResourceServiceTest {

    @Test
    public void testGetResourcesForMicroService() {
        ResourceRepository repository = mock(ResourceRepository.class);
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Resource(1, "Thompson", 7, "Java, Redis, Javascript"),
                        new Resource(2, "Kumar", 3, "Java, Redis, Javascript")
                )
        );

        ResourceService service = new ResourceService(repository);
        List<String> resources = service.getResourcesForMicroService("Java", "Redis", "Javascript");

        assertEquals(Arrays.asList("Thompson", "Kumar"), resources);
    }
}


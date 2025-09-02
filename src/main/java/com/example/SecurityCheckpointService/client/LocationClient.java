package com.example.SecurityCheckpointService.client;

import com.example.SecurityCheckpointService.model.LocationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "location-service", url = "${location-service.url}")
public interface LocationClient {
    @GetMapping("/api/locations/{id}")
    LocationDTO getLocationById(@PathVariable("id") Long id);
}
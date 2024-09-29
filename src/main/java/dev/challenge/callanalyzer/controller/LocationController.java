package dev.challenge.callanalyzer.controller;

import dev.challenge.callanalyzer.service.LocationExtractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationExtractorService locationExtractorService;
    @PostMapping("/extract")
    public List<String> extractLocations(@RequestBody String text) {
        return locationExtractorService.extractLocations(text);
    }
}

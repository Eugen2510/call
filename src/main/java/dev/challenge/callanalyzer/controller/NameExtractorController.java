package dev.challenge.callanalyzer.controller;

import dev.challenge.callanalyzer.service.NameExtractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/names")
@RequiredArgsConstructor
public class NameExtractorController {

    private final NameExtractorService nameExtractorService;

    @PostMapping("/extract")
    public ResponseEntity<List<String>> extractNames(@RequestBody String text) {
        List<String> extractedNames = nameExtractorService.extractNames(text);
        return ResponseEntity.ok(extractedNames);
    }
}

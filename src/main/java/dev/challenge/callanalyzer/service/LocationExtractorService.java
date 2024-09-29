package dev.challenge.callanalyzer.service;

import lombok.RequiredArgsConstructor;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.util.Span;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationExtractorService {

    private final TokenizerME tokenizer;
    private final NameFinderME locationFinder;

    public List<String> extractLocations(String text) {
        String[] tokens = tokenizer.tokenize(text);
        Span[] locationSpans = locationFinder.find(tokens);

        List<String> locations = new ArrayList<>();
        for (Span span : locationSpans) {
            StringBuilder location = new StringBuilder();
            for (int i = span.getStart(); i < span.getEnd(); i++) {
                location.append(tokens[i]).append(" ");
            }
            locations.add(location.toString().trim());
        }
        return locations;
    }
}

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
public class NameExtractorService {
    private final TokenizerME tokenizer;
    private final NameFinderME nameFinder;

    public List<String> extractNames(String text) {
        String[] tokens = tokenizer.tokenize(text);
        Span[] nameSpans = nameFinder.find(tokens);

        List<String> names = new ArrayList<>();
        for (Span span : nameSpans) {
            StringBuilder name = new StringBuilder();
            for (int i = span.getStart(); i < span.getEnd(); i++) {
                name.append(tokens[i]).append(" ");
            }
            names.add(name.toString().trim());
        }
        return names;
    }
}

package dev.challenge.callanalyzer.config;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.InputStream;

@Configuration
public class OpenNlpConfig {

    @Bean
    public TokenizerME tokenizer() throws Exception {
        try (InputStream tokenModelStream = new FileInputStream("src/main/resources/nlp/en-token.bin")) {
            TokenizerModel tokenizerModel = new TokenizerModel(tokenModelStream);
            return new TokenizerME(tokenizerModel);
        }
    }

    @Bean
    public NameFinderME nameFinder() throws Exception {
        try (InputStream nameModelStream = new FileInputStream("src/main/resources/nlp/en-ner-person.bin")) {
            TokenNameFinderModel nameModel = new TokenNameFinderModel(nameModelStream);
            return new NameFinderME(nameModel);
        }
    }

    @Bean
    public NameFinderME locationFinder() throws Exception {
        try (InputStream locationModelStream = new FileInputStream("src/main/resources/nlp/en-ner-location.bin")) {
            TokenNameFinderModel locationModel = new TokenNameFinderModel(locationModelStream);
            return new NameFinderME(locationModel);
        }
    }
}

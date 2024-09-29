package dev.challenge.callanalyzer.service;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class SpeechRecognitionService {
    private final AudioConversionService audioConversionService;
    public String transcribeAudioWithSphinx(String audioFilePath) throws Exception {

        if (audioFilePath.endsWith(".mp3")) {
            audioFilePath = audioConversionService.convertMp3ToWav(audioFilePath);
        }

        StreamSpeechRecognizer recognizer = getStreamSpeechRecognizer();
        InputStream stream = new FileInputStream(audioFilePath);

        recognizer.startRecognition(stream);
        SpeechResult result;
        StringBuilder transcribedText = new StringBuilder();
        while ((result = recognizer.getResult()) != null) {
            String hypothesis = result.getHypothesis();
            transcribedText.append(hypothesis).append(" ");
        }
        recognizer.stopRecognition();

        return transcribedText.toString().trim();
    }

    private static StreamSpeechRecognizer getStreamSpeechRecognizer() throws IOException {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

       // configuration.setSampleRate(8000); //якщо ви хочете декодувати звук у телефонній якості з частотою дискретизації 8000 Гц

        return new StreamSpeechRecognizer(configuration);
    }


}
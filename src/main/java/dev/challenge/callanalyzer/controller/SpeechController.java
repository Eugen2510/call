package dev.challenge.callanalyzer.controller;

import dev.challenge.callanalyzer.service.SpeechRecognitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpeechController {
    private final SpeechRecognitionService speechRecognitionService;
    @PostMapping("/speech")
    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
    public String convertAudio(@RequestParam @Valid String path) throws Exception {
        return speechRecognitionService.transcribeAudioWithSphinx(path);
    }


//    @PostMapping("/vosk")
//    @ResponseStatus(HttpStatus.OK)
////    @ResponseBody
//    public String convertAudioVosk(@RequestParam @Valid String path) throws Exception {
//        return voskSpeechRecognitionService.recognizeSpeechFromWav(path);
//    }
}
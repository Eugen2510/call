package dev.challenge.callanalyzer.service;

import org.springframework.stereotype.Service;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@Service
public class AudioConversionService {

    public String convertMp3ToWav(String mp3FilePath) throws UnsupportedAudioFileException, IOException {

        File mp3File = new File(mp3FilePath);
        String wavFilePath = mp3FilePath.replace(".mp3", ".wav");
        File wavFile = new File(wavFilePath);

        AudioInputStream mp3Stream = AudioSystem.getAudioInputStream(mp3File);

        AudioFormat baseFormat = mp3Stream.getFormat();
        AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                16000,
                16,
                baseFormat.getChannels(),
                4,
                baseFormat.getFrameRate(),
                false);
        try (AudioInputStream decodedStream = AudioSystem.getAudioInputStream(decodedFormat, mp3Stream)) {
            AudioSystem.write(decodedStream, AudioFileFormat.Type.WAVE, wavFile);
        }

        return wavFilePath;
    }
}

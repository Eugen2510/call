package dev.challenge.callanalyzer.service;

import org.springframework.stereotype.Service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@Service
public class AudioConversionService {

    public String convertMp3ToWav(String mp3FilePath) throws UnsupportedAudioFileException, IOException {
        File mp3File = new File(mp3FilePath);
        System.out.println("File found. File + " + mp3File.getName());

        String wavFilePath = mp3FilePath.replace(".mp3", ".wav");
        File wavFile = new File(wavFilePath);

        // Загружаем MP3 файл
        AudioInputStream mp3Stream = AudioSystem.getAudioInputStream(mp3File);

        // Преобразуем MP3 поток в WAV
        AudioFormat baseFormat = mp3Stream.getFormat();
        AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
//                baseFormat.getSampleRate(),
                16000,
                16,
                baseFormat.getChannels(),
                2,
                16000,
                false);

        try (AudioInputStream decodedStream = AudioSystem.getAudioInputStream(decodedFormat, mp3Stream)) {
            AudioSystem.write(decodedStream, AudioFileFormat.Type.WAVE, wavFile);
        }

        return wavFilePath;
    }
}

package com.zorrix.tgpremiumbot.utils;

import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams;
import com.zorrix.tgpremiumbot.config.TelegramConfig;

import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Voice;

import java.io.FileInputStream;
import java.io.IOException;

public class Converter {
    AssemblyAI assemblyAI;
    TelegramConfig config;

    public Converter(TelegramConfig config){
        this.config = config;

        this.assemblyAI = AssemblyAI.builder()
                .apiKey(config.getAssemblyAIKey())
                .build();
    }

    public String convert(File audio, Voice voice) throws IOException {
        System.out.println("converting " + audio);

        String audioPath = audio.getFilePath();
        String audioUrl = "https://api.telegram.org/file/bot" + config.getBotToken() + "/" + audioPath;

        TranscriptOptionalParams params = TranscriptOptionalParams.builder()
                .languageDetection(true)
                .build();

        Transcript transcript = assemblyAI.transcripts().transcribe(audioUrl, params);

        if (transcript.getText().isPresent())
            return transcript.getText().get();
        else return "ERROR";
    }
}

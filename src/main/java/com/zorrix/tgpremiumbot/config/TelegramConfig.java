package com.zorrix.tgpremiumbot.config;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramConfig {
    @Value("${telegram.api-url}")
    String apiUrl;
    @Value("${telegram.bot-name}")
    String botName;
    @Value("${telegram.bot-token}")
    String botToken;
    @Value("${message.too-big-voice.text}")
    String tooBigVoiceText;
    @Value("${message.illegal-message.text}")
    String illegalMessageText;
    @Value("${message.wtf.text}")
    String wtfText;
    @Value("${commands.start-command}")
    String startCommand;

    @PostConstruct
    public void init() {
        System.out.println("URL: " + apiUrl);
        System.out.println(botName);
    }
}

package com.zorrix.tgpremiumbot.config;

import jakarta.annotation.PostConstruct;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:/application.yaml")
@Component
@Setter @Getter
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
    String startMessage;
    @Value("${commands.start-command}")
    String startCommand;
}
package com.zorrix.tgpremiumbot.config;

import com.zorrix.tgpremiumbot.Bot;
import com.zorrix.tgpremiumbot.UpdateProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Configuration
@RequiredArgsConstructor
public class UpdateProcessorConfig {
    private final Bot bot;

    @Bean
    public UpdateProcessor updateProcessor() throws TelegramApiException {
        UpdateProcessor processor = new UpdateProcessor();
        processor.registerBot(bot);
        return processor;
    }
}

package com.zorrix.tgpremiumbot;

import com.zorrix.tgpremiumbot.config.SpringConfig;
import com.zorrix.tgpremiumbot.config.TelegramConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication

public class PremiumTgBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(SpringConfig.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        UpdateProcessor updateProcessor = new UpdateProcessor();
        updateProcessor.registerBot(context.getBean(Bot.class));

    }

}

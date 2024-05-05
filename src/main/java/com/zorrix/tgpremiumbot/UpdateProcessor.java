package com.zorrix.tgpremiumbot;

import com.zorrix.tgpremiumbot.config.TelegramConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class UpdateProcessor {

    public void registerBot(Bot bot) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        System.out.println(new TelegramConfig().getBotName());

        try{
            telegramBotsApi.registerBot(bot);
            System.out.println("bot is running!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

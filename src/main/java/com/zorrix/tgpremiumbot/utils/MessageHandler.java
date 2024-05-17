package com.zorrix.tgpremiumbot.utils;

import com.zorrix.tgpremiumbot.Bot;
import com.zorrix.tgpremiumbot.config.SpringConfig;
import com.zorrix.tgpremiumbot.config.TelegramConfig;
import com.zorrix.tgpremiumbot.exceptions.WrongMessageException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageHandler {

    TelegramConfig config;
    AnnotationConfigApplicationContext context;

    public MessageHandler(){
//        context = new AnnotationConfigApplicationContext(SpringConfig.class);
        this.config = new TelegramConfig();
    }

    public void handle(@NotNull Update update, Bot bot) throws WrongMessageException, TelegramApiException {
        if (!update.hasCallbackQuery()){
            System.out.println("handling message!");
            Message message = update.getMessage();

            if (message.hasText()){
                handleText(message, bot);
            }
        }
    }

    private void handleText(Message message, Bot bot) throws TelegramApiException {
        System.out.println(config.getBotName());
        if (message.getText().equals(config.getStartCommand())){
            bot.executeTextMessage(message.getChatId(), "HELLO!");
        } else{
            bot.executeTextMessage(message.getChatId(), message.getText());

            throw new WrongMessageException("Wrong message!");
        }
    }
}

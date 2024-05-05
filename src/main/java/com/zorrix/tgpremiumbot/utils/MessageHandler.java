package com.zorrix.tgpremiumbot.utils;

import com.zorrix.tgpremiumbot.Bot;
import com.zorrix.tgpremiumbot.config.TelegramConfig;
import com.zorrix.tgpremiumbot.exceptions.WrongMessageException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageHandler {
    TelegramConfig config;

    public MessageHandler(){
        this.config = new TelegramConfig();
    }

    public void handle(Update update, Bot bot) throws WrongMessageException, TelegramApiException {
        if (!update.hasCallbackQuery()){
            Message message = update.getMessage();

            if (message.hasText()){
                handleText(message, bot);
            }
        }
    }

    private void handleText(Message message, Bot bot) throws TelegramApiException {
        if (message.getText().equals(config.getStartCommand())){
            bot.executeTextMessage(message.getChatId(), "HELLO!");
        } else{
            bot.executeTextMessage(message.getChatId(), message.getText());

            throw new WrongMessageException();
        }
    }
}

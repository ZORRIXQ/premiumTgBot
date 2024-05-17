package com.zorrix.tgpremiumbot;

import com.zorrix.tgpremiumbot.config.TelegramConfig;
import com.zorrix.tgpremiumbot.utils.MessageHandler;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bot extends TelegramLongPollingBot {
    String botName;
    String botToken;

    String tooBigVoiceText;
    String illegalMessageText;
    String wtfText;
    UpdateProcessor updateProcessor;

    TelegramConfig config;

    MessageHandler messageHandler;

//    @PostConstruct
//    public void init() throws TelegramApiException {
//        updateProcessor.registerBot(this);
//        try{
//            var setWebhook = SetWebhook.builder()
//                    .url()
//                    .build();
//        }
//    }

    private Bot(){
        this.config = new TelegramConfig();
        this.messageHandler = new MessageHandler();
    }

    public static Bot createEmptyBot(){
        return new Bot();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            System.out.print("new message: " + update.getMessage().getText() + "\n");
            messageHandler.handle(update, this);
        } catch (TelegramApiException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void executeTextMessage(Long chatId, String text) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);

        execute(sendMessage);
    }

    @Override
    public String getBotUsername() {
        return this.botName;
    }
}

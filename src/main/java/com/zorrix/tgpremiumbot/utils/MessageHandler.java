package com.zorrix.tgpremiumbot.utils;

import com.zorrix.tgpremiumbot.Bot;
import com.zorrix.tgpremiumbot.config.TelegramConfig;
import com.zorrix.tgpremiumbot.exceptions.WrongMessageException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

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

    public void handle(@NotNull Update update, Bot bot) throws WrongMessageException, TelegramApiException, IOException {
        if (!update.hasCallbackQuery()){
            System.out.println("handling message!");
            Message message = update.getMessage();

            if (message.hasText()){
                handleText(message, bot);
            } else if (message.hasVoice()){
                handleVoice(update, bot);
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

    private void handleVoice(Update update, Bot bot) throws TelegramApiException, IOException {
        Converter converter = new Converter(config);
        Message message = update.getMessage();
        Voice voice = message.getVoice();

        File audio = bot.execute(GetFile.builder()
                .fileId(voice.getFileId())
                .build());

        String textToSend = converter.convert(audio, voice);

        System.out.println("start executing text: " + textToSend);
        bot.executeTextMessage(message.getChatId(), textToSend);

    }

}

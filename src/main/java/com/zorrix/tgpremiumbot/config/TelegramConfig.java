package com.zorrix.tgpremiumbot.config;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Setter @Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramConfig {
//    @Value("https://api.telegram.org/")
    String apiUrl = "https://api.telegram.org/";
//    @Value("TG PREMIUM")
    String botName = "TG PREMIUM";
//    @Value("6797309884:AAG9ZSyBqmvsZUNME2WS87QlL0v73Ylmgv0")
    String botToken = "6797309884:AAG9ZSyBqmvsZUNME2WS87QlL0v73Ylmgv0";
//    @Value("текст сообщения в ответ на отправку слишком длинного голосового сообщения (лимит - 10 минут)")
    String tooBigVoiceText = "текст сообщения в ответ на отправку слишком длинного голосового сообщения (лимит - 10 минут)";
//    @Value("illegal message!")
    String illegalMessageText = "illegal message!";
//    @Value("wtf")
    String wtfText = "wtf";
//    @Value("hello!")
    String startMessage = "hello!";
//    @Value("/start")
    String startCommand = "/start";
}
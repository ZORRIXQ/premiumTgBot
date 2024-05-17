package com.zorrix.tgpremiumbot.config;

import com.zorrix.tgpremiumbot.Bot;
import com.zorrix.tgpremiumbot.utils.MessageHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.zorrix.tgpremiumbot")
@AllArgsConstructor
@PropertySource("classpath:/application.yaml")
public class SpringConfig {

    @Bean
    public Bot bot(@Value("TG Premium") String botName,
                   @Value("6797309884:AAG9ZSyBqmvsZUNME2WS87QlL0v73Ylmgv0") String botToken){
        Bot bot = Bot.createEmptyBot();
        bot.setBotName(botName);
        bot.setBotToken(botToken);

        return bot;
    }
    /*
    @Bean
    public TelegramConfig getConfig(
            @Value("https://api.telegram.org/") String apiUrl,
            @Value("TG PREMIUM") String botName,
            @Value("6797309884:AAG9ZSyBqmvsZUNME2WS87QlL0v73Ylmgv0") String botToken,
            @Value("текст сообщения в ответ на отправку слишком длинного голосового сообщения (лимит - 10 минут)") String tooBigVoiceText,
            @Value("illegal message!") String illegalMessageText,
            @Value("wtf") String wtfText,
            @Value("hello!") String startMessage,
            @Value("/start") String startCommand){
        TelegramConfig config = new TelegramConfig();

        config.setBotToken(botToken);
        config.setBotName(botName);
        config.setApiUrl(apiUrl);
        config.setTooBigVoiceText(tooBigVoiceText);
        config.setIllegalMessageText(illegalMessageText);
        config.setStartMessage(startMessage);
        config.setStartCommand(startCommand);
        return config;
    }
    */

}

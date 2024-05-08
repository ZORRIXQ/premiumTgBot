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
public class SpringConfig {

    @Bean
    public Bot bot(@Value("${telegram.bot-name}") String botName,
                   @Value("${telegram.bot-token}") String botToken){
        Bot bot = Bot.createEmptyBot();
        bot.setBotName(botName);
        bot.setBotToken(botToken);

        return bot;
    }
}

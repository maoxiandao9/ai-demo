package org.amumu.ai.config;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class chatMemoryConfig {

    @Bean
    public ChatMemory chatMemory() {
        // 将我们的对话记录存放到内存当中，可以实现持久化或者基于Redis
        InMemoryChatMemory inMemoryChatMemory = new InMemoryChatMemory();
        return inMemoryChatMemory;
    }
}

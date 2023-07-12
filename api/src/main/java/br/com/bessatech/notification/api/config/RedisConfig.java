package br.com.bessatech.notification.api.config;

import br.com.bessatech.notification.listener.RedisKeyExpirationListener;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisConfig {

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter(container), new PatternTopic("__keyevent@*__:expired"));
        return container;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    private MessageListenerAdapter messageListenerAdapter(RedisMessageListenerContainer container) {
        return new MessageListenerAdapter(new RedisKeyExpirationListener(container), "handleMessage");
    }
}

package br.com.bessatech.notification.listener;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Chave expirada: " + message);
        System.out.println("Chave expirada: " + pattern);
    }

    public void handleMessage(Message message, Object body) {
        System.out.println("Chave expirada: " + message);
    }
}
package br.com.bessatech.notification.api.service;

import br.com.bessatech.notification.core.dto.Teste;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class DebugService {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper mapper;

    public void saveInRedis() throws JsonProcessingException {
        redisTemplate.opsForValue().set(RandomStringUtils.randomAlphabetic(10), mapper.writeValueAsString(new Teste("dsa")), Duration.ofSeconds(10));
    }

}

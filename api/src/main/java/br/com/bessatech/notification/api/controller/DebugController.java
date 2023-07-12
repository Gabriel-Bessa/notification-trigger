package br.com.bessatech.notification.api.controller;

import br.com.bessatech.notification.api.service.DebugService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/debug")
public class DebugController {

    private final DebugService service;

    @GetMapping
    public void teste() throws JsonProcessingException {
        service.saveInRedis();
    }

}

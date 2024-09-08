package com.springollama.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.ollama.OllamaChatModel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: drizzle
 * @Date: 2024/09/08/18:26
 * @Description:
 */
@RestController
public class OllamaController {
    @Resource
    private ChatModel chatModel;


    @RequestMapping("/ai/ollama")
    public Object ollama(@RequestParam("msg") String msg) {
        ChatResponse call = chatModel.call(new Prompt(msg, OllamaOptions.create().withTemperature(0.4F)));
        return call.getResult().getOutput().getContent();
    }
}

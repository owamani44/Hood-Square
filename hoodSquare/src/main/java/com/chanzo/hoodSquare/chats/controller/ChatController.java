package com.chanzo.hoodSquare.chats.controller;

import com.chanzo.hoodSquare.chats.model.ChatMessage;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){

    }
}

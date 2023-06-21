package ru.javabegin.micro.planner.todo.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

//описывает каналы для работы с message broker
public interface TodoBindings { //название может быть любым

    String INPUT_CHANNEL = "todoInputChannel"; //нужен чтобы на него ссылаться

    @Input(INPUT_CHANNEL)
    MessageChannel todoInputChannel();
}

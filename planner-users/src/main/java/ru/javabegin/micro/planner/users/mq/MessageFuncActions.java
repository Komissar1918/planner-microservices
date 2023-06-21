package ru.javabegin.micro.planner.users.mq;

import lombok.Getter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;
//работа с каналами
@Service
@Getter
public class MessageFuncActions { //помогает реалтзовать отправку сообщений с помощью функционального кода
    //каналы для обмена сообщениями
    private MessageFunc messageFunc;

    public MessageFuncActions(MessageFunc messageFunc) {
        this.messageFunc = messageFunc;
    }

    //отправка сообщения
    public void sendNewUserMessage(Long id) {
        //добавляем в слушатель новое сообщение
        messageFunc.getInnerBus().emitNext(MessageBuilder.withPayload(id).build(), Sinks.EmitFailureHandler.FAIL_FAST);
        System.out.println("Сообщение доставлено для id user: " + id);

    }
}

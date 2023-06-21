package ru.javabegin.micro.planner.users.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//интрфейс, который нужен для работы mq
//здесь создаем нужные нам каналы message broker
public interface TodoBinding { //название может быть любым

    String OUTPUT_CHANNEL = "todoOutputChannel"; //нужен чтобы на него ссылаться, что не использовать антипаттерн Magic String

    //создает канал для отправки сообщеений
    @Output(OUTPUT_CHANNEL)
    MessageChannel todoOutputChannel(); //название канала может браться из названия метода, если не указать явно в аннотации
}

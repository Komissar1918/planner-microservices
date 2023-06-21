package ru.javabegin.micro.planner.todo.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ru.javabegin.micro.planner.todo.service.TestDataService;

@Component
@EnableBinding(TodoBindings.class)
public class MessageConsumer {
    private TestDataService testDataService;

    public MessageConsumer(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    //метод вызывается автоматически, как только появляется сообщение в канале
    @StreamListener(target = TodoBindings.INPUT_CHANNEL) //Указываем какую очередь хотим считывать
    public void initTestData(Long userId) {
        testDataService.initTestData(userId);
    }
}

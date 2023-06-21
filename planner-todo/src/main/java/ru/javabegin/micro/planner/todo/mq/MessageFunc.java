package ru.javabegin.micro.planner.todo.mq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import ru.javabegin.micro.planner.todo.service.TestDataService;

import java.util.function.Consumer;
@Configuration // spring считывает бины и создает каналы
public class MessageFunc {

    private TestDataService testDataService;

    public MessageFunc(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    // получает id пользователя и запускает создание тестовых данных
    //название метода должно совпадать с настройками definition и bindings в файлах properties
    @Bean
    public Consumer<Message<Long>> newUserActionConsumer() {
        System.out.println("Принял сообщение и вызвал метод");
        return message -> testDataService.initTestData(message.getPayload());
    }
}

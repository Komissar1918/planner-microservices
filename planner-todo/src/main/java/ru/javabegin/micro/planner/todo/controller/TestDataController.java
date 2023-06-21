package ru.javabegin.micro.planner.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.micro.planner.entity.Category;
import ru.javabegin.micro.planner.entity.Priority;
import ru.javabegin.micro.planner.entity.Task;
import ru.javabegin.micro.planner.todo.service.CategoryService;
import ru.javabegin.micro.planner.todo.service.PriorityService;
import ru.javabegin.micro.planner.todo.service.TaskService;
import ru.javabegin.micro.planner.todo.service.TestDataService;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/data") //базовый URI
public class TestDataController {

    private final TestDataService testDataService;

    public TestDataController(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    @PostMapping("/init")
    public ResponseEntity<Boolean> init(@RequestBody Long userId) {
        testDataService.initTestData(userId);

        //если пользователя не существует
        return ResponseEntity.ok(true);
    }
}

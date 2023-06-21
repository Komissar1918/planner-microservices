package ru.javabegin.micro.planner.todo.service;

import org.springframework.stereotype.Service;
import ru.javabegin.micro.planner.entity.Category;
import ru.javabegin.micro.planner.entity.Priority;
import ru.javabegin.micro.planner.entity.Task;

import java.util.Calendar;
import java.util.Date;

@Service
public class TestDataService {

    private final TaskService taskService;
    private final CategoryService categoryService;
    private final PriorityService priorityService;

    public TestDataService(TaskService taskService, CategoryService categoryService, PriorityService priorityService) {
        this.taskService = taskService;
        this.categoryService = categoryService;
        this.priorityService = priorityService;
    }

    public void initTestData(Long userId){
        Priority priority1 = new Priority();
        priority1.setColor("#fff");
        priority1.setTitle("Высокий");
        priority1.setUserId(userId);

        Priority priority2 = new Priority();
        priority2.setColor("#ffe");
        priority2.setTitle("Средний");
        priority2.setUserId(userId);

        priorityService.add(priority1);
        priorityService.add(priority2);

        Category category1 = new Category();
        category1.setTitle("Работа");
        category1.setUserId(userId);

        Category category2 = new Category();
        category2.setTitle("Семья");
        category2.setUserId(userId);

        categoryService.add(category1);
        categoryService.add(category2);

        //завтра
        Date tomorrow = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(tomorrow);
        c.add(Calendar.DATE,1);
        tomorrow = c.getTime();

        //неделя
        Date oneWeek = new Date();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(oneWeek);
        c2.add(Calendar.DATE,7);
        oneWeek = c2.getTime();

        Task task1 = new Task();
        task1.setTitle("Поработать");
        task1.setCategory(category1);
        task1.setPriority(priority1);
        task1.setCompleted(true);
        task1.setTaskDate(tomorrow);
        task1.setUserId(userId);

        Task task2 = new Task();
        task2.setTitle("Сделать уборку");
        task2.setCategory(category2);
        task2.setPriority(priority2);
        task2.setCompleted(true);
        task2.setTaskDate(oneWeek);
        task2.setUserId(userId);

        taskService.add(task1);
        taskService.add(task2);
    }
}

package net.study.todolist.services;

import net.study.todolist.models.Todo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoService {

    List< Todo > getTodosByUser(String user);
    Optional< Todo > getTodoById(long id);
    void updateTodo(Todo todo);
    void addTodo(String name, String description, Date date, boolean isDone);
    void deleteTodo(long id);
    void saveTodo(Todo todo);

    void finishTodo(long id);
}

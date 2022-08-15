package net.study.todolist.services;

import net.study.todolist.models.Todo;
import net.study.todolist.repositories.TodoRepository;
import net.study.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodosByUser(String user) {
        return todoRepository.findByUsername(user);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String description, Date date, boolean isDone) {
        todoRepository.save(new Todo(name, description, date, isDone));
    }

    @Override
    public void deleteTodo(long id) {
        Optional < Todo > todo = todoRepository.findById(id);
        todo.ifPresent(value -> todoRepository.delete(value));
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void finishTodo(long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        todo.ifPresent(value -> {
            value.changeStatus();
            todoRepository.save(value);
        });
    }
}

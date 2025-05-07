package hello.hello_spring.controller;

import hello.hello_spring.service.TodoService;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {
  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @PostMapping("todos")
  @ResponseBody
  public Long createTodo(@RequestBody String todo) {
    return todoService.create(todo);
  }

  @GetMapping("todos/{id}")
  @ResponseBody
  public Optional<String> findTodoById(@PathVariable("id") Long id) {
    return todoService.findById(id);
  }

  @GetMapping("todos/search")
  @ResponseBody
  public Optional<String> findTodoByValue(@RequestParam("value") String value) {
    return todoService.findByValue(value);
  }

  @GetMapping("todos")
  @ResponseBody
  public Map<Long, String> getAllTodos() {
    return todoService.findAll();
  }

  @PutMapping("todos")
  @ResponseBody
  public Long editTodoById(@RequestParam("id") Long id, @RequestParam("value") String value) {
    return todoService.editById(id, value);
  }

  @DeleteMapping("todos")
  @ResponseBody
  public Long deleteTodoById(@RequestParam("id") Long id) {
    return todoService.deleteById(id);
  }
}

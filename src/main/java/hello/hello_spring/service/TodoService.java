package hello.hello_spring.service;

import hello.hello_spring.repository.TodoRepository;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private final TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Long create(String todo) {
    return todoRepository.create(todo);
  }

  public Optional<String> findById(Long id) {
    return todoRepository.findById(id);
  }

  public Optional<String> findByValue(String value) {
    return todoRepository.findByValue(value);
  }

  public Map<Long, String> findAll() {
    return todoRepository.findAll();
  }

  public Long editById(Long id, String value) {
    return todoRepository.editById(id, value);
  }

  public Long deleteById(Long id) {
    return todoRepository.deleteById(id);
  }
}

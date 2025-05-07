package hello.hello_spring.repository;

import java.util.Map;
import java.util.Optional;

public interface TodoRepository {
  Long create(String todo);

  Optional<String> findById(Long id);

  Optional<String> findByValue(String value);

  Map<Long, String> findAll();

  Long editById(Long id, String value);

  Long deleteById(Long id);
}

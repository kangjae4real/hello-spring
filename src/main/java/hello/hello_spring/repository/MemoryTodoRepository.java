package hello.hello_spring.repository;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryTodoRepository implements TodoRepository {
  private static Map<Long, String> store = new HashMap();
  private static long sequence = 0L;

  @Override
  public Long create(String todo) {
    long index = ++sequence;
    store.put(index, todo);
    return index;
  }

  @Override
  public Optional<String> findById(Long id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public Optional<String> findByValue(String value) {
    return store.values().stream().filter(t -> t.equals(value)).findAny();
  }

  @Override
  public Map<Long, String> findAll() {
    return store;
  }

  @Override
  public Long editById(Long id, String value) {
    // 검증 로직이 있으면 좋겠음.
    store.put(id, value);
    return id;
  }

  @Override
  public Long deleteById(Long id) {
    // 검증 로직이 있으면 좋겠음.
    store.remove(id);
    return id;
  }
}

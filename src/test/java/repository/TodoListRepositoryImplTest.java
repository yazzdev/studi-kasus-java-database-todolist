package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodoListRepositoryImplTest {

  private HikariDataSource dataSource;

  private TodoListRepository todoListRepository;

  @BeforeEach
  void setUp() {
    dataSource = DatabaseUtil.getDataSource();
    todoListRepository = new TodoListRepositoryImpl(dataSource);
  }

  @Test
  void testAdd() {
    Todolist todolist = new Todolist();
    todolist.setTodo("Belajar Java Database 2");

    todoListRepository.add(todolist);
  }

  @Test
  void testRemove() {
    System.out.println(todoListRepository.remove(1));
    System.out.println(todoListRepository.remove(2));
    System.out.println(todoListRepository.remove(3));
    System.out.println(todoListRepository.remove(4));
  }

  @Test
  void testGetAll() {
    // add
    todoListRepository.add(new Todolist("Dyaz"));
    todoListRepository.add(new Todolist("Amrullah"));
    todoListRepository.add(new Todolist("Belajar"));
    todoListRepository.add(new Todolist("Java Database"));
    todoListRepository.add(new Todolist("Studi Kasus"));

    // show
    System.out.println("id | todo list");
    Todolist[] todolists = todoListRepository.getAll();
    for (var todo : todolists) {
      System.out.println(todo.getId() + " : " + todo.getTodo());
    }
  }

  @AfterEach
  void tearDown() {
    dataSource.close();
  }
}

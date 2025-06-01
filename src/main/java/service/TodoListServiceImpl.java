package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

  private TodoListRepository todoListRepository;

  public TodoListServiceImpl(TodoListRepository todoListRepository) {
    this.todoListRepository = todoListRepository;
  }

  @Override
  public void showTodoList() {
    Todolist[] model = todoListRepository.getAll();

    System.out.println("----------------");
    System.out.println(">>> TODOLIST <<<");
    for(var todo : model){
      System.out.println(todo.getId() + " : " + todo.getTodo());
    }
  }

  @Override
  public void addTodoList(String todo) {
    Todolist todolist = new Todolist(todo);
    todoListRepository.add(todolist);

    System.out.println("SUKSES Menambah Todo : " + todo);
  }

  @Override
  public void removeTodoList(Integer number) {
    boolean success = todoListRepository.remove(number);

    if (success) {
      System.out.println("SUKSES menghapus todo : " + number);
    } else {
      System.out.println("GAGAL menghapus todo : " + number);
    }
  }
}

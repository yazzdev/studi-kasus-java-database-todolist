package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

  private TodoListService todoListService;

  public TodoListView(TodoListService todoListService) {
    this.todoListService = todoListService;
  }

  public void showTodoList(){
    while (true) {
      todoListService.showTodoList();

      System.out.println("Menu");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("x. Keluar");

      var input = InputUtil.input("Pilih");

      if (input.equals("1")) {
        addTodoList();
      } else if (input.equals("2")) {
        removeTodoList();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Pilihan tidak sesuai");
      }
    }
  }

  public void addTodoList(){
    System.out.println(">> ADD TODO <<");

    var todo = InputUtil.input("Todo (x for cancel)");

    if (todo.equals("x")) {
      // batal
    } else {
      todoListService.addTodoList(todo);
    }
  }

  public void removeTodoList(){
    System.out.println(">> REMOVE TODO <<");

    var number = InputUtil.input("Todo (x for cancel)");

    if (number.equals("x")) {
      // batal
    } else {
      todoListService.removeTodoList(Integer.valueOf(number));
    }
  }

}

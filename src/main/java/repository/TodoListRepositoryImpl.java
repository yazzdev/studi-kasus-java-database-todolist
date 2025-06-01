package repository;

import entity.Todolist;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoListRepositoryImpl implements TodoListRepository {

  public Todolist[] data = new Todolist[10];

  private DataSource dataSource;

  public TodoListRepositoryImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Todolist[] getAll() {
    return data;
  }

  public boolean isFull() {
    // Cek apakah model penuh?
    var isFull = true;
    for (var i = 0; i < data.length; i++) {
      if (data[i] == null) {
        // Model masih ada yang kosong
        isFull = false;
        break;
      }
    }
    return isFull;
  }

  public void resizeIfFull() {
    // Jika penuh, resize ukuran array menjadi 2x lipat
    if (isFull()) {
      var temp = data;
      data = new Todolist[data.length * 2];

      for (var i = 0; i < temp.length; i++) {
        data[i] = temp[i];
      }
    }
  }

  @Override
  public void add(Todolist todolist) {
    String sql = "INSERT INTO todolist(todo) VALUES (?)";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

      statement.setString(1, todolist.getTodo());
      statement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private boolean isExists(Integer number){
    String sql = "SELECT * FROM todolist WHERE id = ?";
    try (Connection connection = dataSource.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, number);

      try(ResultSet resultSet = statement.executeQuery()){
        if (resultSet.next()){
          return true;
        } else {
          return false;
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public boolean remove(Integer number) {
    if (isExists()){
      String sql = "DELETE FROM todolist WHERE id = ?";
      // Try with resource (Biar auto close)
      try (Connection connection = dataSource.getConnection();
           PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, number);
        statement.executeUpdate();

        return true;
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    } else {
      return false;
    }
  }
}

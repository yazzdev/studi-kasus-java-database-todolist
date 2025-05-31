package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

  private static HikariDataSource hikariDataSource;

  static {
    HikariConfig configuration = new HikariConfig();
    configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");
    configuration.setUsername("root");
    configuration.setPassword("");
    configuration.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_todolist");

    // pool
    configuration.setMaximumPoolSize(10);
    configuration.setMinimumIdle(5);
    configuration.setIdleTimeout(60_000); // 1 menit
    configuration.setMaxLifetime(60 * 60 * 1000); // 1 jam

    hikariDataSource = new HikariDataSource(configuration);
  }

  public static HikariDataSource getDataSource(){
    return hikariDataSource;
  }

}

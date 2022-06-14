package com.company.Reflection_Annotation_SQL_9.SQL;

import java.sql.*;

public class SQL_MainApp {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement; //чтобы не возникло SQL инъекций


    public static void main(String[] args) throws Exception{
        try {
            connect();
            clearTableEx();
            /*
            Если вдруг понадобилось десктопное приложение, если пользователь вводит например id и она попадает
            в SQL запрос, то может возникнуть SQL injection.
            SELECT score FROM students WHERE id = <<то что вводит пользователь>> 1; DROP TABLE
            то запрос по селекту преобразуется в селект + дроп тейбл
            */
            for (int i = 0; i < 10; i++) {
                preparedStatement.setString(1,  "Bob" + (i + 1)); //установка имени
                preparedStatement.setInt(2,  50); //установка баллов
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

     private static void updateEx() throws SQLException {
        // обновление строки таблицы
         statement.executeUpdate("UPDATE students SET score = 75 WHERE id = 1;");

     }

     private static void dropTableEx() throws SQLException {
        //Удаляет таблицу из базы данных, указанной в источнике.
        statement.executeUpdate("DROP TABLE students");
     }


     private static void deleteEx() throws SQLException {
         // удаление строки
        statement.executeUpdate("DELETE FROM students WHERE id = 4");
     }

     private static void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM students");
     }

     private static void selectEx() {
         //чтение из бд
         try {
             ResultSet rs = statement.executeQuery("SELECT * FROM students");
             while (rs.next()) {
                 System.out.println(
                         rs.getInt(1) //индексация строк с 1
                                 + " " + rs.getString("name")
                                 + " " + rs.getInt("score")
                 );
             } // если мы запрашиваем данные столбца с помощью getInt, а в бд в столбце строка
             // то результат будет зависеть от драйвера, инт может быть откастовано в строку, а может быть исключение
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public static void insertEx() throws SQLException{
         //отправляем запрос в базу
         statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob4', 80);");
    }

    //подключаемся к БД
    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db"); //если база данных на каком-то порту,
                                                                                // то она указывается, если нужен логин,
                                                                                 // то указывается через запятую
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO students (name, score VALUES (?, ?);"); //запрос проходит при компиляции и ничего другого в него не добавится
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    //отключаемся от БД
    public static void disconnect() {
        // рекомендуется сначала закрывать statement, а потом connection, нужно закрывать в разных try/catch
        try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}

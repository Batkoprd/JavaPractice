package com.company.Reflection_Annotation_SQL_9.SQL;

import java.sql.*;

public class SQL_MainApp {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement; //чтобы не возникло SQL инъекций

    /*
    App -> JDBC -> Driver -> SQLite/PostgreSQL - с базами данных мы работаем с помощью интерфейсов, поэтому не создаем объектов
    */

    public static void main(String[] args) throws Exception{
        try {
            connect();


        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void rollbackEx() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 90)");
        Savepoint sp1 = connection.setSavepoint(); // сейвпоинт, запоминает на этом этапе состояние таблицы
        // если включен автокоммит, то мы не сможем откатывать изменения, сейвпоинт работает в пределах одной транзакции
        // когда мы создали сейвпоинт автокоммит выключается, поэтому без включения коммита записи после сейвпоинта не добавятся
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 80)");
        connection.rollback(sp1); // откатили таблицу к сейвпоинту
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 70)");
        connection.commit(); // когда мы сделали коммит все сейвпоинты на автомате вычищаются
    }

     private static void transactionAndPreparedStatement() throws SQLException {
         long time = System.currentTimeMillis();
         connection.setAutoCommit(false); //выключаем автокоммит, чтобы каждый запрос не заворачивался в транзакцию
            /*
            Если вдруг понадобилось десктопное приложение, если пользователь вводит например id и она попадает
            в SQL запрос, то может возникнуть SQL injection.
            SELECT score FROM students WHERE id = <<то что вводит пользователь>> 1; DROP TABLE
            то запрос по селекту преобразуется в селект + дроп тейбл
            */
         for (int i = 0; i < 10000 ; i++) {
             //10000 добавлений 72 секунды, connection.setAutoCommit(false) чтобы ускорить
             preparedStatement.setString(1,  "Bob" + (i + 1)); //установка имени
             preparedStatement.setInt(2,  50); //установка баллов
             // preparedStatement.setObject(); если не знаете какой тип у столбца в бд
//             preparedStatement.executeUpdate();
             preparedStatement.addBatch(); // копим пакет запросов
         }
         preparedStatement.executeBatch(); // возвращает массив интов, сколько каждый отдельный запрос поменял строк
         connection.commit(); // включаем коммит, чтобы завершить одну транзакцию -> 10000 запросов за одну транзакцию
         System.out.println(System.currentTimeMillis() - time);
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
            preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);"); //запрос проходит при компиляции и ничего другого в него не добавится
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    //отключаемся от БД
    public static void disconnect() {
        // рекомендуется сначала закрывать statement, а потом connection, нужно закрывать в разных try/catch
        try {
            statement.close();
            preparedStatement.close();
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

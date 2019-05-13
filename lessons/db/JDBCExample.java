package db;

import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        createTable();
//        insertIntoBook("Книга 1", 345);
//        insertIntoBook("Книга 2", 123);
//        insertIntoBook("Книга 3", 67);
//        insertIntoBook("Книга 4", 12);
//        insertIntoBook("Книга 5", 89);

        selectAll();

    }

    public static void createTable() throws ClassNotFoundException, SQLException {

        String sqlCreate = "\n" +
                "CREATE TABLE IF NOT EXISTS Book (\n" +
                "\tid SERIAL PRIMARY KEY,\n" +
                "\ttitle TEXT NOT NULL,\n" +
                "\tpageCount INTEGER NOT NULL\n" +
                ");\n;";

        // регистрируем драйвера
        Class.forName("org.postgresql.Driver");


        // выполняем подключение
        try (Connection connection = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/exampleDB", "matveevkp", "12345678")) {

            try (Statement statement = connection.createStatement()) {

                int res = statement.executeUpdate(sqlCreate);

                System.out.println(res);


//                statement.executeUpdate(); // изменяет данные (возвращает кол-во измененых строк
//                statement.executeQuery(); // когда обращаемся в бд за данными

            }

        }

    }

    public static void insertIntoBook(String title, int pageCount) throws SQLException, ClassNotFoundException {

        String sqlInsert = "INSERT INTO Book (title, pageCount) VALUES (? , ?);";

        // регистрируем драйвера
        Class.forName("org.postgresql.Driver");


        // выполняем подключение
        try (Connection connection = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/exampleDB", "matveevkp", "12345678")) {

            try (PreparedStatement statement = connection.prepareStatement(sqlInsert)) {

                statement.setString(1, title);
                statement.setInt(2, pageCount);

                int res = statement.executeUpdate();

                System.out.println(res);
            }

        }

    }


    public static void selectAll() throws ClassNotFoundException, SQLException {
        String sqlSelectAll = "SELECT * from Book";


        // регистрируем драйвера
        Class.forName("org.postgresql.Driver");


        // выполняем подключение
        try (Connection connection = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/exampleDB", "matveevkp", "12345678")) {

            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery(sqlSelectAll);

                while (resultSet.next()) {

                    String title = resultSet.getString("title");
                    int id = resultSet.getInt("id");
                    int pageCount = resultSet.getInt("pageCount");

                    System.out.println("id: " + id + " title: " + title + " pageCount: " + pageCount);

                }

                resultSet.close();
            }

        }
    }

}

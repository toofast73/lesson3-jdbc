package lesson1;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseExample {


    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            DataSource dataSource = createDataSource();
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM cat");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cat cat = new Cat();

                cat.setId(resultSet.getLong("id"));
                cat.setName(resultSet.getString("name"));
                cat.setAge(resultSet.getLong("age"));

                cats.add(cat);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println(cats);

    }


    private static DataSource createDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("yuri");
        dataSource.setPassword("pass");
        dataSource.setUrl("jdbc:mysql://localhost:3306/geekbrains");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }

}

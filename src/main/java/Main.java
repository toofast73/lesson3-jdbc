import com.mysql.cj.jdbc.MysqlDataSource;
import lesson1.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            MysqlDataSource dataSource = createDataSource();
            long start = System.currentTimeMillis();
            connection = dataSource.getConnection();

            for (int i = 50000; i < 60000; i++) {
                statement = connection.createStatement();
                statement.addBatch(String.format("INSERT INTO geekbrains.user VALUE (%s, 'Ivan', 'Ivan@gmail.com')", i));
            }
            statement.executeBatch();
            System.out.println(System.currentTimeMillis() - start);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static MysqlDataSource createDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("yuri");
        dataSource.setPassword("pass");
        dataSource.setUrl("jdbc:mysql://localhost:3306");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }

}

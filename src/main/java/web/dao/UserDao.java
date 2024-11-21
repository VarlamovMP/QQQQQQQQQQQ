package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDao {

//    private List<User> users;
//    private static int USER_COUNT;
//
//    {
//        users = new ArrayList<>();
//        users.add(new User(++USER_COUNT, "Aleksey", "Aleksey@mail.ru"));
//        users.add(new User(++USER_COUNT, "Donald", "Trampampam@mail.ru"));
//        users.add(new User(++USER_COUNT, "Tom", "Tom@mail.ru"));
//        users.add(new User(++USER_COUNT, "Vova", "Putin@mail.ru"));
//        users.add(new User(++USER_COUNT, "Dima", "Medved@mail.ru"));
//
//    }

    private static final String URL = "jdbc:mysql://localhost:3306/db231";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Root";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> index() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM User";
        ResultSet resultSet = statement.executeQuery(SQL);

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));

            users.add(user);
        }
        return users;

    }

    public User show(int id) throws SQLException {
        User user = null;

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM User WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }

    public void save(User user) throws SQLException {
        String SQL = "INSERT INTO User (name, email) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.executeUpdate();
    }

    public void update(int id, User updateUser) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE User SET name=?, email=? WHERE id=?");
            preparedStatement.setString(1, updateUser.getName());
            preparedStatement.setString(2, updateUser.getEmail());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM User WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

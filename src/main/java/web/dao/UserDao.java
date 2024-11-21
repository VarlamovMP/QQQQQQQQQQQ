package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM User",
                new BeanPropertyRowMapper<>(User.class));
    }

    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM User WHERE id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO User (name, email) VALUES (?, ?)",
                user.getName(), user.getEmail());
    }

    public void update(int id, User updatedUser) {
//        jdbcTemplate.update("UPDATE User SET name=?, email=? WHERE id=?", updatedUser.getName(),
//                updatedUser.getEmail());
        jdbcTemplate.update("UPDATE User SET name=?, email=? WHERE id=?", updatedUser.getName(),
                updatedUser.getEmail(), id);
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM User WHERE id=?", id);
    }

}

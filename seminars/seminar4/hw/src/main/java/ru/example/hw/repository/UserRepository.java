//
//package ru.example.hw.repository;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import ru.example.hw.controller.UserMapper;
//import ru.example.hw.model.User;
//
//import java.util.List;
//
//
//@Repository
//public class UserRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//    private final UserMapper userMapper;
//
//    public UserRepository(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.userMapper = userMapper;
//    }
//
//    public List<User> findAll() {
//        String sql = "SELECT * FROM users";
//        return jdbcTemplate.query(sql, userMapper);
//    }
//
//    public User findById(int id) {
//        String sql = "SELECT * FROM users WHERE id = ?";
//        return (User) jdbcTemplate.queryForObject(sql, userMapper, id);
//    }
//
//    public void save(User user) {
//        String sql = "INSERT INTO users (name, age, email) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
//    }
//}
//
//

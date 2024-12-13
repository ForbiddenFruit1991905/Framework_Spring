//package ru.example.hw.controller;
//
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//import ru.example.hw.model.User;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
///
//
//@Component
//public class UserMapper implements RowMapper {
//@Override
//public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//    User user = new User();
//    user.setId(rs.getInt("id"));
//    user.setName(rs.getString("name"));
//    user.setAge(rs.getInt("age"));
//    user.setEmail(rs.getString("email"));
//    return user;
//}
//}

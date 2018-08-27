package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<User> findByUsername(String username) { // USE FOR USER LOGIN
//        try {
//            String query = "SELECT * FROM users WHERE username = ?";
//
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, user.get);
//            ResultSet rs = ps.executeQuery();
//
//            List<User> newList = new ArrayList<>();
//            while(rs.next()) {
//                newList.add(new User(
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4)
//                ));
//            }
//            return newList;
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all users.", e);
//        }
    return null;

    }

    @Override
    public Long insert(User user) {
        try {
            String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
            ResultSet genIdResult = ps.getGeneratedKeys();

            genIdResult.next();
            return genIdResult.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

}

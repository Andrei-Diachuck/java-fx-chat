package com.example.javafxchat.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlNewUserName extends SqlDataBuse implements UserNameService {
    @Override
    public void updateUserName(String login, String newUserName) {
        Connection connection = getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("""
                    update auth
                    set username = ?
                    where login = ?
                    """);
            stmt.setString(1, newUserName);
            stmt.setString(2, login);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка изменение ника " + login + e.getMessage());
        }
    }
}

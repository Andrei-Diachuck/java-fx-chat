package com.example.javafxchat.server;

import java.io.IOException;
import java.net.ConnectException;
import java.nio.channels.ConnectionPendingException;
import java.sql.*;

public class SqlAuthServer extends SqlDataBuse implements AuthService {
    
    
    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("select username from auth where login = ? and password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);
            
            ResultSet resultSet = stmt.executeQuery();
    
            return resultSet.getString(1);
        } catch (SQLException e) {
            System.out.println("Не получл username: " + e.getMessage());
            return null;
        }
    }
    
}

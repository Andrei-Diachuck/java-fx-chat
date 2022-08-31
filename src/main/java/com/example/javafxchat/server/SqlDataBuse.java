package com.example.javafxchat.server;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDataBuse implements Closeable {
    public static final String DB_PATH = "src\\main\\resources\\com\\example\\javafxchat\\server\\db\\database.db";
    
    final Connection connection;
    
    
    public SqlDataBuse() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }
    
    protected Connection getConnection(){
        return connection;
    }
    
    @Override
    public void close() throws IOException {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

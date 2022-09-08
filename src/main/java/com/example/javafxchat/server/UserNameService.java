package com.example.javafxchat.server;

import java.io.Closeable;

public interface UserNameService extends Closeable {
    void updateUserName(String login, String newUserName);
}

package com.raskae.examples.acheronjavasqlite.data.remote;

import com.raskae.examples.acheronjavasqlite.data.model.User;

/**
 * Created by Raskae on 24/08/2017.
 */

public interface UserDBFunctions {

    void insertUser(String username, String password, String email);
    void deleteUser(int id);
    void deleteUser(User user);
    void updateUser(User user);
    void selectUserByEmail(String email);
    void listUsers();

}
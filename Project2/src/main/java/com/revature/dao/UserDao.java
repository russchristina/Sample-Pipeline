package com.revature.dao;

import java.util.List;
import com.revature.beans.User;
import com.revature.beans.Role;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
    public List<User> getUsersByRole(Role r);
    public void insertUser(User u);
    public void updateUser(User u);
    public void deleteUser(User u);
}
package com.revature.service;

import java.util.List;

import com.revature.beans.Role;
import com.revature.beans.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public boolean getUserByUsername(String username);
	public List<User> getUsersByRole(Role r);
	public void insertUser(User u);
	public void updateUser(User u);
	public void deleteUser(User u);
}

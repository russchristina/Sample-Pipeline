package com.revature.serviceimpl;

import java.util.List;

import com.revature.beans.Role;
import com.revature.beans.User;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public List<User> getAllUsers() {
		return new UserDaoImpl().getAllUsers();
	}

	@Override
	public User getUserById(int id) {
		return new UserDaoImpl().getUserById(id);
	}

	@Override
	public List<User> getUsersByRole(Role r) {
		return new UserDaoImpl().getUsersByRole(r);
	}
	
	//Do you want to rework this to include the HttpRequest and Response objects?
	@Override
	public boolean getUserByUsername(String username) {
		
		
		
		return false;
	}

	@Override
	public void insertUser(User u) {
		new UserDaoImpl().insertUser(u);
		
	}

	@Override
	public void updateUser(User u) {
		new UserDaoImpl().updateUser(u);
		
	}

	@Override
	public void deleteUser(User u) {
		new UserDaoImpl().deleteUser(u);
	}

}

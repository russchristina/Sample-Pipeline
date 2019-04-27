package com.revature.service;

import java.util.List;

import com.revature.beans.Role;

public interface RoleService {
	public List<Role> getAllRoles();
	public Role getRoleById(int id);
	public void insertRole(Role r);
	public void updateRole(Role r);
	public void deleteRole(Role r);
}

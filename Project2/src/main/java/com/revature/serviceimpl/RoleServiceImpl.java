package com.revature.serviceimpl;

import java.util.List;

import com.revature.beans.Role;
import com.revature.daoimpl.RoleDaoImpl;
import com.revature.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Override
	public List<Role> getAllRoles() {
		return new RoleDaoImpl().getAllRoles();
	}

	@Override
	public Role getRoleById(int id) {
		return new RoleDaoImpl().getRoleById(id);
	}

	@Override
	public void insertRole(Role r) {
		new RoleDaoImpl().insertRole(r);
		
	}

	@Override
	public void updateRole(Role r) {
		new RoleDaoImpl().updateRole(r);
		
	}

	@Override
	public void deleteRole(Role r) {
		new RoleDaoImpl().deleteRole(r);
		
	}

}

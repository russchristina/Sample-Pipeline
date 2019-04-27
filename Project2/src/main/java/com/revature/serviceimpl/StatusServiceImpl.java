package com.revature.serviceimpl;

import java.util.List;

import com.revature.beans.Status;
import com.revature.daoimpl.StatusDaoImpl;
import com.revature.service.StatusService;

public class StatusServiceImpl implements StatusService{

	@Override
	public List<Status> getAllStatuses() {
		return new StatusDaoImpl().getAllStatuses();
	}

	@Override
	public Status getStatusById(int id) {
		return new StatusDaoImpl().getStatusById(id);
	}

	@Override
	public void insertStatus(Status s) {
		new StatusDaoImpl().insertStatus(s);
		
	}

	@Override
	public void updateStatus(Status s) {
		new StatusDaoImpl().updateStatus(s);
		
	}

	@Override
	public void deleteStatus(Status s) {
		new StatusDaoImpl().deleteStatus(s);
		
	}

}

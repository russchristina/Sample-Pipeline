package com.revature.dao;

import java.util.List;
import com.revature.beans.Status;

public interface StatusDao {
    public List<Status> getAllStatuses();
    public Status getStatusById(int id);
    public void insertStatus(Status s);
    public void updateStatus(Status s);
    public void deleteStatus(Status s);
}
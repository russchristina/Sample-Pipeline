package com.revature.dao;

import java.util.List;
import com.revature.beans.UserJokeJt;
import com.revature.beans.User;
import com.revature.beans.Joke;

public interface UserJokeJtDao {
    public List<UserJokeJt> getAllUserJokeJt();
    public UserJokeJt getUserJokeJtById(int id);
    public List<UserJokeJt> getUserJokeJtByUser(User u);
    public List<UserJokeJt> getUserJokeJtByJoke(Joke j);
    public void insertUserJokeJt(UserJokeJt uj);
    public void updateUserJokeJt(UserJokeJt uj);
    public void deleteUserJokeJt(UserJokeJt uj);
}
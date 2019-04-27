package com.revature.dao;

import java.util.List;
import com.revature.beans.Joke;
import com.revature.beans.Category;
import com.revature.beans.User;
import com.revature.beans.Status;

public interface JokeDao {
    public List<Joke> getAllJokes();
    public Joke getJokeById(int id);
    public List<Joke> getJokesByCategory(Category c);
    public List<Joke> getJokesByUser(User u);
    public List<Joke> getJokesByStatus(Status s);
    public void insertJoke(Joke j);
    public void updateJoke(Joke j);
    public void deleteJoke(Joke j);
}
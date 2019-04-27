package com.revature.serviceimpl;

import java.util.List;

import com.revature.beans.Category;
import com.revature.beans.Joke;
import com.revature.beans.Status;
import com.revature.beans.User;
import com.revature.daoimpl.JokeDaoImpl;
import com.revature.service.JokeService;

public class JokeServiceImpl implements JokeService{

	@Override
	public List<Joke> getAllJokes() {
		return new JokeDaoImpl().getAllJokes();
	}

	@Override
	public Joke getJokeById(int id) {
		return new JokeDaoImpl().getJokeById(id);
	}

	@Override
	public List<Joke> getJokesByCategory(Category c) {
		return new JokeDaoImpl().getJokesByCategory(c);
	}

	@Override
	public List<Joke> getJokesByUser(User u) {
		return new JokeDaoImpl().getJokesByUser(u);
	}

	@Override
	public List<Joke> getJokesByStatus(Status s) {
		return new JokeDaoImpl().getJokesByStatus(s);
	}

	@Override
	public void insertJoke(Joke j) {
		new JokeDaoImpl().insertJoke(j);
		
	}

	@Override
	public void updateJoke(Joke j) {
		new JokeDaoImpl().updateJoke(j);
		
	}

	@Override
	public void deleteJoke(Joke j) {
		new JokeDaoImpl().deleteJoke(j);
		
	}

}

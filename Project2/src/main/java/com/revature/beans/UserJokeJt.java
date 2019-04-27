package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//Change this class; essentially use the @JoinTable annotation to create your join table instead of explicitly creating a class for this nonsense.
@Entity
@Table(name="user_joke_jt")
public class UserJokeJt {
    @Id
    @Column(name="user_joke_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_joke_seq")
    @SequenceGenerator(name="user_joke_seq", allocationSize=1)
    private int id;
    @Column(name="user_id")
    private int userId;
    @Column(name="joke_id")
    private int jokeId;

    public UserJokeJt(){
        super();
    }

    public UserJokeJt(int id, int userId, int jokeId){
        this.id = id;
        this.userId = userId;
        this.jokeId = jokeId;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getJokeId(){
        return jokeId;
    }

    public void setJokeId(int jokeId){
        this.jokeId = jokeId;
    }
}
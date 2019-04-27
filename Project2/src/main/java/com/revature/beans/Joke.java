package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="joke")
public class Joke {
    @Id
    @Column(name="joke_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="joke_seq")
    @SequenceGenerator(name="joke_seq", allocationSize=1)
    private int id;
    @Column(name="content")
    private String content;
    @JoinColumn(name="category_id")
    private Category category;
    @JoinColumn(name="user_id")
    private User user;
    @JoinColumn(name="status_id")
    private Status status;
    @Column(name="favorites")
    private int favorites;

    public Joke(){
        super();
    }

    public Joke(int id, String content, Category category, User user, Status status, int favorites){
        this.id = id;
        this.content = content;
        this.category = category;
        this.user = user;
        this.status = status;
        this.favorites = favorites;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public int getFavorites(){
        return favorites;
    }

    public void setFavorities(int favorites){
        this.favorites = favorites;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + favorites;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joke other = (Joke) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (favorites != other.favorites)
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Joke [id=" + id + ", content=" + content + ", category=" + category + ", user=" + user + ", status="
				+ status + ", favorites=" + favorites + "]";
	}
    
}
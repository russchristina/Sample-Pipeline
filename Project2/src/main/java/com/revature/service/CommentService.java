package com.revature.service;

import java.util.List;
import java.sql.Date;
import com.revature.beans.Comment;
import com.revature.beans.Joke;
import com.revature.beans.User;

public interface CommentService {
    public List<Comment> getAllComments();
    public Comment getCommentById(int id);
    public List<Comment> getCommentsByJoke(Joke j);
    public List<Comment> getCommentsByUser(User u);
    public List<Comment> getCommentsByDate(Date d);
    public void insertComment(Comment c);
    public void updateComment(Comment c);
    public void deleteComment(Comment c);
}
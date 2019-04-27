package com.revature.serviceimpl;

import java.sql.Date;
import java.util.List;

import com.revature.beans.Comment;
import com.revature.beans.Joke;
import com.revature.beans.User;
import com.revature.daoimpl.CommentDaoImpl;
import com.revature.service.CommentService;

public class CommentServiceImpl implements CommentService {

    @Override
    public List<Comment> getAllComments() {
        return new CommentDaoImpl().getAllComments();
    }

    @Override
    public Comment getCommentById(int id) {
        return new CommentDaoImpl().getCommentById(id);
    }

    @Override
    public List<Comment> getCommentsByJoke(Joke j) {
        return new CommentDaoImpl().getCommentsByJoke(j);
    }

    @Override
    public List<Comment> getCommentsByUser(User u) {
        return new CommentDaoImpl().getCommentsByUser(u);
    }

    @Override
    public List<Comment> getCommentsByDate(Date d) {
        return new CommentDaoImpl().getCommentsByDate(d);
    }

    @Override
    public void insertComment(Comment c) {
        new CommentDaoImpl().insertComment(c);
    }

    @Override
    public void updateComment(Comment c) {
        new CommentDaoImpl().updateComment(c);
    }

    @Override
    public void deleteComment(Comment c) {
        new CommentDaoImpl().deleteComment(c);
    }
}
package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.serviceimpl.CategoryServiceImpl;
import com.revature.serviceimpl.CommentServiceImpl;
import com.revature.serviceimpl.JokeServiceImpl;
import com.revature.serviceimpl.RoleServiceImpl;

public class Dispatcher {

    private static final Logger LOGGY = LogManager.getLogger(Dispatcher.class);

    public Object processGet(HttpServletRequest request, HttpServletResponse response){
        //Let us first get the URI of the request
        final String URI = request.getRequestURI().replace("Project2/api", "");

        LOGGY.debug("The dispatcher class has been hit, and the parsed URI is: " + URI);

        switch (URI){
            case "/category":
                return new CategoryServiceImpl().getAllCategories();
            case "/comment":
                return new CommentServiceImpl().getAllComments();
            case "/joke":
            	return new JokeServiceImpl().getAllJokes();
            case "/role":
            	return new RoleServiceImpl().getAllRoles();
            default:
                //Find a more memory efficient way to do this. You don't need to create a new String since Java isn't optimized to handle strings that are created in this way well.
                return new String("No such endpoint exists on the server!");
        }
    }
}
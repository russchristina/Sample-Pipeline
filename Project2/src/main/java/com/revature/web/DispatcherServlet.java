package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger deLog = LogManager.getLogger(DispatcherServlet.class);
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	deLog.debug("The dispatcher servlet has been hit!");
        response.setContentType("application/json");
        response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(new Dispatcher().processGet(request, response)));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {

    }
}
package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {
	
	private static String[] dbProps = System.getenv("peppermintpattiesfrankburgersRDS").split(";");
	//I'm configuring my credentials in this class because I want to obscure them by pulling
	//from my environment variables.
    private static SessionFactory sessionFactory = new Configuration()
    		.configure()
    		.setProperty("hibernate.connection.url", dbProps[0])
    		.setProperty("hibernate.connection.username", dbProps[1])
    		.setProperty("hibernate.connection.password", dbProps[2])
    		.buildSessionFactory();

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
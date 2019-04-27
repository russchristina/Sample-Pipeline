package com.revature.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	private static final Logger logMe = LogManager.getLogger(Driver.class);
	public static void main(String[] args) {
		
		logMe.error("My log file is working properly.");
	}
}

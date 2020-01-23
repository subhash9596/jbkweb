package com.jbk.owu.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j  {
	
	public static Logger logger = LogManager.getLogger(Log4j.class);
	
	public static void main(String[] args) {
		
		logger.info("This is the simple messge");
		logger.warn("This is warn messgae");
		logger.error("Logger errormessage ");
		
	}
	
}


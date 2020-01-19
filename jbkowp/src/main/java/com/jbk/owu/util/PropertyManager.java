package com.jbk.owu.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.jbk.owp.base.TestBase;

public class PropertyManager extends TestBase {

	private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\test\\resources\\configuration.properties";
    private static String qaurl;
    private static String uaturl;
    private static String username;
    private static String password;
    private static String browser;
    private static String environment;
    private static String project;
    private static String email;
    private static String suite;

    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }
    
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        //Get properties from configuration.properties
        qaurl = prop.getProperty("qaurl");
        uaturl = prop.getProperty("uaturl");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        browser = prop.getProperty("bwowser");
        environment = prop.getProperty("environment");
        project = prop.getProperty("project");
        email = prop.getProperty("email");
        suite = prop.getProperty("suite");
    }

	public static String getQaurl() {
		return qaurl;
	}
	
	public static String getUaturl() {
		return uaturl;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
	
	public String getBrowser() {
		return browser;
	}
	
	public static String getEnvironment() {
		return environment;
	}
	
	public static String getProject() {
		return project;
	}
	
	public static String getEmail() {
		return email;
	}
	
	public static String getSuite() {
		return suite;
	}
 
    }
    
   


package com.jbk.owu.util;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import com.jbk.owp.base.TestBase;

public class Screenshot extends TestBase{	
	
	private static String path = currentDir + "\\Reports\\" + timeStamp +"\\_OWUReport\\Screenshots\\";
		
	public static String getScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination=path+name+"_Fail.png";
		//String destination=currentDir + "\\Reports\\" + timeStamp +"\\_OwpReport\\"+name+"_Fail.png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
//	public static void CreateDirectory(String DirectoryName)
//	{
//		//project directory
//		String  dir = DirectoryName;
//		
//		//create a directory in the path
//		File file = new File(dir);
//
//		if (!file.exists()) {
//			file.mkdir();
//		} else {
//			System.out.println("Directory is already exist!");
//		}
//	}
//
//}

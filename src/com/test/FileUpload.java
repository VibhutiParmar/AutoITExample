package com.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "/Users/vivek/Downloads/chromedriver_mac64 (1)/chromedriver");
		
		HashMap<String, Object> chromeprefs = new HashMap<String, Object>(); 
		chromeprefs.put("profile.default_content_settings.popups", 0);
		chromeprefs.put("download.default_directory", path);
		
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromeprefs);
		WebDriver driver = new ChromeDriver(options);
	
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("/Users/vivek/Desktop/Vibhuti/Vibhuti's Dell Backup/Zip Files/FileUpload.exe");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		driver.findElement(By.id("processTask")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		File f = new File(path + "/IMG-6357.jpg");
		if(f.exists()) {
			Assert.isTrue(f.exists());
			//Assert.assertTrue(f.exists());
			if(f.delete()) {
				System.out.println("File Deleted");
			}
		}
	

	}

}

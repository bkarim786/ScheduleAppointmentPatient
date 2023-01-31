package org.mmpPractise.util;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import patientModulePractise.Pages.UrlLaunchClass;

public class BaseClassPractise {
	//Launch browser (chrome, edge) and sends url to urlLaunch class
	protected WebDriver driver;
	protected Properties pro;
	@BeforeClass
	public void instantiateDriver() throws IOException {
		PropertiesClass pp = new PropertiesClass();
		pro = pp.loadProperties();
		if(pro.getProperty("browserType").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		if(pro.getProperty("browserType").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			}
		UrlLaunchClass uLaunch = new UrlLaunchClass(driver);
		uLaunch.launchBrowser(pro.getProperty("patientURL"));
		
		}
}

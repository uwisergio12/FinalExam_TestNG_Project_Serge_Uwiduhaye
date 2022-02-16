package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	static String browser;
	static String url;
	
	public static void readConfig() {
		
		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			System.out.println("Browser used: " + browser);

		} catch (IOException e) {
			e.getStackTrace();
		}

	}
	
	public static WebDriver init() {
		
		readConfig();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
	 
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(" http://techfios.com/test/101/");
		return driver;
	}

	public static void teardown() {
		driver.close();
//		driver.quit();
	}
	
	
}

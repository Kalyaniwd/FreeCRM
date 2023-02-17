package com.crm.qa.base;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.safari.SafariDriver;


	public class TestBase {

		public static WebDriver driver;
		public static Properties prop;
		//public static EventFiringWebDriver e_driver;
		//public static WebEventListener eventListener;

		public TestBase() {
			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "/home/prashant/eclipse-workspace/CRMTest/src/main/java/com/crm/qa/base/TestBase.java");
				prop.load(fis);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find file ");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Unable to find properties file");
				e.printStackTrace();
			}
		}

		public static void initialization() {
			
			
			String browserName = prop.getProperty("browser");
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver(ops);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
			
//			e_driver = new EventFiringWebDriver(driver);
//			eventListener = new WebEventListener();
//			e_driver.register(eventListener);
//			driver= e_driver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(prop.getProperty("url"));
			
			
		}
	}



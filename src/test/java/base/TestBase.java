package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




public abstract class TestBase {
	public static Properties env=null;
	public static Properties config=null;
	public static Properties data=null;
	private static boolean isInitalized=false;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	protected TestBase() {
		if(!isInitalized){
			initDriver();
		}
	}
	private static void initDriver(){

		
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			options.addArguments("--start-maximized");
			options.addArguments("--lang=es");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
		}
	
	
	@AfterSuite
	public void tearDown() {
		quitDriver();
	}
	
	public static void quitDriver() {
		driver.quit();
	}

}

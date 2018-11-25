package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import java.util.concurrent.TimeUnit;

public abstract class SharedSteps {
	private static boolean isInitalized=false;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	protected SharedSteps() {
		if(!isInitalized){
			initDriver();
		}
	}
	
	private static void initDriver(){

		
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		quitDriver();
	}
	
	public static void quitDriver() {
		driver.quit();
	}
	
	

}

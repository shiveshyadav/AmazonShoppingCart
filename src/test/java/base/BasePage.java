package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;



public abstract class BasePage {


	protected WebDriver driver = null;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//We can use dynamic wait which can poll in every second please refer waitForElement method in this class
	public static void wait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Dynamic Wait function can be used to poll in every second
	public void waitForElement(int timeInSeconds,String elementid) {
		try {
			  int count=0;
			  do{
				if(driver.findElements(By.id(elementid)).size() ==0)
				{
					Thread.sleep(1000);
					count++;
				}
				else
				{
					break;
				}
			 }while(timeInSeconds > count);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pressEnter() {
		try {
			Thread.sleep(5000l);
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ENTER).perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}

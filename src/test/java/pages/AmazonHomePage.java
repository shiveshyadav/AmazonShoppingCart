package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import base.BasePage;


public class AmazonHomePage extends BasePage {

	public AmazonHomePage(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath = "//input[@value='Go']")
	WebElement searchbutton;

	@FindBy(id = "sort")
	WebElement sortbutton;
	
	@FindBy(xpath="//*[@value='addToCart']")
    List <WebElement> addtocart;

	@FindBy(xpath="//*[contains(text(),'Add to cart')]")
    List <WebElement> addtocartsmallc;
	
	@FindBy(xpath = "//input[@data-action-type='SELECT_LOCATION']")
	List <WebElement> selectlocation;
	
	@FindBy(xpath="//input[@aria-label='or enter a US zip code']")
	WebElement pincode;
	
	@FindBy(xpath="//*[contains(text(),'Apply')]")
	WebElement apply;
	
	@FindBy(xpath="//*[contains(text(),'Done')]")
	WebElement  done;

	@FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
	List <WebElement> proceedtocheckout;
	
	@FindBy(id = "ap_email")
	WebElement loginemail;
	
	@FindBy(id = "ap_password")
	WebElement loginpassword;
	
	@FindBy(xpath = "//*[@id='result_0']/div/")
	List <WebElement> firstresultofItemsearch;
	
	@FindBy(xpath = "buybox-see-all-buying-choices-announce")
	WebElement seebuyingoption;
	
	
	public void enter_text(String Search_text){
		
		
		searchBox.sendKeys(Search_text);
		
	}
	
	
	public void click_on_searchs_buton()
	{
		searchbutton.click();
	}
	
	
	public void sortElements(String sortBy)
	{
		Select dropdown = new Select(sortbutton);
		dropdown.selectByVisibleText(sortBy);
	}
	

	public void addtocart()
	{
		if(addtocart.size()>0)
		{
		  addtocart.get(0).click();
		}
	}
	
	
	public void setPincodeForDelivery(String pin) throws InterruptedException
	{
		wait(5); 
		if(selectlocation.size() >0)
		{
			selectlocation.get(0).click();
			pincode.sendKeys(pin);
	        pressEnter();
			done.click();
			wait(5);
		}
		
	}
	
	public boolean clickOnProceedToCheckout()
	{
		if(proceedtocheckout.size() >0)
		{
			proceedtocheckout.get(0).click();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyUserIsOnSignInScreen()
	{
		if(loginemail.isDisplayed() && loginpassword.isDisplayed())
			return true;
		else return false;
	}
	
		
	public void search_by_first_option(String text_to_search) {
		this.enter_text(text_to_search);
	}
	
	public boolean searchItemSortAndAddtocart(String item)
	{
		try{
		enter_text(item);
		click_on_searchs_buton();
		wait(5);
		sortElements("Price: Low to High");
		wait(5);
		addtocart();
		wait(5);
		return true;
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
			return false;
		}
	}
	
}

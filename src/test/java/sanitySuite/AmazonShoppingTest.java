package sanitySuite;

import org.testng.annotations.Test;

import base.TestBase;
import junit.framework.Assert;
import pages.AmazonHomePage;
import pages.Config;



public class AmazonShoppingTest extends TestBase{

	AmazonHomePage amazonhomepage=new AmazonHomePage(driver);
	boolean isTrue;

	@Test (priority=1)	
	public void AdditemtoCartandCheckout() throws InterruptedException {

		driver.get(Config.URL);
		amazonhomepage.setPincodeForDelivery(Config.PINCODE);
		
		isTrue=amazonhomepage.searchItemSortAndAddtocart("Snickers");
		Assert.assertEquals(true, isTrue);
		
		isTrue=amazonhomepage.searchItemSortAndAddtocart("Twix");
		Assert.assertEquals(true, isTrue);
		
		isTrue=amazonhomepage.searchItemSortAndAddtocart("Skittles");
		Assert.assertEquals(true, isTrue);
		 
		isTrue=amazonhomepage.clickOnProceedToCheckout();
		Assert.assertEquals(true, isTrue);
		
		isTrue=amazonhomepage.verifyUserIsOnSignInScreen();
        Assert.assertEquals(true, isTrue);
        
        
		
	}


}

package sanitySuite;

import java.io.IOException;
import org.testng.annotations.Test;
import pages.ReadPropertyFile;
import base.SharedSteps;
import junit.framework.Assert;
import pages.AmazonHomePage;


public class AmazonShoppingTest extends SharedSteps{

	
	AmazonHomePage amazonhomepage=new AmazonHomePage(driver);
	boolean isTrue;
	ReadPropertyFile props;
	
	public AmazonShoppingTest() throws IOException{
		props = new ReadPropertyFile();
	}
	
	@Test (priority=1)	
	public void AdditemtoCartandCheckout() throws InterruptedException {

		driver.get(props.getURL());
		amazonhomepage.setPincodeForDelivery(props.getPincode());
		
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

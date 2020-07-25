package WebHandling;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegressionTestCase {
	
		@Test(priority = 1)
		public void TC_01() {
			Keyword.openBrowser(PropertiesHandling.getProperty("browsername"));
		}

		@Test(priority = 2)
		public void TC_02() {
			Keyword.openUrl(PropertiesHandling.getProperty("baseURL"));
			Keyword.windowHandles();
			Keyword.maximizeBrowser();
			Assert.assertEquals(PropertiesHandling.getProperty("baseURL"), "https://www.shutterfly.com/");

		}

		@Test(priority = 3)
		public void TC_03() throws IOException {
		
		Keyword.clickonElement(PropertiesHandling.getLocator("SigninClick")[0], PropertiesHandling.getLocator("SigninClick")[1]);
		

	}
}
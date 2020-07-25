package WebHandling;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Keyword {

	public static void openBrowser(String browsername) {
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constant.driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constant.driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constant.driver = new InternetExplorerDriver();
			break;
		case "Opera":
			WebDriverManager.operadriver().setup();
			Constant.driver = new OperaDriver();
		case "Safari":
		default:
			System.out.println("Invalid browsername " + browsername);
		}
	}

	public static void openUrl(String url) {
		Constant.driver.get(url);
	}

	public static  WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "ID":
			Constant.driver.findElement(By.id(locatorValue));
			break;
		case "CLASSNAME":
			Constant.driver.findElement(By.className(locatorValue));
			break;
		case "XPATH":
			Constant.driver.findElement(By.xpath(locatorValue));
			break;
		case "PARTIAL_LINKTEXT":
			Constant.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "TAG_NAME":
			Constant.driver.findElement(By.tagName(locatorValue));
			break;
		case "LINK_TEXT":
			Constant.driver.findElement(By.linkText(locatorValue));
			break;
		case "CSS":
			Constant.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "NAME":
		default:
			System.err.println("Invalid locatorType" + locatorType
					+ ("Expected CLASSNAME,ID,CLASSNAME," + 
			"LINK_TEXT,CSS,TAG_NAME,PARTIAL_LINKTEXT,NAME,XPATH"));
			break;
		}
		return element;

	}
	
	public static void clickonElement(String locatorType, String locatorValue) {
		getWebElement(locatorType,locatorValue).click();
		
	}
	
	public static void enterText(String locatorType, String locatorValue,String textToenter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToenter);
		
	}
	public static void refreshPage() {
		Constant.driver.navigate().refresh();
	}
	public static void clearText(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	public static void dropDown(String locatorType, String locatorValue) {
		WebElement element=getWebElement(locatorType,locatorValue);
		Select select=new Select(element);
		select.selectByVisibleText(locatorValue);
		select.selectByValue(locatorValue);
		select.selectByIndex(0);
	}
	public static String getTitle() {
		String Actualtitle=Constant.driver.getTitle();
		return Actualtitle;	
	}
	public static void scrollPage() {
		JavascriptExecutor js=(JavascriptExecutor)Constant.driver;
		js.executeScript("window.scrollBy(0,200)");
		js.executeAsyncScript("window.scrollBy(0,200)");
	}
	public static void appyWait() {
		Constant.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	}
	public static void takeScreenshot() throws IOException {
		TakesScreenshot shot=(TakesScreenshot)Constant.driver;
		 File src=shot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src,new File("Path"));
		
	
	}
	public static void mouseHoverOnElement(String locatorType, String locatorValue) {
	//	Constant.action = new Actions(Constant.driver);
		WebElement tab = getWebElement( locatorType, locatorValue);
		Constant.actipon.sendKeys(Keys.TAB);
	//	Constant.action.moveToElement(tab).perform();
		tab.click();	}

	public static WebElement getElementfrom(String elementName) {
		WebElement element = Constant.driver.findElement(By.xpath("//*[contains(text(),'"+elementName+"')]"));
		return element;
	}
	
	public static void closePopup( ) {
		Constant.driver.findElement(By.xpath("//img[@src=\"https://cdn.staticsfly.com/i/ui/icon-close.png\"]")).click();
	}
	public static void windowHandles() {
		String parentWindow=Constant.driver.getWindowHandle();
		Set<String>s=Constant.driver.getWindowHandles();
		Iterator<String> itr=s.iterator();
		while(itr.hasNext()) {
			String childwindow=itr.next();
			if(parentWindow.equals(childwindow)) {
				Constant.driver.switchTo().window(childwindow);
				Constant.driver.findElement(By.xpath("//*[@id='ip2EmailOverlay']/button/img")).click();
				

			}
		}
		
	}
	public static void hoverMouseonWebelement() {
		Actions action=new Actions(Constant.driver);
		//Add Books
		action.moveToElement(Constant.driver.findElement(By.xpath("//span[@class='cat-item-text']/parent::a[@id='cat-link-18970']")));
		action.perform();
		
	}
	
	public static  void maximizeBrowser() {
		Constant.driver.manage().window().maximize();
	}
	public static void closeBrowser() {
		Constant.driver.close();
	}
	public static void quitBrowser() {
		Constant.driver.quit();
	}
	
}
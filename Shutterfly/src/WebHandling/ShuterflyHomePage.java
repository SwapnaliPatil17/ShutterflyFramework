package WebHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShuterflyHomePage {
	@Test
	private void ShutterflyWindoHandle() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.shutterfly.com/");
		driver.manage().window().maximize();

		String parent_window = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> itr = s1.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (parent_window.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//*[@id='ip2EmailOverlay']/button/img")).click();
			}
		}

		Actions action=new Actions(driver);
		System.out.println("Mouse Over to Photo");
		action.moveToElement(driver.findElement(By.xpath("//*[@id='cat-link-18970']/span")));
		System.out.println("mouse Over to Card");
		action.moveToElement(driver.findElement(By.xpath("//*[@id='cat-link-60000']/span")));
		action.perform();
		
		/*System.out.println("Click on Photo Book");
		driver.findElement(By.xpath("//*[@id=\"cat-link-18970\"]/span")).click();

		System.out.println("Photo Book is Open now");*/

		//driver.close();
	}

}
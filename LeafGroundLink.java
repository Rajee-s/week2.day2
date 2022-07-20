package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		
				// call WDM
				WebDriverManager.chromedriver().setup();
						
						
				//launch URL
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leafground.com/pages/Link.html");
				driver.manage().window().maximize();
				
				//Got to home page
				driver.findElement(By.linkText("Go to Home Page"));
				
				//where the link goes
				System.out.println("Directed to: " + driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));
				
				//verify am i broken
				driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
				
				String text = driver.findElement(By.xpath("//h1[text()='404 Not Found']")).getText();
				
				if (text.contains("404")){
					System.out.println("The link is broken");
					
				}
				
				//Go to home page(interact with the same link name)
				driver.get("http://leafground.com/pages/Link.html");
				driver.findElement(By.linkText("Go to Home Page")).click();
				driver.findElement(By.xpath("//h5[text()='HyperLink']/following::img")).click();
				
				
				//How many links are available
				List <WebElement> links = driver.findElements(By.tagName("a"));
				System.out.println("The number of links are: " +links.size());
				
				driver.close();
	}

}

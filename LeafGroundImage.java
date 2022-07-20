package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImage {

	public static void main(String[] args) {
		// call WDM
		WebDriverManager.chromedriver().setup();
				
				
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		//click on the image to go to home page
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following::img")).click();
		driver.findElement(By.xpath("//h5[text()='Image']/following::img")).click();
		
		//Am i broken image
		WebElement imageDisplay = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following::img"));
		if(imageDisplay.getAttribute("naturalWidth").equals("0")) {
			
			System.out.println("The image is broken");
		}
		
		//click me using keyboard or mouse
		//WebElement keyBoard = driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"));
		//keyBoard.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")).click();


	}

}

package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {
		
		// call WDM
		WebDriverManager.chromedriver().setup();
				
				
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		
		//click button to go to home page
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		
		//find position of button(x,y)
		System.out.println("The position of button is " + driver.findElement(By.id("position")).getLocation());
		
		
		//find button color
		System.out.println("The button color is " + driver.findElement(By.id("color")).getCssValue("background-color"));
				
		//Find height & width
		System.out.println("The height & width is " + driver.findElement(By.id("size")).getSize());
		
		
		

	}

}

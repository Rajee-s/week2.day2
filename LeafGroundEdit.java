package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		
		//Enter email
		driver.findElement(By.id("email")).sendKeys("rajee@gmail.com");
		
		
		//Append a text and press keyboard tab
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("here like this");
		
		
		//Get default text entered
		System.out.println("The default text is " + driver.findElement(By.xpath("//input[@align='left']")).getAttribute("value"));
		
		
		
		//Clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		
		
		//Confirm that edit field is disabled
		boolean isEnable = driver.findElement(By.xpath("//label[text() = 'Confirm that edit field is disabled']/following::input")).isEnabled();
		if(isEnable==false) {
			System.out.println("The edit field is disabled");
		}

	}

}

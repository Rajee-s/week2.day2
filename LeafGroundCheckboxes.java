package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckboxes {

	public static void main(String[] args) {
		
				// call WDM
				WebDriverManager.chromedriver().setup();
						
						
				//launch URL
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leafground.com/pages/checkbox.html");
				driver.manage().window().maximize();
				
				//Select the languages you know

				driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input")).click();
				
				//Confirm selenium is checked
				
				boolean isSelenium = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input")).isSelected();
				 if(isSelenium == true) {
					 System.out.println("Selenium is selected");
				 }
				 
				//Deselect only checked
				 driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[2]")).click();
				
				
				//select all checkboxes
				List<WebElement> list = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
				Integer.toString(list.size());
		 		for(WebElement e1:list) {
						
					e1.click();
				 }
				 
	}

}

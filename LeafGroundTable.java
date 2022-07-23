package week2.day2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
		//Get the count of number of columns
		List<WebElement> columns = driver.findElements(By.tagName("th")); 
		System.out.println("Number of columns:" + columns.size());
		
		
		//Get the count of number of rows
		List<WebElement> rows = driver.findElements(By.tagName("tr")); 
		System.out.println("Number of rows:" + rows.size());
		
		
		//Get the progress value of 'Learn to interact with Elements'
		Thread.sleep(30);
		//String progressValue = driver.findElement(By.xpath("(//font[contains(text(),'Learn to interact with')]/following::td/font)")).getText();
		//System.out.println("Learn to interact with Elements " + progressValue);
		
		
		//List<Integer> vitalTaskList = new ArrayList<Integer>();
		List<WebElement> progValueList = driver.findElements(By.xpath("//font[contains(text(),'Learn to interact')]/following::td"));
		for (int i = 0; i < progValueList.size(); i++) {
			String progress = progValueList.get(i).getText();
			System.out.println(progress);
		}
		
			
		
			
	}
}

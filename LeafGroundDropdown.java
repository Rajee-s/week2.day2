package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropdown {

	public static void main(String[] args) {
		
		// call WDM
		WebDriverManager.chromedriver().setup();
				
				
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		
		//Select training program using index
		WebElement trainingProgram = driver.findElement(By.id("dropdown1")); 
		Select index = new Select(trainingProgram); 
		index.selectByIndex(2);
		trainingProgram.sendKeys(Keys.TAB);
		
		//Select using text
		
		WebElement training = driver.findElement(By.xpath("//select[@name='dropdown2']")); 
		Select text = new Select(training); 
		text.selectByVisibleText("Loadrunner");
		training.sendKeys(Keys.TAB);
		
		//select using value
		WebElement trainingPro = driver.findElement(By.id("dropdown3")); 
		Select value = new Select(trainingPro); 
		value.selectByValue("3");
		trainingPro.sendKeys(Keys.TAB);
				
		//Get num of dropdown options
		Actions action = new Actions(driver);
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
		List <WebElement> list = dropdown.getOptions();
		System.out.println("Number of dropdown options are: " +list.size());
		action.sendKeys(Keys.TAB);
		
				
		WebElement selectProgram = driver.findElement(By.xpath("//option[text() ='You can also use sendKeys to select']/following::option[1]"));
		selectProgram.click();
				
		//select the program
		WebElement program = driver.findElement(By.xpath("//option[text()='Select your programs']")); 
		System.out.println(program.isEnabled());
		

	}

}

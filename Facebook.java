package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click Create New button
		driver.findElement(By.linkText("Create New Account")).click();
		
		
		//Enter First name
		driver.findElement(By.name("firstname")).sendKeys("Rajashree");
		
		//Enter last name
		driver.findElement(By.name("lastname")).sendKeys("Sundaram");
		
		//Enter mobile num
		driver.findElement(By.name("reg_email__")).sendKeys("9843411111");
		
		//Enter password
		
		driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys("rajee@123");
		
		
		//Handle all three dropdowns
		WebElement dropdown = driver.findElement(By.id("day"));
		Select day = new Select(dropdown);
		day.selectByValue("3");
		
		WebElement dropdown1 = driver.findElement(By.id("month"));
		Select month = new Select(dropdown1);
		month.selectByIndex(5);
		
		WebElement dropdown2 = driver.findElement(By.id("year"));
		Select year = new Select(dropdown2);
		year.selectByVisibleText("1990");
		
		
		//select radio button "Female"
		driver.findElement(By.className("_8esa")).click();
		boolean radiobutton = driver.findElement(By.className("_8esa")).isSelected();
		System.out.println(radiobutton);

	}

}

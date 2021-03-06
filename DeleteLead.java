package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		
					// call WDM
				WebDriverManager.chromedriver().setup();
				
				
				//launch URL
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leaftaps.com/opentaps/control/login");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
				//Username and password
				driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				//click login button 
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//click CRM/SFA link
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//click leads button
				driver.findElement(By.linkText("Leads")).click();
				
				//click find lead
				driver.findElement(By.linkText("Find Leads")).click();
				
				//Click on phone
				driver.findElement(By.xpath("//span[text()='Phone']")).click();
				
				//Enter Phone number
				driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9843411111");
				
				//Click find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				Thread.sleep(3000);
				//Capture lead of first resulting lead
				//String firstId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).getText();
				//System.out.println("The first Id is "+ firstId);
				WebElement firstId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"));
				String first = firstId.getText();
				System.out.println("The first Id is "+ first);
			
				Thread.sleep(3000);
				//Click first resulting lead
				driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
				
				
				//Click Delete
				
				driver.findElement(By.className("subMenuButtonDangerous")).click();
				
				//Click find leads
				driver.findElement(By.linkText("Find Leads")).click();
				
				//Enter captured lead Id
				
				 driver.findElement(By.xpath("//input[@name='id']")).sendKeys(first);
				
				
				//Click find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				Thread.sleep(300);
				//verify message "No records to display"
				
				boolean records = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
				if(records==true) {
					System.out.println("Lead Id deleted. No records to display!!");
				}
				//close the browser;
				driver.close();
	}

}

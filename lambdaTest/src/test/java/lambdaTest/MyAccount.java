package lambdaTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccount {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ecommerce-playground.lambdatest.io/");
		WebElement element = driver.findElement(By.xpath("//i[@class='icon fas fa-user']"));
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		driver.findElement(By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[2]/a/div/span")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("raj");
		driver.findElement(By.id("input-lastname")).sendKeys("sekhar");
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("raj@gmail.com");
		driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys("0499034");
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("raj@0803");
		driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys("raj@0803");
		driver.findElement(By.xpath("//*[@id='input-newsletter-yes']")).click();
		WebElement click=driver.findElement(By.id("input-agree"));
		a.moveToElement(click).click().build().perform();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Thread.sleep(5000);
		String message=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();							
		System.out.print(message);
	driver.findElement(By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[1]/a/div/span")).click();
	driver.findElement(By.id("input-email")).sendKeys("rajasekhar113");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.id("input-password")).sendKeys("Raj@144321");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input[1]")).click();
	String message1=driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
	System.out.print(message1);
		driver.close();
	}
}

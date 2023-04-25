package lambdaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PomFile {

	WebDriver driver;
	By Element = By.xpath("//i[@class='icon fas fa-user']");
	By Register = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[2]/a/div/span");
	By Firstname = By.id("input-firstname");
	By lastname = By.id("input-lastname");
	By email = By.xpath("//*[@id='input-email']");
	By telephone = By.xpath("//*[@id='input-telephone']");
	By password = By.xpath("//*[@id='input-password']");
	By confirm = By.xpath("//*[@id='input-confirm']");
	By input = By.id("input-agree");
	By submit = By.xpath("//input[@class='btn btn-primary']");
	By getmsg = By.xpath("//*[@id='content']/h1");
	By loginButton = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[1]/a/div/span");
	By Inputemail = By.id("input-email");
	By Inputpassword = By.id("input-password");
	By presslogin = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input[1]");
	By loginmsg = By.xpath("//*[@id=\"account-login\"]/div[1]");
	By logout=By.xpath("//*[@id='widget-navbar-217834']/ul/li[6]/ul/li[6]/a/div/span");
	By logoutsuccessmessage=By.xpath("//*[@id=\"content\"]/h1");
	public PomFile(WebDriver driver) {
		this.driver = driver;
	}

	public void HoveronElement() {
		WebElement element = driver.findElement(Element);
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void registerclick() {
		driver.findElement(Register).click();
	}

	public void Enterdata(String name, String last, String gmail, String number, String pwd, String con) {
		driver.findElement(Firstname).sendKeys(name);
		driver.findElement(lastname).sendKeys(last);
		driver.findElement(email).sendKeys(gmail);
		driver.findElement(telephone).sendKeys(number);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirm).sendKeys(con);
	}

	public void clickinput() {
		Actions a = new Actions(driver);
		WebElement click = driver.findElement(input);
		a.moveToElement(click).click().build().perform();
	}

	public void presssubmit() {
		driver.findElement(submit).click();
	}

	public void getSuccessmessage() {
		String msg = driver.findElement(getmsg).getText();
		System.out.println(msg);
	}

	public void loginpress() {
		driver.findElement(loginButton).click();
	}

	public void loginCredentials(String username, String loginpassword) {
		driver.findElement(Inputemail).sendKeys(username);
		driver.findElement(Inputpassword).sendKeys(loginpassword);
	}

	public void pressedloginbutton() {
		driver.findElement(presslogin).click();
	}

	public void getloginSuccessMessage() {
		String message = driver.findElement(loginmsg).getText();
		System.out.print(message);
	}
	public void logoutbuttonpress()
	{
		driver.findElement(logout).click();
	}
	public void getlogoutSuccessMessage() {
		String message = driver.findElement(logoutsuccessmessage).getText();
		System.out.print(message);

}
}

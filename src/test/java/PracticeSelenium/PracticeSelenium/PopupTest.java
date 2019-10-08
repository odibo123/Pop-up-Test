package PracticeSelenium.PracticeSelenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;

public class PopupTest {

	public WebDriver driver;
	@Given("^User log into app$")
	public void user_log_into_app() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver" ,"C:\\Drive\\chromedriver.exe");	
		driver = new ChromeDriver();	
		driver.navigate().to("http://www.popuptest.com/goodpopups.html");
	List<WebElement> li =driver.findElements(By.tagName("a"));
	for(WebElement ud: li){
		System.out.println(ud.getText());
	}

	}
	
	@Given("^I click on good pop link$")
	public void i_click_on_good_pop_link() throws Throwable {
	  driver.findElement(By.xpath("//a[@class='black']")).click();
	  
Set<String> pop= driver.getWindowHandles();
Iterator <String> it= pop.iterator();
   String parentWindowId= it.next();
   System.out.println("Parent window id is "+parentWindowId);
   
   String childWindowId= it.next();
   System.out.println("Parent window id is "+childWindowId);
  // driver.switchTo().window(childWindowId);
  // System.out.println("title of child window is "+driver.getTitle());
   System.out.println(driver.switchTo().window(childWindowId).getTitle());
   driver.close();
   driver.switchTo().window(parentWindowId);
   System.out.println("title of parent window is "+driver.getTitle());
	}
}

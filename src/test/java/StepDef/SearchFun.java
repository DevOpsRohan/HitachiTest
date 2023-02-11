package StepDef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchFun {
	
	public WebDriver driver;

	
	@After
	public void quite() {
		System.out.println("Quite the currect open browser");
		driver.close();
	}
	
	@Given("the user land of Hitachi portal")
	public void the_user_land_of_hitachi_portal() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://global.hitachi-solutions.com/");
		Thread.sleep(5000);
	}
	
	
	@When("the user click on Search option")
	public void the_user_click_on_search_option() {
		driver.findElement(By.id("open-global-search")).click();
	}
	
	@When("the user is on the search page")
	public void the_user_is_on_the_search_page() {
		
		assertTrue(driver.findElement(By.id("site-search-keyword")).isDisplayed());
	}
	
	@When("the user tries to search for {string}")
	public void the_user_tries_to_search_for(String searchWord) throws InterruptedException {
		driver.findElement(By.id("site-search-keyword")).sendKeys(searchWord);
		Thread.sleep(5000);
		String Enter= Keys.chord(Keys.ENTER);
		driver.findElement(By.id("site-search-keyword")).sendKeys(Enter);
		/*WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='search-form']/form/button/i"))))
		.click();*/
		
		
	}
	
	@Then("the search result should display all the products related")
	public void the_search_result_should_display_all_the_products_related() {
		String result=driver.findElement(By.className("results")).getText();
		assert result.contains("Search results for"):"No search result found";
	}
	@Then("the user should be able to select a product from the search results")
	public void the_user_should_be_able_to_select_a_product_from_the_search_results() {
		
		List<WebElement> ls=driver.findElements(By.xpath("//*[@class='search-result']/p/a"));
		ls.get(0).click();
		driver.getTitle().contains("Executive Panel on Supply Chain Agility & Automation: Microsoft & Hitachi Solutions – Hitachi Solutions");
		
	}
	
	@Then("an error message {string} should be displayed")
	public void an_error_message_should_be_displayed(String errorMsg) {
	    
		String Message =driver.findElement(By.className("results")).getText();
		assertEquals(Message,errorMsg);
	}
	
	

}

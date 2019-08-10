package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObj {
  public WebDriver driver;
  By searchF = By.cssSelector("#search");
  By searchB = By.name("search-btn");

  public SearchPageObj(WebDriver driver) {
    // TODO Auto-generated constructor stub
    this.driver = driver;
  }

  public WebElement getsearchF() {
    return driver.findElement(searchF);

  }

  public WebElement getsearchB() {
    return driver.findElement(searchB);

  }


}

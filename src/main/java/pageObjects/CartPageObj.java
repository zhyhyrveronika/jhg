package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.ReadPropertiesFile;

public class CartPageObj extends ReadPropertiesFile {
  public WebDriver driver;
  By link = (By.linkText(prop.getProperty("SEARCH_TEST_PARAMETR")));
  By AddP2 = (By.cssSelector(
      "div.dish:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > i:nth-child(1)"));
  By AddP7 = (By.cssSelector(
      "div.dish:nth-child(7) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > i:nth-child(1)"));
  By CartMenu = (By.cssSelector(".meals-btn > a:nth-child(1) > button:nth-child(1)"));
  By ClearCartButton = (By.xpath("/html/body/div[1]/section/div/div[1]/div[1]/div[2]/span"));
  By CloseClearButton = (By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div[3]/div[1]"));
  By ConfirmClearButton = (By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div[3]/div[2]"));
  By OrderButton = (By.xpath("/html/body/div[1]/section/div/div[1]/div[6]/div[1]/a[2]/div"));
  By EmptyCartM = (By.cssSelector("div.empty-cart:nth-child(2"));

  public CartPageObj(WebDriver driver) {
    // TODO Auto-generated constructor stub
    this.driver = driver;
  }

  public WebElement getlink() {
    return driver.findElement(link);

  }

  public WebElement getAddP2() {
    return driver.findElement(AddP2);

  }

  public WebElement getAddP7() {
    return driver.findElement(AddP7);

  }

  public WebElement getCartMenu() {
    return driver.findElement(CartMenu);

  }


  public WebElement getClearCartButton() {
    return driver.findElement(ClearCartButton);

  }

  public WebElement getConfirmClearButton() {
    return driver.findElement(ConfirmClearButton);

  }

  public WebElement getOrderButton() {
    return driver.findElement(OrderButton);

  }

  public WebElement getCloseClearButton() {
    return driver.findElement(CloseClearButton);

  }

  public WebElement getEmptyCartM() {
    return driver.findElement(EmptyCartM);

  }
}

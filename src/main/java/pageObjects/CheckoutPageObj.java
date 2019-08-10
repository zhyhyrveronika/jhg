package pageObjects;

import java.util.Collection;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPageObj {
  public WebDriver driver;
  By SubmitButton = By.id("submitCheckForm");
  By AllertBox = By.xpath("//*[@id='ngdialog1']/div[2]/div[1]");
  By ABoxButtonOK = By.xpath("//*[@id='ngdialog1']/div[2]/div[1]/div[3]/div");
  By ValidFields = (By.xpath("//input[@class='styled ng-pristine ng-valid']"));
  By ValidMobField = (By.xpath("//input[@class='styled js-phone-input ng-pristine ng-valid']"));
  By ErrorFields = (By.xpath("//input[@class='styled ng-pristine ng-valid bad']"));
  By ErrorMobField = (By.xpath("//input[@class='styled js-phone-input ng-pristine ng-valid bad']"));

  public CheckoutPageObj(WebDriver driver) {
    this.driver = driver;

  }

  public WebElement getSubmitButton() {
    return driver.findElement(SubmitButton);

  }

  public WebElement getAllertBox() {
    return driver.findElement(AllertBox);

  }

  public List<WebElement> getValidFields() {
    return driver.findElements(ValidFields);

  }

  public WebElement getValidMobField() {
    return driver.findElement(ValidMobField);

  }

  public List<WebElement> getErrorFields() {
    return driver.findElements(ErrorFields);

  }

  public WebElement getErrorMobField() {
    return driver.findElement(ErrorMobField);

  }

  public WebElement getABoxButtonOK() {
    return driver.findElement(ABoxButtonOK);

  }
}


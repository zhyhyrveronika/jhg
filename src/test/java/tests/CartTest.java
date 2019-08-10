package tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CartPageObj;
import resources.ReadPropertiesFile;

public class CartTest extends ReadPropertiesFile {

  @BeforeTest
  public void AddProduct() throws InterruptedException, IOException {
    driver = IntialDriver();
    driver.manage().window().maximize();
    CartPageObj cpo = new CartPageObj(driver);
    driver.get(prop.getProperty("URL"));
    cpo.getlink().click();
    cpo.getAddP2().click();
    cpo.getAddP7().click();
  }


  @Test
  public void checkCartContent() {
    CartPageObj cpo = new CartPageObj(driver);
    driver.get(prop.getProperty("CART_URL"));
    Assert.assertFalse(cpo.getEmptyCartM().isDisplayed());

  }

  @Test
  public void cancellDelete() throws InterruptedException {
    CartPageObj cpo = new CartPageObj(driver);
    WebDriverWait wait = new WebDriverWait(driver, 15);
    driver.get(prop.getProperty("CART_URL"));
    wait.until(ExpectedConditions.elementToBeClickable(cpo.getClearCartButton()));
    cpo.getClearCartButton().click();
    cpo.getCloseClearButton().click();
    Assert.assertFalse(cpo.getEmptyCartM().isDisplayed());
    Thread.sleep(1000);
  }


  @Test
  public void confirmDelete() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 15);
    CartPageObj cpo = new CartPageObj(driver);
    driver.get(prop.getProperty("CART_URL"));
    wait.until(ExpectedConditions.elementToBeClickable(cpo.getClearCartButton()));
    cpo.getClearCartButton().click();
    cpo.getConfirmClearButton().click();
    Assert.assertTrue(cpo.getEmptyCartM().isDisplayed());
  }

  @AfterTest
  public void BrowserClose() {
    driver.close();
    driver = null;
  }
}

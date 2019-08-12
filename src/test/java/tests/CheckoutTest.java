package tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CartPageObj;
import pageObjects.CheckoutPageObj;
import resources.ReadPropertiesFile;

public class CheckoutTest extends ReadPropertiesFile {
  @BeforeTest
  public void CreateOrder() throws InterruptedException, IOException {
    driver = IntialDriver();
    driver.manage().window().maximize();
    CartPageObj checkoutpage�bj = new CartPageObj(driver);
    driver.get(prop.getProperty("URL"));
    checkoutpage�bj.getlink().click();
    checkoutpage�bj.getAddP2().click();
    checkoutpage�bj.getAddP7().click();
    driver.get(prop.getProperty("CART_URL"));
    checkoutpage�bj.getOrderButton().click();

  }

  @Test
  public void confirmCheckout() {
    CheckoutPageObj checkoutpage�bj = new CheckoutPageObj(driver);
    driver.get(prop.getProperty("CHECKOUT_URL"));
    Assert.assertEquals(3, checkoutpage�bj.getValidFields().size());
    Assert.assertTrue(checkoutpage�bj.getValidMobField().isDisplayed());
    checkoutpage�bj.getSubmitButton().click();
    Assert.assertTrue(checkoutpage�bj.getAllertBox().isDisplayed());
    checkoutpage�bj.getABoxButtonOK().click();
  }

  @Test
  public void checkValidField() {
    CheckoutPageObj checkoutpage�bj = new CheckoutPageObj(driver);
    driver.get(prop.getProperty("CHECKOUT_URL"));
    checkoutpage�bj.getSubmitButton().click();
    checkoutpage�bj.getABoxButtonOK().click();
    Assert.assertEquals(3, checkoutpage�bj.getErrorFields().size());
    Assert.assertTrue(checkoutpage�bj.getErrorMobField().isDisplayed());

  }

  @AfterTest
  public void BrowserClose() {
    driver.close();
    driver = null;
  }
}


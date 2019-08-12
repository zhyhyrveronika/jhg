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
    CartPageObj checkoutpageîbj = new CartPageObj(driver);
    driver.get(prop.getProperty("URL"));
    checkoutpageîbj.getlink().click();
    checkoutpageîbj.getAddP2().click();
    checkoutpageîbj.getAddP7().click();
    driver.get(prop.getProperty("CART_URL"));
    checkoutpageîbj.getOrderButton().click();

  }

  @Test
  public void confirmCheckout() {
    CheckoutPageObj checkoutpageîbj = new CheckoutPageObj(driver);
    driver.get(prop.getProperty("CHECKOUT_URL"));
    Assert.assertEquals(3, checkoutpageîbj.getValidFields().size());
    Assert.assertTrue(checkoutpageîbj.getValidMobField().isDisplayed());
    checkoutpageîbj.getSubmitButton().click();
    Assert.assertTrue(checkoutpageîbj.getAllertBox().isDisplayed());
    checkoutpageîbj.getABoxButtonOK().click();
  }

  @Test
  public void checkValidField() {
    CheckoutPageObj checkoutpageîbj = new CheckoutPageObj(driver);
    driver.get(prop.getProperty("CHECKOUT_URL"));
    checkoutpageîbj.getSubmitButton().click();
    checkoutpageîbj.getABoxButtonOK().click();
    Assert.assertEquals(3, checkoutpageîbj.getErrorFields().size());
    Assert.assertTrue(checkoutpageîbj.getErrorMobField().isDisplayed());

  }

  @AfterTest
  public void BrowserClose() {
    driver.close();
    driver = null;
  }
}


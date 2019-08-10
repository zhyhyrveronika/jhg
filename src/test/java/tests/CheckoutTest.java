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
    CartPageObj cpo = new CartPageObj(driver);
    driver.get(prop.getProperty("URL"));
    cpo.getlink().click();
    cpo.getAddP2().click();
    cpo.getAddP7().click();
    driver.get(prop.getProperty("CART_URL"));
    cpo.getOrderButton().click();

  }

  @Test
  public void confirmCheckout() {
    CheckoutPageObj chk = new CheckoutPageObj(driver);
    driver.get(prop.getProperty("CHECKOUT_URL"));
    Assert.assertEquals(3, chk.getValidFields().size());
    Assert.assertTrue(chk.getValidMobField().isDisplayed());
    chk.getSubmitButton().click();
    Assert.assertTrue(chk.getAllertBox().isDisplayed());
    chk.getABoxButtonOK().click();
  }

  @Test
  public void checkValidField() {
    CheckoutPageObj chk = new CheckoutPageObj(driver);
    driver.get(prop.getProperty("CHECKOUT_URL"));
    chk.getSubmitButton().click();
    chk.getABoxButtonOK().click();
    Assert.assertEquals(3, chk.getErrorFields().size());
    Assert.assertTrue(chk.getErrorMobField().isDisplayed());

  }

  @AfterTest
  public void BrowserClose() {
    driver.close();
    driver = null;
  }
}


package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.SearchPageObj;
import resources.ReadPropertiesFile;

public class SearchFunctionTest extends ReadPropertiesFile {

  @BeforeSuite
  public void init() throws IOException {
    driver = IntialDriver();

  }

  @BeforeTest
  public void profileSetup() {
    driver.manage().window().maximize();
  }

  @BeforeClass
  public void appSetup() {
    driver.get(prop.getProperty("URL"));
  }

  @Test(dataProvider = "provideDataExistentInfo")
  public void SearchTestExistentInfo(String existentInfo) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 15);
    SearchPageObj searchpageîbj = new SearchPageObj(driver);
    searchpageîbj.getsearchF().clear();
    searchpageîbj.getsearchF().sendKeys(existentInfo);
    searchpageîbj.getsearchB().click();
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.linkText(prop.getProperty("SEARCH_TEST_PARAMETR"))));
    WebElement status = driver.findElement(By.linkText(prop.getProperty("SEARCH_TEST_PARAMETR")));
    Assert.assertEquals(status.getText(), prop.getProperty("SEARCH_TEST_PARAMETR"));

  }

  @Test(dataProvider = "NonexistentInfo")
  public void SearchTestNonexistentInfo(String nonexistentInfo) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 15);
    SearchPageObj searchpageîbj = new SearchPageObj(driver);
    searchpageîbj.getsearchF().clear();
    searchpageîbj.getsearchF().sendKeys(nonexistentInfo);
    searchpageîbj.getsearchB().click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-result-empty")));
    Assert.assertTrue(driver.findElement(By.cssSelector(".search-result-empty")).isDisplayed());

  }

  @AfterTest
  public void BrowserClose() {
    driver.close();
    driver = null;
  }

  @DataProvider(name = "ExistentInfo")
  public Object[][] provideDataExistentInfo() {
    Object[][] result = null;
    result = new Object[][] {{"GEO"}, {"georgia"}, {"Georgia"}
      };
    return result;
  }

  @DataProvider(name = "NonexistentInfo")
  public Object[][] provideNonexistentInfo() {
    Object[][] result = null;
    result = new Object[][] {{"Georgya"}, {"random info"}
    };
    return result;
  }
}

package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {
  public WebDriver driver;
  protected static Properties prop = new Properties();

  public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream(
        "C:\\Users\\Вероника\\MAtests\\src\\main\\java\\resources\\config.properties");
    prop.load(fis);
  }

  static final String DRIVER = "DRIVER";
  static final String DRIVER_PATH = "DRIVER_PATH";
  static final String HOME_PAGE_URL = "URL";
  static final String CART_PAGE_URL = "CART_URL";
  static final String CHECKOUT_PAGE_URL = "CHECKOUT_URL";
  static final String SEARCH_TEST_PARAMETR = "SEARCH_TEST_PARAMETR";
  static final String SEARCH_TEST_FAIL_PARAMETR = "FAIL_PARAMETR";


  public String getDRIVER(Properties prop) {
    return prop.getProperty(DRIVER);
  }

  public String getDRIVER_PATH(Properties prop) {
    return prop.getProperty(DRIVER_PATH);
  }

  public String getHOME_PAGE_URL(Properties prop) {
    return prop.getProperty(HOME_PAGE_URL);
  }

  public String getCART_PAGE_URL_URL(Properties prop) {
    return prop.getProperty(CART_PAGE_URL);
  }


  public String getCHECKOUT_PAGE_URL(Properties prop) {
    return prop.getProperty(CHECKOUT_PAGE_URL);
  }

  public String getSEARCH_TEST_PARAMETR(Properties prop) {
    return prop.getProperty(SEARCH_TEST_PARAMETR);
  }


  public WebDriver IntialDriver() throws IOException {
    FileInputStream fis = new FileInputStream(
        "C:\\Users\\Вероника\\MAtests\\src\\main\\java\\resources\\config.properties");
    prop.load(fis);
    System.setProperty(prop.getProperty(DRIVER), prop.getProperty(DRIVER_PATH));
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
  }
}



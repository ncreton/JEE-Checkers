/**
 * Created by nicolas on 25/01/2017.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

import com.google.common.collect.Lists;

import java.util.Map;

public class GameWebPageTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/nicolas/Documents/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
        driver = new ChromeDriver(options);
        driver.get("http://google.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

//    @Test
//    public void itCanAccessThePage() throws Exception {
//
//
//    }
}

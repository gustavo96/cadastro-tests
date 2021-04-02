package br.com.webmotors.step_definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;
    @Before
    public void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void afterClass() throws Exception {
        driver.quit();
    }

}
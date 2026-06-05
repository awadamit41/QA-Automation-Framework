package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import pages.LoginPage;

public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        
    }

    @Test
    public void loginTest() {
        LoginPage login = new LoginPage(driver);

        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();

        // Validate successful login
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("secure"), "Login failed!");
        
    }

      
    @AfterTest
    public void tearDown() {
    	
        driver.quit();
    }
}
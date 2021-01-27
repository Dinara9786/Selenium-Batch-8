package com.syntax.class10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakingScreenshots  {

    //public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

        TakesScreenshot ts = (TakesScreenshot)driver; // this is the Syntax of downcasting
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);// i am taking a screenshot of a whole file // passing arguments

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/HRMS/adminLogin.png"));// we specify destination of the file
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        driver.quit();
    }
}

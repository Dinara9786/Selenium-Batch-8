package com.review.SeleniumClass01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfiguration {

    public static void main(String[] args) throws InterruptedException {

        // 1. Set properties for our webdriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //2. Create an object of WebDriver interface
        WebDriver driver = new ChromeDriver();

        // ChromeDriver (BrowserDriver) extends RemoteWebDriver
        // RemoteWebDriver implements WebDriver

        // Navigate to spedified web application

        String amazonUrl = "http://www.amazon.com/";
        //driver.get("http://www.amazon.com/");
        driver.get(amazonUrl);

        String currentUrl=driver.getCurrentUrl();
        System.out.println(currentUrl);

        Thread.sleep(3000);
        //driver.quit();// closes all the tabs
        //driver.close(); // close the current tab

       String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title validation test PASS");
        }else {
            System.out.println("Title validation test FAIL");
        }

        String handle = driver.getWindowHandle();
        System.out.println(handle);

        // navigate() methods ==> keeps our browsing history and enables us to specific page or navigate back and
        // forward or refresh our browser



    }


}

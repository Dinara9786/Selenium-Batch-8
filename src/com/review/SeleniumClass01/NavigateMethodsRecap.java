package com.review.SeleniumClass01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethodsRecap {

    public static void main(String[] args) throws InterruptedException {

        // 1. Set properties for our webdriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //2. Create an object of WebDriver interface
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String ebayUrl = "http://www.ebay.com";

        // .navigate().to(String URL)
        driver.navigate().to(ebayUrl);

        Thread.sleep(3000);

        // navigate to Amazon

        driver.navigate().to("http://www.amazon.com/");

        Thread.sleep(3000);
        driver.navigate().back();

        // get title and url of current webpage

        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is " + currentURL);

        String currentTitle = driver.getTitle();
        System.out.println("Title of current ulr = " + currentTitle);

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.close();

    }
}

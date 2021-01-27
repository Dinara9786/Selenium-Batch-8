package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");// navigates to the particular url/webpage
        driver.navigate().to("http://facebook.com"); // navigate is the method we can manipulate with webpage
        driver.navigate().back();
        Thread.sleep(1000); //  pauses the thread (execution) for the given millisecs
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().refresh();
        //driver.close(); // it will close current tab
        driver.quit(); // it will quit the whole browser regardless how many tabs I have open



    }
}

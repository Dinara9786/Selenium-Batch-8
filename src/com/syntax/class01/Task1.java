package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    /**
     * 1. launch the browser
     * 2. navigate to Amazon website
     * 3. print out the title and the rul in the console
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

       //WebDriver = is our parent
        WebDriver driver = new ChromeDriver();// launches browser

        driver.get("http://www.amazon.com");
        String url = driver.getCurrentUrl();
        System.out.println(url);

        String title = driver.getTitle();
        System.out.println(title);

    }
}

package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();// launch the browser
        //driver.get("http:www.google.com"); // navigate to url
        driver.get("http://syntaxtechs.com");// navigate to url
        String url = driver.getCurrentUrl();
        System.out.println(url);// url will be printed in console

        String title = driver.getTitle(); // getting title of the page
        System.out.println(title);


    }

}

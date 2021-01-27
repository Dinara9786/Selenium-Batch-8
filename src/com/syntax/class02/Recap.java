package com.syntax.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recap {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://facebook.com");
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); // another way to maximaze the window page. It will not give tabs,
        // and that the preferrable way
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("facebook - Log In or Sign Up")) {
            System.out.println("Title is correct");
        }else {
            System.out.println("Title is wrong");
        }


    }
}

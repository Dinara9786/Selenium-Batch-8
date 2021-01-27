package com.syntax.class04;

import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://www.amazon.com";

        driver.get(url);

        List<WebElement> allLinks = driver.findElements(By.tagName("<a>"));
        System.out.println(allLinks.size());

        for (WebElement link : allLinks) {
            String fullLink = link.getAttribute("href");
            String linktext = link.getText();
            if (!linktext.isEmpty()) {
                System.out.println(linktext + " =====  " + fullLink);
                // driver.quit();
            }
        }
    }
    }


package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GetAllLinksFromEbay {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());

        for (WebElement links : allLinks) {
            String fullLink = links.getAttribute("href");
            String linkText = links.getText();
            if (!linkText.isEmpty()) {
                System.out.println(linkText + " =====  " + fullLink);


            }
        }
    }
}

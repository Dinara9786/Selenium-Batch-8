package com.review.SeleniumClass01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathKayak {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "http://www.kayak.com/";
        driver.get(url);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='pickup']")).click();
        // enter Dallas to Airport
    }
}

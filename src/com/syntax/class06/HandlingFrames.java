package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);

        driver.switchTo().frame(0);

        WebElement textBox = driver.findElement(By.id("name"));

        textBox.sendKeys("Syntax!!!");
        Thread.sleep(2000);

        driver.switchTo().defaultContent(); // switching the focus back to the main page
//        Thread.sleep(2000);
//        WebElement alertButton = driver.findElement(By.id ("alert"));
//        alertButton.click();

        driver.switchTo().frame("iframe_a");

        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("Happy 2021!");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));

        driver.switchTo().frame(frameElement);
        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("I am working!!!");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.quit();


    }
}

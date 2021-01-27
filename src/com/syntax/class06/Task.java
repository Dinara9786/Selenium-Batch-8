package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

    public static String url = "http://syntaxtechs.com/selenium-practice/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);

        driver.switchTo().frame("FrameOne");

        WebElement frameLogo = driver.findElement(By.xpath("//a[text() ='SYNTAX TECHNOLOGIES ']"));

        String logoText = frameLogo.getText();
        System.out.println("The text of the logo is = " + logoText);

        boolean logoIsDisplayed = frameLogo.isDisplayed();
        System.out.println("Logo Syntax is displayed = " + logoIsDisplayed);

        driver.switchTo().defaultContent();

        WebElement frameTwo = driver.findElement(By.name("FrameTwo"));

        driver.switchTo().frame(frameTwo);

        WebElement enrollBox = driver.findElement(By.xpath("//a[@class ='enroll-btn']"));

        String enrollText = enrollBox.getText();
        System.out.println("The Enroll Today text is = " + enrollText);

        boolean enrollIsEnabled = enrollBox.isEnabled();
        System.out.println("Enroll Today Box is enabled = " + enrollIsEnabled);

    }
}

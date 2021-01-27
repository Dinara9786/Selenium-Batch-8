package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx";

        driver.get(url);

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement button = driver.findElement(By.xpath("//input[@name = 'ctl00$MainContent$login_button']"));
        button.click();

        WebElement logo = driver.findElement(By.xpath("//h1[text() = 'Web Orders']"));
        boolean isDisplayed = logo.isDisplayed();
        System.out.println(isDisplayed);


    }
}

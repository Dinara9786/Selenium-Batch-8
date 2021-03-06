package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://amazon.com");

        WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));

        Actions action = new Actions(driver);// driver is executing actions

        action.moveToElement(accountsAndLists).perform();






    }
}
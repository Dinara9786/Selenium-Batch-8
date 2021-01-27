package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

        public static String url = "http://www.uitestpractice.com/Students/Switchto";

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get(url);

            WebElement simpleAlertButton = driver.findElement(By.id("alert"));
            simpleAlertButton.click();
            Thread.sleep(3000);
            // handling SIMPLE ALERT
           Alert simpleAlert = driver.switchTo().alert();
          Thread.sleep(3000);
           simpleAlert.accept();// clicking OK

            WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
            confirmAlertButton.click();
            Thread.sleep(3000);
            Alert confirmAlert = driver.switchTo().alert();
            Thread.sleep(3000);
            // handlig confirmation alert
            String confirmAlertText = confirmAlert.getText();
            Thread.sleep(3000);
            System.out.println(confirmAlertText);
            confirmAlert.dismiss(); // means we want to cancel

            Thread.sleep(3000);
            WebElement promptAlertButton = driver.findElement(By.id("prompt"));
            promptAlertButton.click();
            Thread.sleep(3000);
            Alert promptAlert = driver.switchTo().alert();
            promptAlert.sendKeys("Syntax Technologies");
            promptAlert.accept();





        }
}

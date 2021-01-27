package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.className("button")).click();
        driver.manage().window().maximize();
        String title = driver.getTitle();
        if (title.equalsIgnoreCase("Web Orders")) {
            System.out.println("The title is correct");
        }else{
            System.out.println("The title is not correct");
        }
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_logout")).click();
        Thread.sleep(2000);
        driver.quit();

        //actual value = is our actual value
        // expected value = what we have in hand
        // then we compare actual.equals(expected)

    }
}

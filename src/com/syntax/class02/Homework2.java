package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.attribute.standard.Chromaticity;

public class Homework2 {
     // 1. navigate to fb.com
    // 2. click on create new account
    // 3. first name and last name, mobile or email and new password and sign up and close pop up (x)
    // and close the u_l_9
     public static void main(String[] args) throws InterruptedException {

         System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

         WebDriver driver = new ChromeDriver();
         driver.get("http://facebook.com");
         driver.manage().window().maximize();
         Thread.sleep(2000);
         driver.findElement(By.className("_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy")).click();
         driver.findElement(By.name("firstname")).sendKeys("Maria");
         driver.findElement(By.name("lastname")).sendKeys("Ivanova");
         driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("654987");
         driver.findElement(By.id("password_step_input")).sendKeys("Password");
         driver.findElement(By.name("websubmit")).click();
         //driver.findElement(By.id("u_l_9")).click();
         Thread.sleep(3000);
         driver.quit();


     }
}

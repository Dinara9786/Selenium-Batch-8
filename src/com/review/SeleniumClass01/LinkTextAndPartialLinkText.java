package com.review.SeleniumClass01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextAndPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(url);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(5000);

        //locating by linkText

        //driver.findElement(By.linkText("Recruitment")).click();

        // locating by partialLinkText
        driver.findElement(By.partialLinkText("Recrui")).click();



    }
}

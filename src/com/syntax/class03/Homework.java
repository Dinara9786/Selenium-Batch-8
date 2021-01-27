package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://syntaxtechs.com/selenium-practice/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id ='btn_basic_example']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text() ='Simple Form Demo'])[2]")).click();
        driver.findElement(By.xpath("//input[@placeholder = 'Please enter your Message']"))
                .sendKeys("Syntax Technologies");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text() = 'Show Message']")).click();
        Thread.sleep(3000);
        driver.close();

    }
}

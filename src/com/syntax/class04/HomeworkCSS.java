package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkCSS {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://syntaxtechs.com/selenium-practice/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a[id='btn_basic_example']")).click();
        //driver.findElement(a#btn_basic.example).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='Simple Form Demo'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder^= 'Please']")).sendKeys("Syntax Technologies");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='showInput();']")).click();
        driver.quit();



    }
}

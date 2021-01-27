package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

    public static String url = "http://syntaxtechs.com/selenium-practice/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver ();

        driver.manage().window().maximize();

        driver.get(url);

      // WebElement alert1 = driver.findElement(By.xpath("(//div[text() = 'Java Script Alert Box'])[1]"));
        //Alert alertBox = driver.switchTo().alert();
        WebElement clickBox = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        //Alert alertBox = driver.switchTo().alert();
        clickBox.click();
        Thread.sleep(2000);
        Alert alertBox = driver.switchTo().alert();
        alertBox.accept();

        WebElement confirmAlert = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        confirmAlert.click();
        Thread.sleep(2000);
        Alert confirmBox = driver.switchTo().alert();
        confirmBox.accept();

        WebElement promptAlert = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
        promptAlert.click();
        Thread.sleep(2000);
        Alert promptBox = driver.switchTo().alert();
        promptBox.sendKeys("Syntax Technologies");
        promptBox.accept();



    }
}

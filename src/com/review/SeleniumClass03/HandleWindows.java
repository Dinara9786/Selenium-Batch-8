package com.review.SeleniumClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindows {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://syntaxtechs.com/selenium-practice/index.php");

        driver.findElement(By.linkText("Alerts & Modals")).click();
        driver.findElement(By.linkText("Window Popup Modal")).click();

        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent window handle " + parentHandle);

        // click

        driver.findElement(By.linkText("Follow On Instagram")).click();
        Set<String> handles = driver.getWindowHandles();

        // how to retrieve or access handles -- > iterator
        // create the iterator for handles

        Iterator<String> handleIt = handles.iterator();

        // 1. wihtout a loop

        parentHandle = handleIt.next();
        String childHandle = handleIt.next();
        //String handle3 = handleIt.next();

        System.out.println(parentHandle);
        System.out.println(childHandle);

        // Neter usernamne and password on child window and close them
        // Switch to child window

        driver.switchTo().window(childHandle);

        WebElement username = driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']"));
        username.sendKeys("admin");
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//input[@aria-label='Password']"));
        password.sendKeys("admin123");

        //driver.close();


    }

}

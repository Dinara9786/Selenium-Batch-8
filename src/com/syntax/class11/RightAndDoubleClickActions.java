package com.syntax.class11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class RightAndDoubleClickActions {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton = driver.findElement(By.xpath("//span[text() ='right click me']"));
        Actions action = new Actions(driver);

        action.contextClick(rightClickButton).perform(); // .contextClick() right clicking

        WebElement editOption = driver.findElement(By.xpath("//span[text() ='Edit']"));
        //editOption.click()
        Thread.sleep(3000);
        action.click(editOption).perform();

        Alert alert = driver.switchTo().alert();// we are using Alert interface and then switch to alert
        alert.accept();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text() ='Double-Click Me To See Alert']"));
        action.click(doubleClickButton).perform();

        System.out.println(doubleClickButton.getText());
        alert.accept();



    }
}

package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomeWork2 {

    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get(url);

        String parentHandle = driver.getWindowHandle();
        WebElement ajaxLink = driver.findElement(By.linkText("This is a Ajax link"));
        ajaxLink.click();

        WebElement text = driver.findElement(By.xpath("//div[@class = 'ContactUs']//p"));
        System.out.println("The Ajax text is => " + text.getText());


    }
}
package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Homework {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.uitestpractice.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Thread.sleep(3000);
        WebElement ajaxCall = driver.findElement(By.linkText("AjaxCall"));
        ajaxCall.click();

        WebElement ajaxLink = driver.findElement(By.xpath("//a[text() ='This is a Ajax link']"));
        ajaxLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='ContactUs']")));

        WebElement ajaxLinkText = driver.findElement(By.xpath("//div[@class ='ContactUs']"));

        String ajaxText = ajaxLinkText.getText();
        System.out.println("This is Ajax Link Text ==> " + ajaxText);

        driver.close();
    }
}

package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.syntax.utils.CommonMethods;

public class JSExecutorDemo2 extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://amazon.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); // scroll down

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -500)"); // scroll up

        WebElement backToUp = driver.findElement(By.xpath("//span[text() = 'Back to top']"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true)", backToUp);


    }
}

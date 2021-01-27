package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeWorkNotMIne {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String parHandle = driver.getWindowHandle();
        //click on New Tab and print the text from new tab in the console
        WebElement newTab= driver.findElement(By.id("tabButton"));
        newTab.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windod:windowHandles
        ) {
            if(!windod.equals(parHandle)){
                driver.switchTo().window(windod);
                WebElement text = driver.findElement(By.cssSelector("h1#sampleHeading"));
                System.out.println("Here is the text: "+ text.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parHandle);
        //click on New Window and print the text from new window in the console
        WebElement newWindow = driver.findElement(By.cssSelector("button#windowButton"));
        newWindow.click();
        Thread.sleep(2000);
        Set<String>windHandl = driver.getWindowHandles();
        Iterator<String> iterator = windHandl.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(!next.equals(parHandle)){
                driver.switchTo().window(next);
                driver.manage().window().maximize();
                WebElement text = driver.findElement(By.cssSelector("h1#sampleHeading"));
                System.out.println("Here is the text: "+ text.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parHandle);
        //click on New Window Message and print the text from new window in the console
        WebElement newWindMess =driver.findElement(By.cssSelector("button#messageWindowButton"));
        newWindMess.click();
        Thread.sleep(2000);
        Set<String> windowHandles1 = driver.getWindowHandles();
        for (String winHand:windowHandles1
        ) {
            if(!winHand.equals(parHandle)){
                driver.switchTo().window(winHand);
                driver.manage().window().maximize();
                WebElement text = driver.findElement(By.xpath("//body"));
                System.out.println("Text is: " +text.getText());
                driver.close();
            }
        }
        //Verify the title is displayed
        //Print out the title of the all pages
        driver.switchTo().window(parHandle);
        newTab.click();
        newWindow.click();
        newWindMess.click();
        Set<String> windowHandles2 = driver.getWindowHandles();
        for (String han :windowHandles2
        ) {
            driver.switchTo().window(han);
            if(!driver.getTitle().isEmpty()){
                System.out.println("Here is the title: "+driver.getTitle());
            }
            else
            {
                System.out.println("Title is empty");
            }
        }
        Thread.sleep(2000);
        driver.quit();

}
}

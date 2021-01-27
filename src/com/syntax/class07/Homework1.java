package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework1 {

    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(url); // with navigate we do not have to wait until the page loaded completely

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// managing timeouts and

        String mainPageHandle = driver.getWindowHandle();
        System.out.println("Parent window => " + mainPageHandle);
        WebElement newTabBtn = driver.findElement(By.xpath("//button[text() = 'New Tab']"));
        newTabBtn.click();
        Thread.sleep(2000);

        Set <String> allWindowHandles = driver.getWindowHandles();

        Iterator<String> it = allWindowHandles.iterator();
        while(it.hasNext()) {
            String childHandle1 = it.next();
            if (!childHandle1.equals(mainPageHandle)) {
                driver.switchTo().window(childHandle1);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                WebElement title1 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
                System.out.println("information : "+title1.getText());
                driver.close();
            }
        }

        driver.switchTo().window(mainPageHandle);

        WebElement newWindowBtn = driver.findElement(By.xpath("//button[text() = 'New Window']"));
        newWindowBtn.click();
        Thread.sleep(2000);
        Set<String> allWindowHandles2 = driver.getWindowHandles();

        Iterator <String>  it2 = allWindowHandles2.iterator();

        while (it2.hasNext()) {
            String childHandle2 = it2.next();
            if (!childHandle2.equals(mainPageHandle)) {
                driver.switchTo().window(childHandle2);
                String childHandle2Text = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println("New Window Text is =>" + childHandle2Text);
                driver.close();
            }
        }

        driver.switchTo().window(mainPageHandle);

        WebElement newWindowMessageBtn= driver.findElement(By.id("messageWindowButton"));
        newWindowMessageBtn.click();
        Thread.sleep(2000);
        Set<String> it3 = driver.getWindowHandles();

        for (String iterator3 : it3) {
            if (!iterator3.equals(mainPageHandle)) {
                driver.switchTo().window(iterator3);
                WebElement windowText = driver.findElement(By.xpath("//body"));
                String text = windowText.getText();
                System.out.println(text);
                driver.close();
            }
        }

        driver.switchTo().window(mainPageHandle);

    }
}

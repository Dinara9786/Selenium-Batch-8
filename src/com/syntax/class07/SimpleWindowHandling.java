package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {

    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
           System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get(url);

            String mainPageHandle = driver.getWindowHandle(); // getting current window handle
        System.out.println("Parent handle = " + mainPageHandle);

        WebElement helpLInk = driver.findElement(By.linkText("Help"));
        helpLInk.click();

        Set <String> allWindowHandles = driver.getWindowHandles(); // will automatically return LinkedHashSet
        System.out.println(allWindowHandles.size());
        Iterator<String> it = allWindowHandles.iterator(); // iterating through windows
        mainPageHandle = it.next();// stepping forward to main page. mainPage is the first step,
                                    // it is the first handle
                                    // main page is parent page, default page
        String childHandle = it.next(); // steppig forward to child
        System.out.println("Child handle = "+ childHandle);

        // i want to get back to my main page
        Thread.sleep(4000);
        driver.switchTo().window(mainPageHandle);// switching back to parent window
        //driver.close();
        driver.quit();



        }
    }


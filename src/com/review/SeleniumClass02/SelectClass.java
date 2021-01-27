package com.review.SeleniumClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class SelectClass {

    public static void main(String[] args) throws InterruptedException {

        // WE HANDLE DROP DOWN MENUS IN TWO WAYS
        // 1 OPTION. IF TAGNAME IS SELECT ==> WE WILL USE SELECGT CLASS
        // 2 OPTION. IF TAGNAME IS NOT SELECT ==> WE WILL USE LIST<WEBELEMENTS> ==> SAME WITH RADIO BUTTONS ADN
        // CHECK BOXES

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // 1. navigate to facebook.com
        String url = "http://www.facebook.com";
        driver.get(url);


        // 2. click on Create on  new account
        driver.findElement(By.id("u_0_2")).click();

        Thread.sleep(2000);
        // 3. Select July 15, 2016

        // write the webelement of DD menu which starts with select tag
        WebElement monthDD = driver.findElement(By.id("month"));

        // create an object select class
        Select monthSelect = new Select(monthDD);

        // select the option you want
            // 1. selectByVisibleText
        monthSelect.selectByVisibleText("Jul");

        Thread.sleep(2000);

        //Create WebElement of day select dropdown menu

        WebElement days = driver.findElement(By.id("day"));

        // Create an object of Select class

        Select dSelect = new Select(days);

        // select the option you want

        dSelect.selectByIndex(17);

        Thread.sleep(2000);

        //List<WebElement> month = monthSelect

        // 1. Create web element of year drow down menu

        WebElement years = driver.findElement(By.id("year"));

        // 2. Create an object of seldect class

        Select ySelect = new Select (years);

        // 3. Select teh year you want

        //ySelect.selectByValue("1970");

        Thread.sleep(2000);

        List<WebElement> yOptions = ySelect.getOptions();

        Iterator<WebElement> yOpt = yOptions.iterator();
        while (yOpt.hasNext()) {
            WebElement yy = yOpt.next();
            if (yy.getAttribute("value").equals("1970")){
                yy.click();

            }
        }

    }
}

package com.review.SeleniumClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {
        // what is radio button

        // how we can handle radio buttons

        // write the WebElement of the spedific option adn clikc on it

        // write WebElements of all options inside a list <WebElements> and click on a specific option

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            // 1. navigate to facebook.com
            String url = "http://www.facebook.com";
            driver.get(url);

            // 2. click on Create on  new account
            driver.findElement(By.id("u_0_2")).click();

            Thread.sleep(2000);
            // 3. Click on Female button


        WebElement femaleBtn = driver.findElement(By.xpath("//label[text() = 'Female']"));
//        femaleBtn.click();
        String classValue =femaleBtn.getAttribute("class");
        System.out.println("female button attribute value is = " + classValue);
        Thread.sleep(2000);

        String visibleText = femaleBtn.getText();
        System.out.println("Visible text of female button is = " + visibleText);

        // save all options in a List<WebElement> and click on the available option and iterate through the list

        List<WebElement> genderOptions = driver.findElements(By.xpath("//input[@name='sex']"));

        // 1. regular for loop
        // 2. enhanced or for each loop
        // 3. iterator

//        for (WebElement option : genderOptions) {
//            option.click();
//            System.out.println(option.getText());
//
//            Thread.sleep(2000);

//        Iterator <WebElement> gIT = genderOptions.iterator();
//        while (gIT.hasNext()) {
//            WebElement genderBtn = gIT.next();
//            if (genderBtn.getAttribute("value").equals("2")) { // getAttributed = gets attribute
//                genderBtn.click();
//            }
//        }

        }
    }


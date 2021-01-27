package com.review.SeleniumClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class CheckBoxRecap {

            public static void main(String[] args) throws InterruptedException {

                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

                WebDriver driver = new ChromeDriver();

                driver.manage().window().maximize();

                // 1. navigate to facebook.com
                String url = "http://syntaxtechs.com/selenium-practice/";
                driver.get(url);

                // then navigate to check box practice page

                driver.findElement(By.linkText("Input Forms")).click();
                Thread.sleep(2000);

                driver.findElement(By.linkText("Checkbox Demo")).click();

                // 1 option: Click on the requested button
                // 2 option: save WebElements of all optiosn inside a List<WebElement> and iterate through it and
                // click on the requested option

                List<WebElement> options = driver.findElements(By.cssSelector("input.cb1-element"));

                //options.get(2).click(); // we can directly click on the element

                Thread.sleep(2000);
                // checkign all the boxes Using iterator
//                Iterator<WebElement> option = options.iterator();
//                while(option.hasNext()) {
//                   WebElement opt =  option.next();
//                   opt.click();

//                }

                // checkign all the boxes Using regular For Loop
//                for (int i = 0; i<options.size(); i++) {
//                    options.get(i).click();
//                    Thread.sleep(2000);
//                }

                for (int i=0; i<options.size(); i++) {
                    if(options.get(i).getAttribute("value").equals("Option-4")){
                        options.get(i).click();
                    }
                }

    }
}

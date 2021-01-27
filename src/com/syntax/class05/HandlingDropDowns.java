package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingDropDowns {

    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);
        WebElement daysDD = driver.findElement(By.id("select-demo"));
        Select select = new Select(daysDD);// create an object of a select class
//        select.selectByIndex(2); // select by index
//        Thread.sleep(2000);
//
//        select.selectByVisibleText("Wednesday");
//        Thread.sleep(1000);
//        select.selectByValue("Sunday");

        List<WebElement> allOptions = select.getOptions();
        int size = allOptions.size();
        System.out.println(size); // we have 8 options including "Please select"

        for(int i = 0; i<allOptions.size(); i++) {
            String optionText = allOptions.get(i).getText(); // when we use method back to back we call it chaining
            System.out.println(optionText);
            select.selectByIndex(i);
            Thread.sleep(2000);
        }
    }
}

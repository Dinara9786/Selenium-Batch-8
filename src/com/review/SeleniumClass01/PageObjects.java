package com.review.SeleniumClass01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjects {

    public static void main(String[] args) {

        // What is a WebElement or PageObject
        //links, text boxes, radio button, check boxes, drop down menus, images, buttons
        // in Selenium is the most important issue to locate element. We need to provide addres of the element we
        //work on, location of the webelement

        // for Selenium to do actions on page elements we have to provide location of each web element

        // How do we tell the location of page objects to Selenium? = > Locators in Selenium

        // id, tagName, xpath, css, class, linkText, partialLinkText


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String amazonUrl = "http://www.amazon.com";
        driver.get(amazonUrl);

        // locating by ID
        //WebElement deptBtn = driver.findElement(By.id("searchDropdownBox"));
//                deptBtn.click();
//                deptBtn.isDisplayed();
//                deptBtn.isEnabled();
//                deptBtn.isSelected();

        //locating by name attribute

//        WebElement deptBtn1 = driver.findElement(By.name("url"));
//        deptBtn1.click();

        // 3. locating by linkText --> tag name must be <a> -- > we have a text which is not assigned to any attribute
    }
}

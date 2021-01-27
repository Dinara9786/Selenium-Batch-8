package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingDynamicWebTables {

    public static String url = "http:secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(url);

       WebElement userName = driver.findElement(By.xpath("//input[contains(@name, 'username')]"));
       userName.sendKeys("Tester");

       WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
       password.sendKeys("test");

       WebElement loginButton =  driver.findElement(By.xpath("//input[@value = 'Login']"));
       loginButton.click();

       List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr"));
                                                            // stroign all the
        System.out.println(rows.size());

        for (int i=1; i<rows.size(); i++) { // starting to loop
            String rowText = rows.get(i).getText(); // getting the text
            System.out.println(rowText);
            if(rowText.contains("Bob Feather")) {//setting a condition to click on checkbox
                driver.findElements(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr/td[1]"))
                        .get(i-1).click(); //locating all the checkboxes and grabbing a single row checkbox and clicking
                break;
            }
        }
    }
}

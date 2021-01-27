package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EbayHW {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String URL = "https://www.ebay.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement allCategories = driver.findElement(By.xpath("//select[@id='gh-cat']"));

        Select select = new Select(allCategories);

        List<WebElement> allCatOption = select.getOptions();
        for (int i = 0; i < allCatOption.size(); i++) {
            String getTextOption = allCatOption.get(i).getText();
            System.out.println(getTextOption);
            if(getTextOption.equalsIgnoreCase("Computers/Tablets & Networking")){
                System.out.println();
                System.out.println("***********************Selecting***********************");
                System.out.println();
                select.selectByVisibleText(getTextOption);
            }
        }

        WebElement searchButton = driver.findElement(By.xpath("//input[@value = 'Search']"));
        searchButton.click();
    }
}


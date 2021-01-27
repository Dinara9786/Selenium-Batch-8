package com.review.SeleniumClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathContinued {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
         String url = "http://syntaxtechs.com/selenium-practice/index.php";
        driver.get(url);


    // tagname[cotains(@attribute, 'attributeValue'])
    // tagname[starts-with(@attribute, 'attributeValue'])

    // tagname[contains(text(), 'textValue']
    // tagname[starts-with(text(), 'textValue']

        WebElement logo1=driver.findElement(By.xpath("(//img[contains(@src, 'syntaxlogowhite')])[1]"));
        System.out.println("Is logo 1 displayed = " + logo1.isDisplayed());

        WebElement logo2 = driver.findElement(By.xpath("(//img[starts-with(@src, 'img/syntax')])[2]"));
        System.out.println("Is logo 2 displayed = " + logo2.isDisplayed());

        Thread.sleep(2000);

        //WebElement text = driver.findElement()

    }
}



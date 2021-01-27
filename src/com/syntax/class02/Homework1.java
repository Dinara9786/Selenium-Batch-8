package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

    // 1. navigate to website
    // https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
    //2. enter all the fields
    //3. click on register
    //4. close the browser

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.manage().window().maximize();
        driver.findElement(By.id("customer.firstName")).sendKeys("Maria");
        driver.findElement(By.name("customer.lastName")).sendKeys("Ivanova");
        driver.findElement(By.id("customer.address.street")).sendKeys("Moskovskaya Str.");
        driver.findElement(By.name("customer.address.city")).sendKeys("Moscow");
        driver.findElement(By.id("customer.address.state")).sendKeys("Metro");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("654987");
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("6321654");
        driver.findElement(By.id("customer.ssn")).sendKeys("987654321");
        driver.findElement(By.id("customer.username")).sendKeys("MariaIvanova");
        driver.findElement(By.id("customer.password")).sendKeys("Ivanova");
        driver.findElement(By.name("repeatedPassword")).sendKeys("Ivanova");
        driver.findElement(By.className("button")).click();
        Thread.sleep(2000);
        driver.close();

    }

}

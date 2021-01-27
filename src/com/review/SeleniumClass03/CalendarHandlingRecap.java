package com.review.SeleniumClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalendarHandlingRecap {

    /*
    how many ways to pick up a date from a calendar
    1. sendText
    2.
    3.

     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        // navigate to Project Report page

        Actions action = new Actions(driver);

        WebElement time = driver.findElement(By.linkText("Time"));

        Thread.sleep(3000);
        action.moveToElement(time).perform();

        WebElement reports = driver.findElement(By.linkText("Reports"));
        Thread.sleep(3000);

        action.moveToElement(reports).perform();

        WebElement projectReports = driver.findElement(By.linkText("Project Reports"));

        Thread.sleep(3000);
        action.click(projectReports).perform();

        // send the date to the calendar text box

//        WebElement calendar = driver.findElement(By.id("project_date_range_from_date"));
//        calendar.sendKeys("2021-01-07");

        Thread.sleep(3000);
        WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonth = new Select(monthDD);

        // select month by visible text
        selectMonth.selectByVisibleText("Jul");

        // select year by using List of <WebElement>
        Thread.sleep(3000);
        List<WebElement> yearsDD = driver.findElements(By.xpath("//select[@class='ui-datepicker-year']/option"));

        for (WebElement year : yearsDD) {
            if (year.getText().equals("2017")){
                year.click();
                break;

            }
        }
        Thread.sleep(3000);
        List <WebElement> dayTable = driver.findElements(By.xpath("//input[@id = 'project_date_range_from_date']/tbody/tr/td"));

        for (WebElement day: dayTable) {
            if (day.getText().equals("18")) {
                day.click();
                break;
            }
        }

    }


}

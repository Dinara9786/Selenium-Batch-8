package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingCalendars1 {

    public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("Admin");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys("Hum@nhrm123");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();

        WebElement leaveButton = driver.findElement(By.linkText("Leave"));;
        leaveButton.click();

        WebElement leaveList = driver.findElement(By.linkText("Leave List"));
        leaveList.click();

        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement mDD = driver.findElement(By.className("ui-datepicker-month"));
        Select monthDD = new Select(mDD);
        monthDD.selectByVisibleText("Jul");

        WebElement yDD = driver.findElement(By.className("ui-datepicker-year"));
        Select yearDD = new Select(yDD);
        yearDD.selectByVisibleText("2021");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement fromDate : fromDates) {
            if (fromDate.getText().equals("4")) {
                Thread.sleep(2000);
                fromDate.click();
                break;
            }
        }

            WebElement toDate = driver.findElement(By.xpath("//input[@id = 'calToDate']"));
            toDate.click();

            WebElement monthDDback = driver.findElement(By.className("ui-datepicker-month"));
            Select monthBack = new Select(monthDDback);
            monthBack.selectByVisibleText("Jul");

            WebElement yearDDBack = driver.findElement(By.className("ui-datepicker-year"));
            Select yearBack = new Select(yearDDBack);
            yearBack.selectByVisibleText("2021");

            List<WebElement> dateBack = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
            for (WebElement date : dateBack) {
                if (date.getText().equals("27")) {
                    date.click();
                    break;
                }
            }

            WebElement rejectedButton = driver.findElement(By.xpath("//label[text()='Rejected']"));
            rejectedButton.click();
            Thread.sleep(3000);

            WebElement cancelButton = driver.findElement(By.xpath("//label[text()='Cancelled']"));
            cancelButton.click();
            Thread.sleep(3000);

            WebElement approvalButton = driver.findElement(By.xpath("//label[text()='Pending Approval']"));
            approvalButton.click();
           // Thread.sleep(3000);
           //approvalButton.clear();

            Thread.sleep(3000);
            WebElement sectorDD = driver.findElement(By.id("leaveList_cmbSubunit"));
            Select sDD = new Select(sectorDD);
            sDD.selectByVisibleText("IT Support");

            Thread.sleep(3000);
            WebElement searchButton = driver.findElement(By.id("btnSearch"));
            searchButton.click();
            Thread.sleep(5000);
            driver.quit();


        }
    }


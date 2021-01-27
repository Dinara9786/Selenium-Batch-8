package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarHandling {

       public static String url = "http://delta.com";

        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get(url);
            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
            calendar.click();

            WebElement dMonth = driver.findElement(By.className("dl-datepicker-month-0"));
            String departMonthText = dMonth.getText();

            WebElement nextButton = driver.findElement(By.xpath("//span[text() = 'Next']"));

            while(!departMonthText.equals("July")) {
                nextButton.click();
                departMonthText = dMonth.getText();
            }
                List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
                for (WebElement departDate : departDates) {
                    if (departDate.getText().equals("4")) {
                        departDate.click();
                        break;

                    }
                }

                WebElement returnMonths = driver.findElement(By.xpath("//span[@class = 'dl-datepicker-month-1']"));
                String returnMonth = returnMonths.getText();

                while(!returnMonth.equals("August")) {
                    nextButton.click();
                    returnMonth = returnMonths.getText();
                }
                    List <WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
                    for (WebElement returnDate : returnDates) {
                        if (returnDate.getText().equals ("7")) {
                            returnDate.click();
                            break;
                        }
                    }

                    WebElement doneButton = driver.findElement(By.className("donebutton"));
                    doneButton.click();
                }

            }



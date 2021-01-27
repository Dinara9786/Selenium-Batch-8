package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Facebook {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String URL = "https://www.facebook.com";
        driver.get(URL);
        driver.findElement(By.xpath("//a[contains(@data-testid,'open')]")).click();
        //Fill FirstName,LastName, email and password
        WebElement firstName = driver.findElement(By.xpath("//input[contains(@name,'firstname')]"));
        firstName.sendKeys("Pablo");
        WebElement secondName = driver.findElement(By.xpath("//input[contains(@name,'las')]"));
        secondName.sendKeys("Escobar123");
        WebElement password = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        password.sendKeys("pabloEscobar123@gmail.com");
        WebElement confemail= driver.findElement(By.xpath("//input[contains(@name,'confirma')]"));
        confemail.sendKeys("pabloEscobar123@gmail.com");
        WebElement passowrd = driver.findElement(By.cssSelector("input[data-type='password']"));
        passowrd.sendKeys("pabloNotEscobar123");
        //Number of month and selection October
        WebElement month = driver.findElement(By.id("month"));
        Select select = new Select(month);
        List<WebElement> allOptMonths = select.getOptions();
        int monthCount=0;
        for (int i = 0; i < allOptMonths.size(); i++) {
            String optMonthText = allOptMonths.get(i).getText();
            monthCount++;
            System.out.println(optMonthText);
            if(optMonthText.equalsIgnoreCase("oct")){
                select.selectByVisibleText("Oct");
                continue;
            }
        }
        if (monthCount==12){
            System.out.println("Test Passed , we have 12 month");
        }
        //Number of days and selecting '31'
        WebElement day = driver.findElement(By.xpath("//select[contains(@name,'birthday_d')]"));
        Select select1 = new Select(day);
        List <WebElement> allDays = select1.getOptions();
        int countDays =0;
        for (WebElement dayofMonth:allDays
        ) {
            String dayOf = dayofMonth.getText();
            System.out.println(dayOf);
            countDays++;
            if(dayOf.equalsIgnoreCase("31")){
                select1.selectByValue("31");
            }
        }
        if(countDays==31|| countDays==30){
            System.out.println("Test Passed, we have 31 day ");
        }
        //Verify if year has 115 options
        WebElement year = day.findElement(By.xpath("//select[contains(@name,'birthday_ye')]"));
        Select select2 = new Select(year);
        List<WebElement> allYears = select2.getOptions();
        int countYears=0;
        for (int i = 1; i <allYears.size() ; i++) {
            String optTextYear = allYears.get(i).getText();
            System.out.println(optTextYear);
            if(optTextYear.equalsIgnoreCase("1996")){
                select2.selectByValue("1996");
                continue;
            }
            countYears++;
        }
        System.out.println(countYears);
        if(countYears==115){
            System.out.println("We have 115 years, Test Passed");
        }
        //Select Gender
        List<WebElement> genders = driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement gender :genders
        ) {
            String textOfGender = gender.getAttribute("value");
            if(textOfGender.equalsIgnoreCase("2")){
                gender.click();
            }
        }
        //Click on SignUp Button and verify if Successful message displayed
        WebElement submit= driver.findElement(By.xpath("//button[contains(@name,'websubmi')]"));
        submit.click();
        WebElement emailVerif = driver.findElement(By.cssSelector("h2.uiHeaderTitle"));
        if(emailVerif.isDisplayed()){
            System.out.println("We have successfully created an account");
        }
    }
}


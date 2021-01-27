package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TaskFacebook {

    public static String url = "https://www.facebook.com/r.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);

        //WebElement signupBox = driver.findElement(By.xpath("//a[@class = '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        //signupBox.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@name ='firstname']"));
        firstName.sendKeys("Jane");

        WebElement lastName = driver.findElement(By.xpath("//input[@name ='lastname']"));
        lastName.sendKeys("Biden");

        WebElement emailOrPhone = driver.findElement(By.xpath("//input[@name ='reg_email__']"));
        emailOrPhone.sendKeys("987-654-321");

        WebElement password = driver.findElement(By.xpath("//input[@id ='password_step_input']"));
        password.sendKeys("Admin123");

//        WebElement selectMonth = driver.findElement(By.xpath("//select[@name ='birthday_month']"));
//        Select selectM = new Select(selectMonth);
//
//        List<WebElement> allOptions = selectM.getOptions();
//        int monthSize = allOptions.size();
//        System.out.println(monthSize);
//
//        for (WebElement optionM :allOptions) {
//            String monthText = optionM.getText();
//            if (monthText.equalsIgnoreCase("Jul")) {
//                selectM.selectByValue("Jul");


//        for (int i = 0; i < monthSize; i++) {
//            String monthText = allOptions.get(i).getText();
//            System.out.println(monthText);
//            if (monthText.equalsIgnoreCase("Jul")) {
//                selectM.selectByValue("Jul");
//            }
//        }
//        if (allOptions.size() - 1 == 12) {
//            System.out.println("The number of months is correct");
//        } else {
//            System.out.println("The number of months is incorrect");
//        }

        WebElement dayDD = driver.findElement(By.name("birthday_day"));
        Select selectD = new Select(dayDD);

        List<WebElement> day = selectD.getOptions();
        int sizeDay = day.size();
        System.out.println(sizeDay);

        for (WebElement days : day) {
            String dayText = days.getText();
            System.out.println(dayText);
            if (dayText.equalsIgnoreCase("18")) {
                selectD.selectByValue("18");
            }
        }
        if (day.size() - 1 == 31) {
            System.out.println("The number of days is correct");
        } else {
            System.out.println("The number of days is incorrect");
        }

        WebElement yearDD = driver.findElement(By.id("year"));

        Select selectY = new Select(yearDD);

        List<WebElement> year = selectY.getOptions();
        System.out.println(year.size());

        for (WebElement years : year) {
            String allYears = years.getText();
            if (allYears.equals("1970")) {
                selectY.selectByValue("1970");
            }
        }
        if (year.size() - 2 == 115) {
            System.out.println("The number of years is correct");
        } else {
            System.out.println("The number of years is incorrect");
        }

        //        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@id = 'u_0_6']"));
//        genderRadioButton.click();
//        boolean genderIsEnabled = genderRadioButton.isEnabled();
//        System.out.println("Gender Radio Button is Enanbled = " + genderIsEnabled);

        WebElement customButton = driver.findElement(By.xpath("//label[@for= 'u_0_6'] "));
        customButton.click();
        boolean customButtonisEnabled = customButton.isEnabled();
        System.out.println("Customs button is Enabled = > " + customButtonisEnabled);

        WebElement selectPronounDD = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
        Select selectPronoun = new Select(selectPronounDD);

        List<WebElement> selPronoun = selectPronoun.getOptions();
        int pronounSize = selPronoun.size();
        System.out.println(pronounSize);
        for (int j = 0; j < pronounSize; j++) {
            String pronounText = selPronoun.get(j).getText();
            System.out.println(pronounText);


            if (pronounText.contains("She")) {
                selectPronoun.selectByValue("She");
            }
        }
           WebElement submitButton = driver.findElement(By.xpath("//button[@name = 'websubmit']"));
            submitButton.click();
        }

    }











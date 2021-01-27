package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeworkUitest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

//		 navigate to: uitestpractice.com
        driver.get("http://www.uitestpractice.com");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


//	    naviate to AjaxCall = explicit wait and get it printed in console == done
        Thread.sleep(3000);
        WebElement ajaxCall = driver.findElement(By.linkText("AjaxCall"));
        ajaxCall.click();

        WebElement ajaxLink = driver.findElement(By.xpath("//a[text() ='This is a Ajax link']"));
        ajaxLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='ContactUs']")));

        WebElement ajaxLinkText = driver.findElement(By.xpath("//div[@class ='ContactUs']"));

        String ajaxText = ajaxLinkText.getText();
        System.out.println("This is Ajax Link Text ==> " + ajaxText);


//		WebElement testingControl = driver.findElement(By.xpath("//a[ text()='Testing Controls ']"));
//		testingControl.click();

        WebElement formPage = driver.findElement(By.linkText("Form"));
        formPage.click();

        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Elon");

        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Mask");

		List <WebElement> hobbyCheckBox = driver.findElements(By.xpath("//label[@class='checkbox-inline']"));
		for (WebElement hobby : hobbyCheckBox) {
		    if(hobby.getAttribute("value").equals("dance"));
		  hobby.click();
		   break;


            }


//        WebElement country = driver.findElement(By.id("sel1"));
//
//        Select select =new Select(country);
//        select.selectByVisibleText("Denmark");
//
//        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@placeholder='Enter Date of birth']"));
//        dateOfBirth.click();
//
//        WebElement birthMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
//        birthMonth.click();
//
//        Select selectMonth = new Select(birthMonth);
//        selectMonth.selectByVisibleText("Jul");
//
//        WebElement birthYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
//        birthYear.click();
//
//        Select selectYear = new Select(birthYear);
//        selectYear.selectByVisibleText("1970");
//
//        List<WebElement> birthDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
//
//        for (WebElement birthDate : birthDates) {
//            if (birthDate.getText().equals("18")) {
//                birthDate.click();
//                break;
//            }
//        }
//
//        WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder = 'Enter PhoneNumber']"));
//        phoneNumber.sendKeys("19786219786");
//
//        WebElement  username= driver.findElement(By.xpath("//input[@placeholder = 'Enter UserName']"));
//        username.sendKeys("Tesla");
//
//        WebElement  email = driver.findElement(By.id("email"));
//        email.sendKeys("Tesla@tesla.com");
//
//        WebElement  aboutYourselfBox = driver.findElement(By.id("comment"));
//        aboutYourselfBox.sendKeys("I am the best person ever. I love Tesla");
//        String commentText = aboutYourselfBox.getText();
//        System.out.println(commentText);
//
//        WebElement  password = driver.findElement(By.id("pwd"));
//        password.sendKeys("Tesla123!");

}

}

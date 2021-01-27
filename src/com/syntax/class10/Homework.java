package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework {

    public static WebElement nextButton;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aa.com/homePage.do");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement origin = driver.findElement(By.xpath("//a[@data-for = 'reservationFlightSearchForm.originAirport']"));
        origin.click();

        WebElement countryDD = driver.findElement(By.id("countryCode"));
        countryDD.click();
        Select select = new Select(countryDD);

        List<WebElement> allOptions = select.getOptions();
        for (WebElement option : allOptions) {
            String optionText = option.getText();
            if (optionText.equals("United States")) {
                select.selectByVisibleText("United States");

            }
        }

        WebElement stateDD = driver.findElement(By.id("stateCode"));
        stateDD.click();
        Select selectState = new Select(stateDD);

        List <WebElement> stateOptions = selectState.getOptions();
        for (WebElement stateOption : stateOptions) {
            String stateText = stateOption.getText();
            if (stateText.equals("California")){
                selectState.selectByVisibleText("California");
                break;
            }
        }
        List <WebElement> airportList = driver.findElements(By.xpath("//table[@id= 'airportsSection']/tbody/tr/td"));
        for (WebElement airport : airportList){
            if (airport.getText().contains("LAX")) {
                airport.click();
                break;
            }
        }

        WebElement destinationAirport = driver.findElement(By.xpath("//a[@data-for= 'reservationFlightSearchForm.destinationAirport']"));
        destinationAirport.click();

        WebElement countryDD2 = driver.findElement(By.id("countryCode"));
        countryDD2.click();
        Select destinationCountrySelectDD = new Select(countryDD2);

        List <WebElement> countryTo = destinationCountrySelectDD.getOptions();
        for (WebElement countryDestination : countryTo) {
            if (countryDestination.getText().contains("United States")) {
                destinationCountrySelectDD.selectByVisibleText("United States");
                break;
            }
        }

        Thread.sleep(2000);
        WebElement destinationStateDD = driver.findElement(By.xpath("//select[@id='stateCode']"));
        destinationStateDD.click();
        Select destinationStateSelect = new Select(destinationStateDD);

        List <WebElement> stateTo = destinationStateSelect.getOptions();
        for (WebElement stateOption : stateTo) {
            if (stateOption.getText().equals("District of Columbia")) {
                destinationStateSelect.selectByVisibleText("District of Columbia");
                break;
            }
        }

        List <WebElement> airportTo = driver.findElements(By.xpath("//table[@id= 'airportsSection']/tbody/tr/td"));
        for (WebElement airportOption:airportTo) {
            if (airportOption.getText().contains("DCA")) {
                airportOption.click();
            }
        }

        WebElement passengersDD = driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
        Select passengerSelect = new Select(passengersDD);

        List <WebElement> passengers= passengerSelect.getOptions();
        for (WebElement passenger : passengers) {
            if (passenger.getText().equals("3")) {
                passengerSelect.selectByValue("3");
            }
        }

        Thread.sleep(2000);
        WebElement departDates = driver.findElement(By.xpath("//input[@id='aa-leavingOn']"));
        departDates.click();
        boolean flag = true;
        while(flag) {
            WebElement departMonths = driver.findElement(By.xpath(
                    "//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']"));
            if (departMonths.getText().contains("March")) {
                List<WebElement> monthDepartTable = driver.findElements(By.xpath(
                        "//div[@class = 'ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//td"));
                for (WebElement monthTable : monthDepartTable) {
                    if (monthTable.getText().equals("8")) {
                        monthTable.click();
                        flag = false;
                        break;
                    }
                }
            } else {
                nextButton = driver.findElement(By.xpath("//a[@title = 'Next']"));
                nextButton.click();
            }

        }

        Thread.sleep(2000);
        flag = true;

        driver.findElement(By.xpath("//input[@id = 'aa-returningFrom']")).click();

        while(flag) {
            WebElement arrivalMonth = driver.findElement(
                    By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']"));

            if (arrivalMonth.getText().contains("May")) {
                List<WebElement> arrivalDates = driver.findElements(By.xpath(
                        "//div[@class='ui-datepicker-group ui-datepicker-group-last']//table//tbody//tr//td"));

                for (WebElement arrivalDate : arrivalDates) {
                    if (arrivalDate.getText().equals("27")) {
                        arrivalDate.click();
                        flag = false;
                        break;
                    }
                }
            }else {
                nextButton = driver.findElement(By.xpath("//a[@title = 'Next']"));
                nextButton.click();

                }
            }

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
        searchButton.click();

        driver.quit();
        }

    }


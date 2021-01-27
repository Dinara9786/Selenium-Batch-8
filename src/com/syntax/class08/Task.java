package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task {

        public static String url = "http://syntaxtechs.com/selenium-practice/dynamic-elements-loading.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.navigate().to(url);

        WebElement startButton = driver.findElement(By.id("startButton"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20); // creating webdriverwait object and setting fro 20 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Welcome Syntax')]")));
                                                                    // waiting until expected conditions"visitility"

        WebElement welcome = driver.findElement(By.xpath("//h4[contains(text(), 'Welcome Syntax')]"));

        // here is s shortcut: we can use * and it will find any tag with Welcome
        String welcomeText = welcome.getText();
        System.out.println("The welcome text is => " + welcomeText);


    }
}

package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.transform.sax.SAXSource;

public class Homework {

    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(url);

        WebElement checkBox = driver.findElement(By.xpath("//div[@id='checkbox']"));
        checkBox.click();

        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

       String text = removeButton.getText();
        System.out.println(text);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        WebElement removeText = driver.findElement(By.xpath("//p[@id='message']"));
        String message = removeText.getText();
        System.out.println("The text of remove button is => " + message);

        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()']"));
        enableButton.click();

        //WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        WebElement enableText = driver.findElement(By.xpath("//p[@id='message']"));
        String message2 = enableText.getText();
        System.out.println("The message of enable button is => " + message2);
        String actualMessage = "It's enabled!";
        boolean isEnabled = enableButton.isEnabled();
        System.out.println("The Enable Button is Enabled => " + isEnabled);
        if (enableButton.isEnabled()) {
            enableButton.sendKeys("Syntax Technologies");
        }
        WebElement disableButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()']"));
        disableButton.click();
        if (!disableButton.isEnabled()){
            System.out.println("The button is disabled");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'message']")));

        WebElement message3 = driver.findElement(By.xpath("//p[@id = 'message']"));

        String message3Text = message3.getText();
        System.out.println("Message of Disabled Button is ==> " + message3Text);

        Thread.sleep(3000);
        driver.close();

        }

    }

}

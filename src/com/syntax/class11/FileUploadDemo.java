package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import sun.security.acl.AclEntryImpl;

public class FileUploadDemo {

    public static WebDriver driver;
    public static String url = "https://the-internet.herokuapp.com";

    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    driver = new ChromeDriver();

    driver.manage().window().maximize();

        driver.get(url);

        WebElement fileUploadLilnk = driver.findElement(By.xpath("//a[text()='File Upload']"));
        fileUploadLilnk.click();

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));

        chooseFile.sendKeys("C:\\Users\\drysa\\Documents\\Dinara\\World Bank\\CV  Dinara S Rysalieva October 2020.doc");

        WebElement uploadButton =driver.findElement(By.id("file-submit"));
        uploadButton.click();


    }
}

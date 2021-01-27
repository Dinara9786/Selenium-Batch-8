package com.syntax.class11;

import com.syntax.testbase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomeworkDragAndDrop extends BaseClass {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

       driver = new ChromeDriver();

        driver.get("http://www.uitestpractice.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       // driver.switchTo().frame();

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions action = new Actions (driver);
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();


//        WebElement redContainer = driver.findElement(By.xpath("//div[@class = 'container red']"));
        //action.moveToElement(redContainer).perform();
        Thread.sleep(2000);
        WebElement doubleClick = driver.findElement(By.xpath("//button[text() = 'Double Click ME !']"));
        action.doubleClick(doubleClick).build().perform();
        //System.out.println("double click text =>> " + doubleClick.getText());
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        //driver.switchTo().frame("iframe_a");
       // WebElement enterNameBox = driver.findElement(By.xpath("//label[text() = 'Enter your name:']"));
        Thread.sleep(3000);
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
        driver.switchTo().frame(frameElement);

        WebElement enterNameBox = driver.findElement(By.xpath("//label[text()='Enter your name:']/following-sibling::input"));
        //input[@id = 'name']/parent::fieldset
        enterNameBox.sendKeys("Syntax Technologies");
        System.out.println(enterNameBox.getText());

        WebElement clickHereToWatchVideos = driver.findElement(By.xpath("//a[text() = 'Click here to watch videos on C#']"));
        clickHereToWatchVideos.click();




    }
}

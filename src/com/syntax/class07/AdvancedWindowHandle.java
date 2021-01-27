package com.syntax.class07;

import com.google.common.base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandle {
    public static String url = "http://syntaxtechs.com/selenium-practice/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);

        String mainPageHandle = driver.getWindowHandle();

        WebElement instaButton = driver.findElement(By.linkText("Follow On Instagram"));
        WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement instAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));

        instaButton.click();
        fbButton.click();
        instAndFbButton.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) { // start iteratig through handles
             String handle = it.next(); // get the next handle
            if (!handle.equals(mainPageHandle)) { // set a condition
                driver.switchTo().window(handle); // switch to a window whih is not equal to parent handle
                System.out.println(driver.getTitle());
                driver.close();
            }
        }

       // we need to switch to focus to main page if we want to click a child page again

        driver.switchTo().window(mainPageHandle); // switch back to parent
        instaButton.click();
    }
}



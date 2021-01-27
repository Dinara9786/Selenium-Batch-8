package com.review.SeleniumClass01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintingAllElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "http://www.amazon.com/";
        driver.get(url);
        // To find otu how many elements available on amazon and find how many oif them is not empty
        // and print all non-empty links

        // fineElement90 ------------- findElements(0
        // returns one element          returns list<WebElement>
        //

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links" + links.size());
        Thread.sleep(3000);

        int count = 0;
        int emptyCount = 0;
        for (WebElement link : links) {
            if(!link.getText().isEmpty()) {
                count++;
                System.out.println(link.getText());

            }else {
                emptyCount++;
            }
        }
        System.out.println("Number of non-empty list is == " + count) ;
        System.out.println("Number of empty list is == " + emptyCount) ;
    }
}

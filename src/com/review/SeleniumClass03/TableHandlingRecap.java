package com.review.SeleniumClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableHandlingRecap {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

    WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://syntaxtechs.com/selenium-practice/index.php");

        // navigate to Table Sort adn Search page
        driver.findElement(By.linkText("Table")).click();
        driver.findElement(By.linkText("Table Sort & Search")).click();

        // Print all headers

        String [] expHeaders={"Name", "Position", "Office", "Age", "Start date", "Salary"};
       List<WebElement> headers = driver.findElements(By.xpath("//table[@id='example']/thead/tr/th"));

//        int i = 0;
//        for (WebElement header : headers) {
//            String actHeader = header.getText();
//
//            if (actHeader.equals(expHeaders[i])){
//                System.out.println(actHeader + " is VALID");
//            }
//            i++;
//        }

//        for (int i = 0; i<headers.size(); i++) {
//            String actHeader = headers.get(i).getText();
//
//            if (actHeader.equals(expHeaders[i])){
//                System.out.println(actHeader + " is VALID");
//            }
//        }

//        WebElement header = driver.findElement(By.xpath("//table[@id='example']/thead/tr/th"));
//        System.out.println(header.getText());

        String header = driver.findElement(By.xpath("//table[@id='example']/thead/tr")).getText();
        System.out.println(header);

        // how we can do assertion with single String value

//        for (int i = 0; i<expHeaders.length; i++) {
//            if (header.contains(expHeaders[i])){
//                System.out.println(expHeaders[i] + " is VALID");
//            }
//        }
//
        // let us validate web table body

        // print all rows one by one

        List <WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));

        // how many rows we have

//        int rowCount=rows.size();
//        System.out.println("Number of rows is =>> " + rowCount);
//
//        for (WebElement row : rows){
//            System.out.println(row.getText());
//        }

        List <WebElement> cells = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td"));
        System.out.println("The number of cells is ==> " + cells.size());

//        for (int i = 0; i<cells.size(); i++) {
//            System.out.println(cells.get(i).getText()+  " - ");
//        }

        // while writing xpath if we use td we will get the cell
        // without td we will get the rows

        // can we get all values from a column???

        for (int i=0; i<cells.size(); i+=6) {
            System.out.println(cells.get(i).getText());

        }

        }

}


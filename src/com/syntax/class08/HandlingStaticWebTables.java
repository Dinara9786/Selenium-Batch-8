package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandlingStaticWebTables {

    public static String url = "http://syntaxtechs.com/selenium-practice/table-search-filter-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(url);

       List<WebElement> rowData = driver.findElements(By.xpath("//table[@id = 'task-table']/tbody/tr"));
        System.out.println("The size of rows is ==> " + rowData.size());
        System.out.println(rowData);

        // we are retrieving the data
        Iterator<WebElement> it = rowData.iterator();
        while(it.hasNext()) {
            WebElement element = it.next();
            String rowText = element.getText();
            System.out.println(rowText);

        }

        System.out.println("============================================");
        System.out.println();

        List<WebElement> colsData = driver.findElements(By.xpath("//table[@id = 'task-table']/thead/tr/th"));
        System.out.println("The number of columns => " + colsData.size());

        // retrieving headings
        for (WebElement col : colsData) {
            String colText = col.getText();
            System.out.println("The text of columns is == > " + colText) ;
        }

    }
}

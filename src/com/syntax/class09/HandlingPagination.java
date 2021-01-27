package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingPagination {

    public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("Admin");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys("Hum@nhrm123");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();

        WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
        pim.click();
        Thread.sleep(2000);

        WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployee.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Aaaa");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Aaaaaaa");

        WebElement empID = driver.findElement(By.id("employeeId"));
        String employeeID = empID.getAttribute("value");

        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();

        WebElement employeeListBtn = driver.findElement(By.linkText("Employee List"));
        employeeListBtn.click();

        boolean flag = true;
        while (flag) {
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = \'resultTable\']/tbody/tr"));
            for (int i=0; i<tableRows.size(); i++) {
                String rowText = tableRows.get(i).getText();
                if (rowText.contains(employeeID)) {
                    flag=false;

                    WebElement checkBox = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr["+ i +"]/td"));
                    checkBox.click();

                    WebElement deleteBtn = driver.findElement(By.xpath("//input[@id='btnDelete']"));
                    deleteBtn.click();

                    WebElement confirmDelete = driver.findElement(By.id("dialogDeleteBtn"));
                    confirmDelete.click();

                }
            }

            WebElement nextButton = driver.findElement(By.linkText("Next"));
            nextButton.click();
        }

    }
}

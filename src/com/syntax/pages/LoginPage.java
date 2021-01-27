package com.syntax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.syntax.utils.CommonMethods;

public class LoginPage extends CommonMethods {

    public WebElement usernameField = driver.findElement(By.id("txtUsername"));
    public WebElement passwordField = driver.findElement(By.id("txtPassword"));
    public WebElement loginButton = driver.findElement(By.id("btnLogin"));



}

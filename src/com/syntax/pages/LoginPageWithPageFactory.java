package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.syntax.utils.CommonMethods;

public class LoginPageWithPageFactory extends CommonMethods {

    // page factory is to initialize our webelements

    // this is our storage of webelements

    @FindBy(id= "txtUsername")
    public WebElement usernameTextbox;

    @FindBy(id = "txtPassword")
    public WebElement passwordTextbox;

    @FindBy(css = "input#btnLogin")
    public WebElement loginBtn;

    public void LoginPageWithPageFactory() {
        PageFactory.initElements(driver, this); // initiliazing our webelements.
        // first argument = >  using our driver
        // initialize elements only inside this class
    }
}

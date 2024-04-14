package resolver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(xpath = "//*[contains(@class,'form-signin')]//*[contains(@type,'email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[contains(@class,'form-signin')]//*[contains(@type,'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[contains(@class,'form-signin')]//*[contains(@type,'submit') and contains(text(),'Sign in')]")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isEmailInputVisible() {
        return emailInput.isDisplayed();
    }

    public boolean isPasswordInputVisible() {
        return passwordInput.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void loginVerification(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

public class LoginBizagi {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginBizagi() {
        this.driver = utils.BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='i0116']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id='idSIButton9']")
    private WebElement nextButton;

    @FindBy(xpath = "//*[@id='i0118']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='idSIButton9']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='menuListInbox']/a/span[2]")
    private WebElement exitoso;

    @FindBy(xpath = "//*[@id='passwordError']")
    private WebElement error;

    @FindBy(xpath = "//*[@id='js-btn-keep-session-open']")
    private WebElement timeout;




    public void login(String username, String password) {

        BaseTest.scrollAndType(driver, wait, usernameInput, username);
        BaseTest.scrollAndClick(driver, wait, nextButton);
        BaseTest.scrollAndType(driver, wait, passwordInput, password);
        BaseTest.scrollAndClick(driver, wait, loginButton);
    }


    // Verificar si el login fue exitoso
    public boolean isLoginSuccessful() {
        return isElementPresent(exitoso);
    }

    // Verificar si se muestra el mensaje de error
    public boolean isLoginErrorDisplayed() {
        return isElementPresent(error);
    }

    // Verificar si se muestra el mensaje de error
    public boolean pagueTimeOut() {
        return isElementPresent(timeout);
    }

    // Metodo genérico para verificar si un elemento está presente (Usando WebElement en lugar de By)
    private boolean isElementPresent(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
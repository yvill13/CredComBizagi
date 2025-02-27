package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseTest;

import java.time.Duration;

public class Home {

    private WebDriver driver;
    private WebDriverWait wait;

    public Home() {
        this.driver = utils.BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='Span1']")
    private WebElement desplegarNuevoCaso;

    @FindBy(xpath = "//span[text()='Solicitud Proyecto Crediticio BdB']")
    private WebElement nuevoCaso;

    @FindBy(xpath = "//span[text()='Agendamiento Comité BdB']")
    private WebElement agendarComite;

    @FindBy(xpath = "//*[@id='menuListInbox']/a/span[2]")
    private WebElement inbox;

    @FindBy(xpath = "//*[@id='user']/div/span")
    private WebElement config;

    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logout;

    @FindBy(xpath = "//*[@id='tilesHolder']/div[1]/div/div[1]/div/div[2]/div")
    private WebElement correctLog;



    public void abrirNuevoCaso() {

        BaseTest.scrollAndClick(driver,wait,desplegarNuevoCaso);
        BaseTest.scrollAndClick(driver,wait,nuevoCaso);
    }

    public void cerrarSesion() {

        for (int i = 0; i < 2; i++) { // 🔄 Intenta hasta 2 veces
            BaseTest.scrollAndClick(driver, wait, config);
            BaseTest.scrollAndClick(driver, wait, logout);

            // 🔍 Espera hasta que la pantalla de login reaparezca
            if (wait.until(ExpectedConditions.visibilityOf(correctLog)) != null) {
                System.out.println("✅ Logout exitoso");
                return;
            }

            System.out.println("🔄 Reintentando logout...");
        }
        Assert.fail("❌ No se logró cerrar sesión.");

    }


    // Verificar si el login fue exitoso
    public boolean closesesion() {

        return isElementPresent(correctLog);
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

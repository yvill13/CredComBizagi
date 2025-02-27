package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseTest;

import java.time.Duration;

public class RadSolPC {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[2]/div[1]/div/div/div[5]/div/div/div/div[2]/div/div/div/div/div/div[1]/div[3]/div[2]/label")
    private WebElement variablesSarcNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[2]/div[1]/div/div/div[5]/div/div/div/div[2]/div/div/div/div/div/div[1]/div[3]/div[1]/label")
    private WebElement variablesSarcSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[2]/div[1]/div/div/div[6]/div/div/div/div[1]/div/div/div/div[1]/div[3]/div[2]/label")
    private WebElement solicitaContructorNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[2]/div[1]/div/div/div[6]/div/div/div/div[1]/div/div/div/div[1]/div[3]/div[1]/label")
    private WebElement solicitaContructorSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[2]/div[1]/div/div/div[6]/div/div/div/div[2]/div/div/div/div[1]/div[3]/div[2]/label")
    private WebElement tieneConstructorNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[2]/div[1]/div/div/div[6]/div/div/div/div[2]/div/div/div/div[1]/div[3]/div[1]/label")
    private WebElement tieneConstructorSi;

    @FindBy(xpath = "//*[@id='formButton1']")
    private WebElement botonSiguiente;

    @FindBy(xpath = "//*[@id='formButton0']")
    private WebElement botonCancelar;

    public RadSolPC() {
        this.driver = utils.BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        PageFactory.initElements(driver, this);
    }

    public void sinConstructor(){

        BaseTest.scrollAndClick(driver,wait,variablesSarcNo);
        BaseTest.scrollAndClick(driver,wait,solicitaContructorNo);
        BaseTest.scrollAndClick(driver,wait,tieneConstructorNo);
        BaseTest.scrollAndClick(driver,wait,botonSiguiente);

    }

    public void validarPantallaRadSolPC() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[1]/p")));

        String textoActual = titulo.getText();
        String textoEsperado = "Radicación Proyecto Crediticio BdB › Radicar Solicitud PC";

        Assert.assertEquals(textoActual, textoEsperado, "El texto del encabezado no es el esperado.");

        System.out.println(textoActual);
    }














}

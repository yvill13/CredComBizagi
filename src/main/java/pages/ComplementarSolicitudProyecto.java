package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseTest;

import java.time.Duration;

public class ComplementarSolicitudProyecto {

    private WebDriver driver;
    private WebDriverWait wait;

    // Seleccionables del modulo Informacion Basica Detallada

    @FindBy(xpath = "//*[@id='ui-id-3']")
    private WebElement infoBasicaDetallada;

    // Seleccionables de la pestaña Informacion basica detallada

    @FindBy(xpath = "//*[@id='combo-c96b81c4-21aa-4a1c-9a2d-9405f8d179ca']")
    private WebElement bancaAtiende;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[1]/div[1]/div/div/div/div[1]/div[3]/div[1]/label")
    private WebElement familiarVinculadoSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[1]/div[1]/div/div/div/div[1]/div[3]/div[2]")
    private WebElement familiarVinculadoNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[2]/div[1]/div/div/div/div[1]/div[3]/div[1]/label")
    private WebElement empleadoSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[2]/div[1]/div/div/div/div[1]/div[3]/div[2]/label")
    private WebElement empleadoNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[3]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement vigiladoSuperSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[3]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement vigiladoSuperNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[4]/div[1]/div/div/div/div[1]/div[3]/div[1]/label")
    private WebElement aplicaCadenaValorSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[4]/div[1]/div/div/div/div[1]/div[3]/div[2]/label")
    private WebElement aplicaCadenaValorNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[1]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement declaraIvaSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[1]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement declaraIvaNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[2]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement financiaContratoSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement financiaContratoNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[5]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement reestructuracionSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[5]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement reestructuracionNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[6]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement garantiasSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[6]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement garantiasNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[1]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement requierePazYSalvoSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[1]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement requierePazYSalvoNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[2]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement finagroSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[2]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement finagroNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[3]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement relevanteSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[3]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement relevanteNo;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[6]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement solicitudesMenores500Si;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[6]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement solicitudesMenores500No;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[3]/div/div/div[1]/input")
    private WebElement ratingFinanciero;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[1]/div[4]/div/div/div[1]/input")
    private WebElement periodoCifrasFiscales;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[4]/div/div/div/div/div[5]/div[2]/div[4]/div/div/div[1]/input")
    private WebElement periodoCifrasFiscalesCasaMatriz;

    @FindBy(xpath = "//*[@id='combo-f6e51c48-8321-4419-bfaf-402f94baaf06']")
    private WebElement despliegaPresentaNiif;

    // Opciones de la lista desplegable Presenta NIIF

    @FindBy(xpath = "//*[@id='opt-1']")
    private WebElement presentaNiifG1;

    @FindBy(xpath = "//*[@id='opt-2']")
    private WebElement presentaNiifG2;


    @FindBy(xpath = "//*[@id='ui-id-4']")
    private WebElement infoRelacionados;

    @FindBy(xpath = "//*[@id='ui-id-5']")
    private WebElement grupoEconomico;

    // Seleccionables Grupo economico

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-227c588e-889e-418c-8cdf-0cb58102f7c4']/div[3]/div[1]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement revisionGrupoEconomicoSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-227c588e-889e-418c-8cdf-0cb58102f7c4']/div[3]/div[1]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement revisionGrupoEconomicoNo;

    @FindBy(xpath = "//*[@id='ui-id-6']")
    private WebElement historicoObservaciones;

    // Modulo Dueños de Negocio

    @FindBy(xpath = "//*[@id='M_Solicitud_kmSolicitante_xDuenosNegocio']/div/div[2]/div[1]/table/tbody/tr[1]/td[9]/div/div/span/div/label")
    private WebElement seleccionDueñoNegocio;

    // Modulo Gestion Realizada

    @FindBy(xpath = "//*[@id='combo-25908ceb-4a80-49c7-b0f1-09b6c981ab6e']")
    private WebElement desplegarAccionSeguir;

    @FindBy(xpath = "//*[@id='opt-1']")
    private WebElement continuarSolicitud;

    @FindBy(xpath = "//*[@id='opt-2']")
    private WebElement desistir;

    @FindBy(xpath = "//*[@id='opt-3']")
    private WebElement consultarDetallada;

    @FindBy(xpath = "//*[@id='opt-15']")
    private WebElement consultarBasicaMiembrosGrupo;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[2]/div[1]/div/div/div[5]/div/div[3]/div/div/div[1]/textarea")
    private WebElement observaciones;

    @FindBy(xpath = "//*[@id='formButton1']")
    private WebElement siguiente;




    public ComplementarSolicitudProyecto() {
        this.driver = utils.BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }


    public void validarTituloPagComplementar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[1]/p")));

        String textoActual = titulo.getText();
        String textoEsperado = "Radicación Proyecto Crediticio BdB › Complementar Solicitud Proyecto";

        Assert.assertEquals(textoActual, textoEsperado, "El texto del encabezado no es el esperado.");

        System.out.println(textoActual);
    }

    public void solicitudCaminoFeliz(String rating, String cifrasFiscales, String cifrasFiscalesCasaMatriz, String observacion) {

        BaseTest.scrollAndClick(driver,wait,familiarVinculadoNo);
        BaseTest.scrollAndClick(driver,wait,empleadoNo);
        BaseTest.scrollAndClick(driver,wait,vigiladoSuperNo);
        BaseTest.scrollAndClick(driver,wait,aplicaCadenaValorNo);
        BaseTest.scrollAndClick(driver,wait,declaraIvaSi);
        BaseTest.scrollAndClick(driver,wait,financiaContratoSi);
        BaseTest.scrollAndClick(driver,wait,reestructuracionNo);
        BaseTest.scrollAndClick(driver,wait,garantiasNo);
        BaseTest.scrollAndClick(driver,wait,requierePazYSalvoNo);
        BaseTest.scrollAndClick(driver,wait,finagroSi);
        BaseTest.scrollAndClick(driver,wait,relevanteNo);
        BaseTest.scrollAndClick(driver,wait,solicitudesMenores500No);

        BaseTest.scrollAndType(driver,wait,ratingFinanciero,rating);
        BaseTest.scrollAndType(driver,wait,periodoCifrasFiscales,cifrasFiscales);
        BaseTest.scrollAndType(driver,wait,periodoCifrasFiscalesCasaMatriz,cifrasFiscalesCasaMatriz);

        BaseTest.scrollAndClick(driver,wait,despliegaPresentaNiif);
        BaseTest.scrollAndClick(driver,wait,presentaNiifG2);

        BaseTest.scrollAndClick(driver,wait,seleccionDueñoNegocio);

        BaseTest.scrollAndClick(driver,wait,grupoEconomico);
        BaseTest.scrollAndClick(driver,wait,revisionGrupoEconomicoNo);

        BaseTest.scrollAndClick(driver,wait,desplegarAccionSeguir);
        BaseTest.scrollAndClick(driver,wait,continuarSolicitud);
        BaseTest.scrollAndType(driver,wait,observaciones,observacion);

        BaseTest.scrollAndClick(driver,wait,siguiente);











//        wait.until(ExpectedConditions.elementToBeClickable(grupoEconomico)).click();
//        BaseTest.UIHelper.scrollAndClick(driver,wait,revisionGrupoEconomicoNo);

    }








//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[1].scrollIntoView(true);", familiarVinculadoNo);
//        wait.until(ExpectedConditions.elementToBeClickable(familiarVinculadoNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", empleadoNo);
//        wait.until(ExpectedConditions.elementToBeClickable(empleadoNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", vigiladoSuperNo);
//        wait.until(ExpectedConditions.elementToBeClickable(vigiladoSuperNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", aplicaCadenaValorNo);
//        wait.until(ExpectedConditions.elementToBeClickable(aplicaCadenaValorNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", declaraIvaNo);
//        wait.until(ExpectedConditions.elementToBeClickable(declaraIvaNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", financiaContratoNo);
//        wait.until(ExpectedConditions.elementToBeClickable(financiaContratoNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", reestructuracionNo);
//        wait.until(ExpectedConditions.elementToBeClickable(reestructuracionNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", garantiasNo);
//        wait.until(ExpectedConditions.elementToBeClickable(garantiasNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", requierePazYSalvoNo);
//        wait.until(ExpectedConditions.elementToBeClickable(requierePazYSalvoNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", finagroNo);
//        wait.until(ExpectedConditions.elementToBeClickable(finagroNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", relevanteNo);
//        wait.until(ExpectedConditions.elementToBeClickable(relevanteNo)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", solicitudesMenores500No);
//        wait.until(ExpectedConditions.elementToBeClickable(solicitudesMenores500No)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", despliegaPresentaNiif);
//        wait.until(ExpectedConditions.elementToBeClickable(despliegaPresentaNiif)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", presentaNiifG1);
//        wait.until(ExpectedConditions.elementToBeClickable(presentaNiifG1)).click();
//
//        js.executeScript("arguments[0].scrollIntoView(true);", ratingFinanciero);
//        wait.until(ExpectedConditions.elementToBeClickable(ratingFinanciero)).click();
//        wait.until(ExpectedConditions.visibilityOf(ratingFinanciero)).sendKeys(rating);
//
//        js.executeScript("arguments[0].scrollIntoView(true);", periodoCifrasFiscales);
//        wait.until(ExpectedConditions.elementToBeClickable(periodoCifrasFiscales)).click();
//        wait.until(ExpectedConditions.visibilityOf(periodoCifrasFiscales)).sendKeys(periodoCifras);
//
//        js.executeScript("arguments[0].scrollIntoView(true);", periodoCifrasFiscalesCasaMatriz);
//        wait.until(ExpectedConditions.elementToBeClickable(periodoCifrasFiscalesCasaMatriz)).click();
//        wait.until(ExpectedConditions.visibilityOf(periodoCifrasFiscalesCasaMatriz)).sendKeys(periodoCifrasCasaMatriz);






}

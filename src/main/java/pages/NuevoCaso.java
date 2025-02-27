package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class NuevoCaso {
    private WebDriver driver;
    private WebDriverWait wait;

    public NuevoCaso() {
        this.driver = utils.BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);

        tipoIdElementMap.put("CC", idCedula);
        tipoIdElementMap.put("CE", idCedulaExtranjeria);
        tipoIdElementMap.put("TI", idTarjetaIdentidad);
        tipoIdElementMap.put("RC", idRegistroCivil);
        tipoIdElementMap.put("PS", idPasaporte);
        tipoIdElementMap.put("RUT", idRut);
        tipoIdElementMap.put("NIT", idNit);
        tipoIdElementMap.put("PA", idPatrimonioAutonomo);
        tipoIdElementMap.put("NEX", idNitExtranjeria);
        tipoIdElementMap.put("ESN", idSociedadExtranjeraSinNit);
    }

    // Se localizan los elementos de la opcion "Tipo de solicitud"

    @FindBy(xpath = "//*[@id='combo-88b067ae-f3d7-43a2-ab27-d30ce4f56559']")
    private WebElement desplegarTipoSolicitud;

    @FindBy(xpath = "//*[@id='opt-1']")
    private WebElement tipoSolicitudNueva;

    @FindBy(xpath = "//*[@id='opt-2']")
    private WebElement tipoSolicitudRenovacion;

    @FindBy(xpath = "//*[@id='opt-3']")
    private WebElement tipoSolicitudModificacion;

    @FindBy(xpath = "//*[@id='opt-4']")
    private WebElement tipoSolicitudPrueba_07QA;

    @FindBy(xpath = "//*[@id='opt-5']")
    private WebElement tipoSolicitudNormalizacion;

    @FindBy(xpath = "//*[@id='opt-6']")
    private WebElement tipoSolicitudAdicionComercial;

    @FindBy(xpath = "//*[@id='opt-7']")
    private WebElement tipoSolicitudSoloOpEspecificas;

    @FindBy(xpath = "//*[@id='opt-8']")
    private WebElement tipoSolicitudSoloOpEspecificasRenovacion;

    // Se localizan los elementos de la opcion "Tipo de solicitud"

    @FindBy(xpath = "//*[@id='combo-53a239f1-d490-4c39-9ca4-c688fc61046f']")
    private WebElement desplegarDetalleSolicitud;

    @FindBy(xpath = "//*[@id='opt-1']")
    private WebElement detalleSolicitudCupos;

    // Se localizan los elementos de la opcion "Es sucursal"

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-app-render-form-content ']/div/div/div/div[1]/div/div/div[1]/div/div[3]/div/div/div[1]/div[3]/div[1]/label")
    private WebElement sucursalSi;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-app-render-form-content ']/div/div/div/div[1]/div/div/div[1]/div/div[3]/div/div/div[1]/div[3]/div[2]/label")
    private WebElement sucursalNo;

    // Se localizan los elementos de la opcion "Tipo de identificacion" 19

    @FindBy(xpath = "//*[@id='combo-c239a0e2-d632-4694-9307-c3252b7ba74d']")
    private WebElement desplegarTipoId;

    @FindBy(xpath = "//*[@id='opt-1']")
    private WebElement idCedula;

    @FindBy(xpath = "//*[@id='opt-2']")
    private WebElement idCarneDiplomatico;

    @FindBy(xpath = "//*[@id='opt-3']")
    private WebElement idCedulaExtranjeria;

    @FindBy(xpath = "//*[@id='opt-4']")
    private WebElement idSociedadExtranjeraSinNit;

    @FindBy(xpath = "//*[@id='opt-5']")
    private WebElement idFiducia;

    @FindBy(xpath = "//*[@id='opt-6']")
    private WebElement idNitExtranjeria;

    @FindBy(xpath = "//*[@id='opt-7']")
    private WebElement idNit;

    @FindBy(xpath = "//*[@id='opt-8']")
    private WebElement idSinValidar;

    @FindBy(xpath = "//*[@id='opt-9']")
    private WebElement idPatrimonioAutonomo;

    @FindBy(xpath = "//*[@id='opt-10']")
    private WebElement idPermisoEspecialPermanencia;

    @FindBy(xpath = "//*[@id='opt-11']")
    private WebElement idPermisoProteccionTemporal;

    @FindBy(xpath = "//*[@id='opt-12']")
    private WebElement idPasaporte;

    @FindBy(xpath = "//*[@id='opt-13']")
    private WebElement idRegistroCivil;

    @FindBy(xpath = "//*[@id='opt-14']")
    private WebElement idRut;

    @FindBy(xpath = "//*[@id='opt-15']")
    private WebElement idTarjetaIdentidad;

    @FindBy(xpath = "//*[@id='opt-16']")
    private WebElement idTaxIdentificacion;

    @FindBy(xpath = "//*[@id='opt-17']")
    private WebElement idTaxIdentificacion2;

    @FindBy(xpath = "//*[@id='opt-18']")
    private WebElement idTaxIdentificacion3;

    @FindBy(xpath = "//*[@id='opt-19']")
    private WebElement idTaxIdentificacion4;

    // Se localizan los elementos de la opcion "Numero identificacion"

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-app-render-form-content ']/div/div/div/div[1]/div/div/div[1]/div/div[6]/div/div/div[2]/div/div[1]/div/div/div/div[1]/input")
    private WebElement numeroId;

    // Se localiza el boton crear

    @FindBy(xpath = "//*[@id='formButton0']")
    private WebElement botonCrear;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-project-plan-content-dashboard']/div/div/div/div[1]/p")
    private WebElement creacionOk;

    @FindBy(xpath = "//*[@id='ui-bizagi-tab-13f42586-4d68-4a83-95e3-bb0336fa0067']/div[2]/div/div/div[3]/div[2]/div[4]/div/div/div[1]/label")
    private WebElement indicadorCliente;

    @FindBy(xpath = "//*[@id='ui-bizagi-wp-app-render-form-content ']/div/div/div/div[1]/div/div/div[1]/div/div[6]/div/div/div[2]/div/div[2]/div/div/div/div[1]/label")
    private WebElement digVerif;

    @FindBy(xpath = "//*[@id='M_Solicitud_kmDetalleSolicitud_xModificaciones']/div/div[1]/span[2]")
    private WebElement opcionesModif;



    @FindBy(xpath = "//*[@id='M_Solicitud_kmDetalleSolicitud_xModificaciones']/div/div[1]/span[2]")
    private WebElement modifCreada;



    @FindBy(xpath = "//*[@id='M_Solicitud_kmDetalleSolicitud_xModificaciones']/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/div/span/div/label")
    private WebElement modifUno;

    @FindBy(xpath = "//*[@id='M_Solicitud_kmDetalleSolicitud_xModificaciones']/div/div[2]/div[1]/table/tbody/tr[2]/td[4]/div/div/span/div/label")
    private WebElement modifDos;



    @FindBy(xpath = "//*[@id='M_Solicitud_kmDetalleSolicitud_xModificaciones']/div/div[2]/div[1]/table/tbody/tr[1]/td[3]/div/div/div")
    private WebElement modifUnoCreada;


    @FindBy(xpath = "//*[@id='M_Solicitud_kmDetalleSolicitud_xModificaciones']/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/div/div/div")
    private WebElement modifDosCreada;



    private final Map<String, WebElement> tipoIdElementMap = new HashMap<>();


    public void seleccionarTipoId(String tipoId) {
        wait.until(ExpectedConditions.elementToBeClickable(desplegarTipoId)).click();

        if (tipoIdElementMap.containsKey(tipoId)) {
            WebElement tipoIdElemento = wait.until(ExpectedConditions.elementToBeClickable((tipoIdElementMap.get(tipoId))));
            tipoIdElemento.click();
        } else {
            throw new IllegalArgumentException("❌ Tipo de ID no soportado: " + tipoId);
        }
    }

    public void crearSolicitudConId(String tipoId, String numeroIdentificacion) {

        BaseTest.scrollAndClick(driver, wait, desplegarTipoSolicitud);
        BaseTest.scrollAndClick(driver, wait, tipoSolicitudNueva);
        BaseTest.scrollAndClick(driver, wait, desplegarDetalleSolicitud);
        BaseTest.scrollAndClick(driver, wait, detalleSolicitudCupos);
        BaseTest.scrollAndClick(driver, wait, sucursalNo);
        seleccionarTipoId(tipoId);
        BaseTest.scrollAndType(driver, wait, numeroId, numeroIdentificacion);
        numeroId.sendKeys(Keys.TAB);
        BaseTest.scrollAndClick(driver, wait, botonCrear);

        try {
            WebElement mensaje = wait.until(ExpectedConditions.visibilityOf(creacionOk));
            String textoActual = mensaje.getText().trim();
            String textoEsperado = "Radicación Proyecto Crediticio BdB › Complementar Solicitud Proyecto";

            Assert.assertTrue(textoActual.contains("Radicación Proyecto Crediticio"),
                    "❌ No se encontró el mensaje esperado. Actual: " + textoActual);
        } catch (TimeoutException e) {
            Assert.fail("❌ No se encontró el mensaje de éxito a tiempo.");
        }

    }

    public void crearSolicitudProsConId(String tipoId, String numeroIdentificacion) {

        BaseTest.scrollAndClick(driver, wait, desplegarTipoSolicitud);
        BaseTest.scrollAndClick(driver, wait, tipoSolicitudNueva);
        BaseTest.scrollAndClick(driver, wait, desplegarDetalleSolicitud);
        BaseTest.scrollAndClick(driver, wait, detalleSolicitudCupos);
        BaseTest.scrollAndClick(driver, wait, sucursalNo);
        seleccionarTipoId(tipoId);
        BaseTest.scrollAndType(driver, wait, numeroId, numeroIdentificacion);
        numeroId.sendKeys(Keys.TAB);
        BaseTest.scrollAndClick(driver, wait, botonCrear);


        if (BaseTest.isElementPresent(indicadorCliente)) {
            String textoActual = indicadorCliente.getText();
            String textoEsperado = "Existe como prospecto";
            Assert.assertEquals(textoActual, textoEsperado, "⚠️ El mensaje de éxito no es el esperado");
        } else {
            Assert.fail("❌ No se encontró el mensaje de éxito.");
        }

    }

    public void validarDetSoli(String tipoId, String numeroIdentificacion) {

        BaseTest.scrollAndClick(driver, wait, desplegarTipoSolicitud);
        BaseTest.scrollAndClick(driver, wait, tipoSolicitudNueva);

        if (BaseTest.isElementPresent(desplegarDetalleSolicitud)) {
            Assert.assertTrue(desplegarDetalleSolicitud.isDisplayed());
        } else {
            Assert.fail("❌ No se encontró el mensaje de éxito.");
        }
    }

    public void validarDigVerif(String tipoId, String numeroIdentificacion) {

        BaseTest.scrollAndClick(driver, wait, desplegarTipoSolicitud);
        BaseTest.scrollAndClick(driver, wait, tipoSolicitudNueva);
        BaseTest.scrollAndClick(driver, wait, desplegarDetalleSolicitud);
        BaseTest.scrollAndClick(driver, wait, detalleSolicitudCupos);
        BaseTest.scrollAndClick(driver, wait, sucursalNo);
        seleccionarTipoId(tipoId);
        BaseTest.scrollAndType(driver, wait, numeroId, numeroIdentificacion);
        numeroId.sendKeys(Keys.TAB);

        for (int i = 0; i < 3; i++) { // 🔄 Reintentar hasta 3 veces
            try {
                if (BaseTest.isElementPresent(digVerif)) {
                    Assert.assertTrue(digVerif.isDisplayed());
                    return;
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("🔄 Reintentando validación de digito verificador...");
            }
        }
        Assert.fail("❌ No se encontró el mensaje de éxito.");
    }

    public void validarTipoModif(String tipoId, String numeroIdentificacion) throws InterruptedException {

        BaseTest.scrollAndClick(driver, wait, desplegarTipoSolicitud);
        BaseTest.scrollAndClick(driver, wait, tipoSolicitudModificacion);
        BaseTest.scrollAndClick(driver, wait, desplegarDetalleSolicitud);
        BaseTest.scrollAndClick(driver, wait, detalleSolicitudCupos);
        BaseTest.scrollAndClick(driver, wait, sucursalNo);

        if (BaseTest.isElementPresent(opcionesModif)) {
            Assert.assertTrue(opcionesModif.isDisplayed());
        } else {
            Assert.fail("❌ No se encontraron las opciones de modificacion.");
        }

        BaseTest.scrollAndClick(driver, wait, modifUno);
        BaseTest.scrollAndClick(driver, wait, modifDos);

        seleccionarTipoId(tipoId);
        BaseTest.scrollAndType(driver, wait, numeroId, numeroIdentificacion);
        numeroId.sendKeys(Keys.TAB);
        BaseTest.scrollAndClick(driver, wait, botonCrear);

        Thread.sleep(10000);

        if (BaseTest.isElementPresent(modifCreada)) {
            Assert.assertTrue(modifCreada.isDisplayed());
        } else {
            Assert.fail("❌ No se encontró la seccion de modificaciones en la solicitud creada.");
        }
        if (BaseTest.isElementPresent(modifUnoCreada)) {
            Assert.assertTrue(modifCreada.isDisplayed());
        } else {
            Assert.fail("❌ No se encontró la modificacion uno seleccionada.");
        }
        if (BaseTest.isElementPresent(modifDosCreada)) {
            Assert.assertTrue(modifCreada.isDisplayed());
        } else {
            Assert.fail("❌ No se encontró la modificacion dos seleccionada");
        }
        BaseTest.scrollAndClick(driver, wait, modifDosCreada);
    }
}





package tests;

import app.getxray.xray.testng.annotations.XrayTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Home;
import pages.LoginBizagi;
import utils.BaseTest;

@Listeners({ app.getxray.xray.testng.listeners.XrayListener.class })
public class HU01 extends BaseTest {

    //URL de acceso al aplicativo
    String urlacceso = "https://test-bpmccial-bancodebogota.bizagi.com";
    String mail = "yvill13@bancodebogota.com.co";
    String password = "Yv404040*";
    String passwordErrado ="afdadasfdsf";


    @Test
    @XrayTest(key = "CRED-6579")
    public void TC_01() {
        getDriver().get(urlacceso);
        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Assert.assertTrue(loginBizagi.isLoginSuccessful(), "Error: Login fallido.");
    }

    @Test
    @XrayTest(key = "CRED-6580")
    public void TC_02() {
        getDriver().get(urlacceso);
        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, passwordErrado);
        Assert.assertTrue(loginBizagi.isLoginErrorDisplayed(), "Error: No se mostró el mensaje de error al fallar el login.");
    }

    @Test
    @XrayTest(key = "CRED-6581")
    public void TC_03() throws InterruptedException {
        getDriver().get(urlacceso);
        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Thread.sleep(180000);
        Assert.assertTrue(loginBizagi.pagueTimeOut(), "Error: No se genera cierre por inactividad en la WEB");
    }

    @Test
    @XrayTest(key = "CRED-6582")
    public void TC_04() {
        getDriver().get(urlacceso);
        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Home home = new Home();
        home.cerrarSesion();
        Assert.assertTrue(home.closesesion(), "Error: No se genero correctamente el cierre de sesion.");
    }
}

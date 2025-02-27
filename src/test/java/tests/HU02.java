package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.*;

public class HU02 extends BaseTest {

    String urlacceso = "https://test-bpmccial-bancodebogota.bizagi.com";
    String mail = "yvill13@bancodebogota.com.co";
    String password = "Yv404040*";

    @DataProvider(name = "DatosIdentificacionPN", parallel = true)
    public Object[][] getDatosIdentificacionPN() {
        return new Object[][]{
                {"CC", "7166146"},
                {"CE", "508729"},
                {"TI", "9905011151"},
                {"RC", "35755564"},
                {"PS", "51874123"},
                {"RUT", "625478199"},
        };
    }

    @DataProvider(name = "DatosIdentificacionPJ", parallel = true)
    public Object[][] getDatosIdentificacionPJ() {
        return new Object[][]{
                {"NIT", "800123001"},
                {"PA", "400005121"},
                {"NEX", "7586521038"},
                {"ESN", "329700"},
        };
    }

    @DataProvider(name = "DatosIdentificacionProsPJPN", parallel = true)
    public Object[][] getDatosIdentificacionProsPJPN() {
        return new Object[][]{
                {"CC", "7167176"},
                {"CE", "558779"},
                {"TI", "9965071151"},
                {"RC", "35785764"},
                {"PS", "51834173"},
                {"RUT", "626478799"},
                {"NIT", "800723001"},
                {"PA", "400075121"},
                {"NEX", "7586721038"},
                {"ESN", "329770"},
        };
    }


    @Test(dataProvider = "DatosIdentificacionPN")
    public void TC_01(String tipoId, String numeroIdentificacion) {
        getDriver().get(urlacceso);

        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Home home = new Home();
        home.abrirNuevoCaso();
        NuevoCaso nuevoCaso = new NuevoCaso();
        nuevoCaso.crearSolicitudConId(tipoId, numeroIdentificacion);
    }

    @Test(dataProvider = "DatosIdentificacionPJ")
    public void TC_02(String tipoId, String numeroIdentificacion) {
        getDriver().get(urlacceso);

        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Home home = new Home();
        home.abrirNuevoCaso();
        NuevoCaso nuevoCaso = new NuevoCaso();
        nuevoCaso.crearSolicitudConId(tipoId, numeroIdentificacion);
    }

    @Test
    public void TC_03() {
        getDriver().get(urlacceso);

        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Home home = new Home();
        home.abrirNuevoCaso();
        NuevoCaso nuevoCaso = new NuevoCaso();
        nuevoCaso.validarDetSoli("CC", "800800800");
    }

    @Test(dataProvider = "DatosIdentificacionProsPJPN")
    public void TC_05(String tipoId, String numeroIdentificacion) {
        getDriver().get(urlacceso);

        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Home home = new Home();
        home.abrirNuevoCaso();
        NuevoCaso nuevoCaso = new NuevoCaso();
        nuevoCaso.crearSolicitudProsConId(tipoId, numeroIdentificacion);
    }

    @Test
    public void TC_06() {
        getDriver().get(urlacceso);

        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Home home = new Home();
        home.abrirNuevoCaso();
        NuevoCaso nuevoCaso = new NuevoCaso();
        nuevoCaso.validarDigVerif("NIT", "800800800");
    }

    @Test
    public void TC_07() throws InterruptedException {
        getDriver().get(urlacceso);

        LoginBizagi loginBizagi = new LoginBizagi();
        loginBizagi.login(mail, password);
        Home home = new Home();
        home.abrirNuevoCaso();
        NuevoCaso nuevoCaso = new NuevoCaso();
        nuevoCaso.validarTipoModif("NIT", "800800800");
    }


}

package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static WebDriver getDriver() {

        return driver.get();
    }


    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    public static void waitForPageToLoad(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Espera a que el DOM esté listo
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));

            // Espera a que no haya llamadas AJAX pendientes
            wait.until(webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
                    .executeScript("return jQuery.active == 0"));

            System.out.println("✅ Página y AJAX completamente cargados.");
        } catch (Exception e) {
            System.out.println("⚠️ Timeout esperando la carga completa.");
        }
    }


    // 🔥 Método mejorado para hacer scroll y click con validación previa
    public static void scrollAndClick(WebDriver driver, WebDriverWait wait, WebElement element) {
        waitForPageToLoad(driver);

        if (!isElementPresent(element)) {
            System.out.println("❌ Elemento no presente, cancelando acción.");
            return;
        }

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        for (int i = 0; i < 3; i++) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                fluentWait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("✅ Click exitoso en intento " + (i + 1));
                return;
            } catch (Exception e) {
                System.out.println("🔄 Intento " + (i + 1) + " fallido, reintentando...");
            }
        }
        System.out.println("❌ No se pudo hacer click después de 3 intentos.");
    }

    // 🔥 Método mejorado para hacer scroll y escribir texto con validación previa
    public static void scrollAndType(WebDriver driver, WebDriverWait wait, WebElement element, String text) {
        waitForPageToLoad(driver);

        if (!isElementPresent(element)) {
            System.out.println("❌ Elemento no presente, cancelando acción.");
            return;
        }

        for (int i = 0; i < 3; i++) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                wait.until(ExpectedConditions.visibilityOf(element));
                element.clear();  // Borra el texto antes de escribir
                element.sendKeys(text);
                System.out.println("✅ Texto ingresado con éxito en intento " + (i + 1));
                return;
            } catch (Exception e) {
                System.out.println("🔄 Intento " + (i + 1) + " fallido, reintentando...");
            }
        }
        System.out.println("❌ No se pudo escribir después de 3 intentos.");
    }

    // Metodo para saber si un elemento esta presente en la pantalla
    public static boolean isElementPresent(WebElement element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("✅ Elemento encontrado.");
            return true;
        } catch (TimeoutException e) {
            System.out.println("❌ Elemento no encontrado en 10s.");
            return false;
        }
    }

}
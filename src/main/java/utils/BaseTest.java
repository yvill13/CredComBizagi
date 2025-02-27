package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Espera hasta 30s
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
            System.out.println("✅ La pantalla ha cargado completamente.");
        } catch (Exception e) {
            System.out.println("⚠️ La pantalla tardó demasiado en cargar.");
        }
    }


    // 🔥 Método mejorado para hacer scroll y click con validación previa
    public static void scrollAndClick(WebDriver driver, WebDriverWait wait, WebElement element) {

        waitForPageToLoad(driver);


        // ✅ Verificar si el elemento está presente antes de interactuar
        if (!isElementPresent(element)) {
            System.out.println("❌ El elemento no está presente en la pantalla, cancelando la acción.");
            return;
        }
        int intentos = 3; // 🔄 Número máximo de intentos
        for (int i = 0; i < intentos; i++) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element); // 📜 Hace scroll hasta el elemento
                wait.until(ExpectedConditions.elementToBeClickable(element)).click(); // ✅ Intenta hacer click
                System.out.println("✅ Click exitoso en el intento " + (i + 1));
                return; // 🏆 Salimos del método si tuvo éxito
            } catch (StaleElementReferenceException e) {
                System.out.println("🔄 Intento " + (i + 1) + " - Elemento Stale, reintentando...");
            } catch (NullPointerException e) {
                System.out.println("⚠️ Intento " + (i + 1) + " - Timeout esperando el elemento, reintentando...");
            } catch (NoSuchElementException e) {
                System.out.println("❌ Intento " + (i + 1) + " - Elemento no encontrado, reintentando...");
            } catch (JavascriptException e) {
                System.out.println("🚨 Intento " + (i + 1) + " - Error de JavaScript en scroll, reintentando...");
            } catch (Exception e) {
                System.out.println("⚡ Intento " + (i + 1) + " - Error inesperado: " + e.getMessage());
            }

            // ⏳ Espera antes de volver a intentar
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaurar la interrupción del hilo
            }
        }
        System.out.println("❌ No se pudo hacer clic en el elemento después de " + intentos + " intentos.");
    }

    // 🔥 Método mejorado para hacer scroll y escribir texto con validación previa
    public static void scrollAndType(WebDriver driver, WebDriverWait wait, WebElement element, String text) {

        waitForPageToLoad(driver);


        // ✅ Verificar si el elemento está presente antes de interactuar
        if (!isElementPresent(element)) {
            System.out.println("❌ El elemento no está presente en la pantalla, cancelando la acción.");
            return;
        }
        int intentos = 3; // 🔄 Número máximo de intentos
        for (int i = 0; i < intentos; i++) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element); // 📜 Hace scroll hasta el elemento
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
                System.out.println("✅ Texto ingresado con éxito en el intento " + (i + 1));
                return; // 🏆 Salimos del método si tuvo éxito
            } catch (StaleElementReferenceException e) {
                System.out.println("🔄 Intento " + (i + 1) + " - Elemento Stale, reintentando...");
            } catch (NullPointerException e) {
                System.out.println("⚠️ Intento " + (i + 1) + " - Timeout esperando el elemento, reintentando...");
            } catch (NoSuchElementException e) {
                System.out.println("❌ Intento " + (i + 1) + " - Elemento no encontrado, reintentando...");
            } catch (JavascriptException e) {
                System.out.println("🚨 Intento " + (i + 1) + " - Error de JavaScript en scroll, reintentando...");
            } catch (Exception e) {
                System.out.println("⚡ Intento " + (i + 1) + " - Error inesperado: " + e.getMessage());
            }

            // ⏳ Espera antes de volver a intentar
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaurar la interrupción del hilo
            }
        }
        System.out.println("❌ No se pudo escribir en el elemento después de " + intentos + " intentos.");
    }

    // Metodo para saber si un elemento esta presente en la pantalla
    public static boolean isElementPresent(WebElement element) {
        int intentos = 3; // 🔄 Número máximo de intentos
        for (int i = 0; i < intentos; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Espera máxima de 10s
                wait.until(ExpectedConditions.visibilityOf(element)); // Esperamos que el elemento esté visible
                System.out.println("✅ Elemento encontrado en el intento " + (i + 1));
                return true; // ✅ El elemento está en pantalla
            } catch (NullPointerException e) {
                System.out.println("⚠️ Intento " + (i + 1) + " - Timeout esperando el elemento, reintentando...");
            } catch (NoSuchElementException e) {
                System.out.println("❌ Intento " + (i + 1) + " - Elemento no encontrado, reintentando...");
            } catch (StaleElementReferenceException e) {
                System.out.println("🔄 Intento " + (i + 1) + " - Elemento Stale, reintentando...");
            } catch (Exception e) {
                System.out.println("⚡ Intento " + (i + 1) + " - Error inesperado: " + e.getMessage());
            }

            // ⏳ Espera antes de volver a intentar
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaurar la interrupción del hilo
            }
        }
        System.out.println("❌ No se encontró el elemento después de " + intentos + " intentos.");
        return false;
    }

}
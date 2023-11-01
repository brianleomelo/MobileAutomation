import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.remote.http.HttpClient;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {


    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void newDriver() throws MalformedURLException {

        //Iniciar Appuim Server automáticamente
        service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\brian\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1")
                .usingPort(4724)
                .withTimeout(Duration.ofSeconds(300))
                .build();
        //service.start();

        //Crear capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setApp("D:\\brian\\Estudio\\Test Automation\\MobileAuomation\\src\\test\\resources\\Android-NativeDemoApp-0.4.0.apk")
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity(".SplashActivity")
                .setPlatformName("Android")
                .setPlatformVersion("11.0")
                .setAutomationName("UIautomator2");


        //Crear un nuevo objeto para el Driver AndroidDriver/IOSDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4724"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void after() {
        driver.quit(); //Finaliza el driver
        //service.stop(); //Finaliza la conexión con Appium Server
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}

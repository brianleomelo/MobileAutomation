import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.http.HttpClient;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @Test
    public void newDriver() throws MalformedURLException {
        //Crear capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Nexus5");
        //options.setApp("D:\\brian\\Estudio\\Test Automation\\MobileAuomation\\src\\test\\resources\\Android-NativeDemoApp-0.4.0.apk");



        //Crear un nuevo objeto para el Driver AndroidDriver/IOSDriver

        driver = new AndroidDriver(new URL("http://127.0.0.1:4724"),options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.quit();
        //service.stop();



    }


}

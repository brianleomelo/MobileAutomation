import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class FirstMobileTest extends BaseTest {

    @Test
    public void loadLoginPageTest(){
        //Object Locators: xpath(By {Selenium}), id(By {Selenium}), classname(By {Selenium}), accesibilityId(AppiumBy), androidUIautomator(AppiumBy)
        driver.findElement(AppiumBy.accessibilityId("Login")).click();
    }
}

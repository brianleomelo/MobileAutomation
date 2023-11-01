import com.globant.App;
import com.google.common.collect.ImmutableList;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstMobileTest extends BaseTest {

    @Test
    public void loadWebViewPageTest() {

        driver.findElement(AppiumBy.accessibilityId("Webview")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement element = driver.findElement(By.xpath("//android.view.View[@text=\"WebdriverIO\"]"));
        Assert.isTrue(element.isDisplayed(),"No existe");

    }

    @Test
    public void loadLoginPageTest(){
        //Object Locators: xpath(By {Selenium}), id(By {Selenium}), classname(By {Selenium}), accesibilityId(AppiumBy), androidUIautomator(AppiumBy)
        driver.findElement(AppiumBy.accessibilityId("Login")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.isTrue(driver.findElement(AppiumBy.accessibilityId("button-login-container")).isDisplayed(),"No existe");

    }

    @Test
    public void loadFormPageTest(){
        //Object Locators: xpath(By {Selenium}), id(By {Selenium}), classname(By {Selenium}), accesibilityId(AppiumBy), androidUIautomator(AppiumBy)
        driver.findElement(AppiumBy.accessibilityId("Forms")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.isTrue(driver.findElement(AppiumBy.accessibilityId("Forms-screen")).isDisplayed(),"No existe");

    }

    @Test
    public void loadSwipePageTest(){
        //Object Locators: xpath(By {Selenium}), id(By {Selenium}), classname(By {Selenium}), accesibilityId(AppiumBy), androidUIautomator(AppiumBy)
        driver.findElement(AppiumBy.accessibilityId("Swipe")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.isTrue(driver.findElement(AppiumBy.accessibilityId("Swipe-screen")).isDisplayed(),"No existe");

        WebElement element = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"card\"])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,-200,0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void loadDragPageTest(){
        //Object Locators: xpath(By {Selenium}), id(By {Selenium}), classname(By {Selenium}), accesibilityId(AppiumBy), androidUIautomator(AppiumBy)
        driver.findElement(AppiumBy.accessibilityId("Drag")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.isTrue(driver.findElement(AppiumBy.accessibilityId("Drag-drop-screen")).isDisplayed(),"No existe");

    }

    protected void swipe(Point start, Point end, Duration duration) {

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        /*if (isAndroid) {
            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
        }*/
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(ImmutableList.of(swipe));


    }

}

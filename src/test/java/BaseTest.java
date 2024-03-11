import helper.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    protected WebDriver getDriver() { return driver; };

    protected void navigateWeb(String link) {
        driver.get(link);
    };

    @BeforeMethod
    protected void beforeTest(Method method) {
        System.out.println("Run: " + method.getDeclaringClass().getName() + " -> " + method.getName());

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        if (method.getName().contains("google")) {
            navigateWeb(TestData.GOOGLE);
        } else if (method.getName().contains("demo")) {
            navigateWeb(TestData.DEMO_QA);
        }

        getDriver().manage().window().maximize();
    }

    @AfterMethod
    protected void afterTest() {
        getDriver().quit();
    }
}

package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import selenium.page.CalcPage;

public class BaseTests extends Base {

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            driver = new ChromeDriver();
            calcPage = new CalcPage();
            util = new Util(driver);
            driver.get(URL);
            driver.manage().window().maximize();
        }
    }

    @Test
    @Parameters({"keyNum", "expectedResult"})
    public void test_2power(String keyNum, String expectedResult) throws InterruptedException {
        driver.findElement(CalcPage.button_clear_locator).click();
        driver.findElement(CalcPage.button_op2_locator).click();
        driver.findElement(CalcPage.button_pow2_locator).click();
        driver.findElement(calcPage.button_num_element(keyNum)).click();
        driver.findElement(CalcPage.button_closeParenthesis_locator).click();
        driver.findElement(CalcPage.button_calculate_locator).click();
        Thread.sleep(300);
        Assert.assertEquals(driver.findElement(CalcPage.textBox_input_locator).getAttribute("value"), expectedResult);

    }

    @AfterSuite
    public void teardown() {
        util.printHistory();
        if (driver != null) {
            driver.close();
            driver.quit();
        }

    }


}

package selenium;

import org.openqa.selenium.WebDriver;
import selenium.page.CalcPage;

public class Base {
    protected static WebDriver driver;
    protected static String URL = "https://web2.0calc.com/";

    protected static CalcPage calcPage;
    protected static Util util;


}

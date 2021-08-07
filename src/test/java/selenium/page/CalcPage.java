package selenium.page;

import org.openqa.selenium.By;

public class CalcPage {
    public static By button_op2_locator = By.id("BtnOpD2");
    public static By button_pow2_locator = By.id("Button2X");
    public static By button_calculate_locator = By.id("BtnCalc");
    public static By button_closeParenthesis_locator = By.id("BtnParanR");
    public static By frame_historyFrame_locator = By.id("histframe");
    public static By textBox_input_locator = By.id("input");
    public static By button_openHistory_locator = By.cssSelector("#hist > button.btn.dropdown-toggle.pull-right");
    public static By button_clear_locator = By.id("BtnClear");

    public By button_num_element(String num) {
        return By.id("Btn" + num);
    }

}

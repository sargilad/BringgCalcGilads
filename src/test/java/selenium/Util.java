package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.page.CalcPage;

import java.util.List;

public class Util {
    WebDriver driver;

    public Util(WebDriver driver) {
        this.driver = driver;
    }

    public void printHistory() {
        WebElement historyFrameElement = driver.findElement(CalcPage.frame_historyFrame_locator);
        if (!historyFrameElement.isDisplayed()) {
            driver.findElement(CalcPage.button_openHistory_locator).click();
        }
        List<WebElement> lineElements = historyFrameElement.findElements(By.tagName("li"));
        System.out.println("History:");
        for (WebElement webElement : lineElements) {
            System.out.println(webElement.findElement(By.className("l")).getText() + webElement.findElement(By.className("r")).getText());
        }


    }
}

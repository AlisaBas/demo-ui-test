import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriver {

    @Test
    public void testOnlinerOpen(){
        org.openqa.selenium.WebDriver driver=new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        driver.get(OnlinerPage.BASE_URL);

        String actualFooterCoopyright = driver.findElement(By.xpath(OnlinerPage.FOOTER_COPYRIGHT)).getText();
        Assert.assertEquals("\n" +
                "                © 2001—2023 Onlíner            ",actualFooterCoopyright);

        driver.quit();
    }





       @Test
       public void testOpenOnlinerLoginForm() {
           org.openqa.selenium.WebDriver driver = new SafariDriver();
           driver.get(OnlinerPage.BASE_URL);
           driver.manage().window().maximize();
           WebElement enterElement = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
           enterElement.click();
           WebElement textButtonEnter=driver.findElement(By.xpath(OnlinerPage.BTN_ENTER_TEXT));
           Assert.assertEquals("\n" +
                   "        Вход\n" +
                   "    ",textButtonEnter.getText());

       }}








import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class WebDriver {

    @Test
    public void testOnlinerOpen(){
        org.openqa.selenium.WebDriver driver=new SafariDriver();
        driver.get(OnlinerPage.BASE_URL);
        driver.manage().window().maximize();

        WebElement FOOTER_COPYRIGHTElement= driver.findElement(By.xpath(OnlinerPage.FOOTER_COPYRIGHT));
        Assert.assertEquals(FOOTER_COPYRIGHTElement.getText())

        driver.quit();




        @Test
       public void testOpenOnlinerLoginForm(){
            org.openqa.selenium.WebDriver driver=new SafariDriver();
        driver.get(OnlinerPage.BASE_URL);
        driver.manage().window().maximize();

        WebElement enterElement=driver.findElement(By.xpath(OnlinerPage.BTN_ENT));
        enterElement.click();




    }}



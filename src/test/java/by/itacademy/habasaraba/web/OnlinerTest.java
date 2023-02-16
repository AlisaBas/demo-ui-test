package by.itacademy.habasaraba.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class OnlinerTest {

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

       }

       @Test
    public void testOnlinerLoginFormWithEmptyCredentials(){
           org.openqa.selenium.WebDriver driver = new SafariDriver();
           driver.get(OnlinerPage.BASE_URL);
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
           WebElement enterElement = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
           enterElement.click();
           Util.waitThreadFor(1);
           /* try{
               Thread.sleep(1000);
           }catch (InterruptedException e) {
               throw new RuntimeException(e);
           }*/
           WebElement buttonLogin=driver.findElement(By.xpath(OnlinerPage.BTN_LOGIN));
           buttonLogin.click();
          Util.waitThreadFor(1);
           WebElement errorNick= driver.findElement(By.xpath(OnlinerPage.ERROR_NICK));
           Assert.assertEquals("\n" +
                   "                    Укажите ник или e-mail\n" +
                   "                ",errorNick.getText());
           WebElement errorPassword=driver.findElement((By.xpath(OnlinerPage.ERROR_PASSWORD)));
           Assert.assertEquals("\n" +
                   "                    Укажите пароль\n" +
                   "                ", errorPassword.getText());
           driver.quit();

       }

       @Test
    public void testOnlinerLoginFormWithEmptyPassword(){
           org.openqa.selenium.WebDriver driver = new SafariDriver();
           driver.get(OnlinerPage.BASE_URL);
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
           WebElement enterElement = driver.findElement(By.xpath(OnlinerPage.BTN_ENTER));
           enterElement.click();
           Util.waitThreadFor(1);
           WebElement emailField=driver.findElement(By.xpath(OnlinerPage.EMAIL_FIELD));
           emailField.sendKeys(OnlinerPage.ONLINER_LOGIN);
           WebElement buttonLogin=driver.findElement(By.xpath(OnlinerPage.BTN_LOGIN));
           buttonLogin.click();
           Util.waitThreadFor(1);
           WebElement errorPassword=driver.findElement((By.xpath(OnlinerPage.ERROR_PASSWORD)));
           Assert.assertEquals("\n" +
                   "                    Укажите пароль\n" +
                   "                ", errorPassword.getText());
           driver.quit();



       }





}







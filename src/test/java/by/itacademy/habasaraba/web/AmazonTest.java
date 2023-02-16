package by.itacademy.habasaraba.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class AmazonTest {
    @Test
    public void testOpenAmazon(){
        org.openqa.selenium.WebDriver driver=new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        driver.get(AmazonPage.AMAZON_URL);
        String actualCopyright=driver.findElement(By.xpath(AmazonPage.AMAZON_COPYRIGHT)).getText();
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates",actualCopyright);
        driver.quit();
    }

    @Test
    public void testOpenAmazonCart(){
        org.openqa.selenium.WebDriver driver=new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        driver.get(AmazonPage.AMAZON_URL);
        WebElement cartButtonElement=driver.findElement(By.xpath(AmazonPage.AMAZON_CART_BTN));
        cartButtonElement.click();
        Util.waitThreadFor(1);
        String emptyButtonText=driver.findElement(By.xpath(AmazonPage.EMPTY_CART_TEXT)).getText();
        Assert.assertEquals("\n" +
                "Your Amazon Cart is empty\n",emptyButtonText);
        driver.quit();
    }

    @Test
    public void testOpenAmazonLoginForm(){
        org.openqa.selenium.WebDriver driver=new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        driver.get(AmazonPage.AMAZON_URL);
        Util.waitThreadFor(1);
        WebElement cartButtonElement=driver.findElement(By.xpath(AmazonPage.AMAZON_CART_BTN));
        cartButtonElement.click();
        Util.waitThreadFor(1);
        WebElement signInButtonElement=driver.findElement(By.xpath(AmazonPage.SIGN_IN_BTN));
        signInButtonElement.click();
        Util.waitThreadFor(1);
        String signInText=driver.findElement(By.xpath(AmazonPage.SIGN_IN_TEXT)).getText();
        Assert.assertEquals("\n" +
                "            Sign in\n" +
                "          ",signInText);
        driver.quit();
    }



}

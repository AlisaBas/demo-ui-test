package by.itacademy.habasaraba.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class AmazonTest {
    WebDriver driver;

    @Before
    public void warmUp(){
        driver=new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        driver.get(AmazonPage.AMAZON_URL);
    }
    @Test
    public void testOpenAmazon(){
        String actualCopyright=driver.findElement(By.xpath(AmazonPage.AMAZON_COPYRIGHT)).getText();
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates",actualCopyright);

    }

    @Test
    public void testOpenAmazonCart(){
        WebElement cartButtonElement=driver.findElement(By.xpath(AmazonPage.AMAZON_CART_BTN));
        cartButtonElement.click();
        Util.waitThreadFor(1);
        String emptyButtonText=driver.findElement(By.xpath(AmazonPage.EMPTY_CART_TEXT)).getText();
        Assert.assertEquals("\n" +
                "Your Amazon Cart is empty\n",emptyButtonText);

    }

    @Test
    public void testOpenAmazonLoginForm(){
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

    }

    @Test
    public void testAmazonLoginFormWithEmptyCredentials(){
        Util.waitThreadFor(1);
        WebElement cartButtonElement=driver.findElement(By.xpath(AmazonPage.AMAZON_CART_BTN));
        cartButtonElement.click();
        Util.waitThreadFor(1);
        WebElement signInButtonElement=driver.findElement(By.xpath(AmazonPage.SIGN_IN_BTN));
        signInButtonElement.click();
        Util.waitThreadFor(1);
        WebElement continueButtonElement=driver.findElement(By.xpath(AmazonPage.CONTINUE_BTN));
        Util.waitThreadFor(1);
        continueButtonElement.click();
        String enterYourEmail=driver.findElement(By.xpath(AmazonPage.ENTER_YOUR_EMAIL_TEXT)).getText();
        Util.waitThreadFor(1);
        Assert.assertEquals("\n" +
                "  Enter your email or mobile phone number\n",enterYourEmail );


    }

    @Test
    public void testAmazonLoginFormWithCredentials(){
        Util.waitThreadFor(1);
        WebElement cartButtonElement=driver.findElement(By.xpath(AmazonPage.AMAZON_CART_BTN));
        cartButtonElement.click();
        Util.waitThreadFor(1);
        WebElement signInButtonElement=driver.findElement(By.xpath(AmazonPage.SIGN_IN_BTN));
        signInButtonElement.click();
        Util.waitThreadFor(1);
        WebElement emailOrMobileField= driver.findElement(By.xpath(AmazonPage.EMAIL_OR_MOBILE_FIELD));
        emailOrMobileField.sendKeys("2018999302");
        Util.waitThreadFor(1);
        WebElement continueButtonElement=driver.findElement(By.xpath(AmazonPage.CONTINUE_BTN));
        Util.waitThreadFor(1);
        continueButtonElement.click();
        Util.waitThreadFor(1);
        WebElement passwordField= driver.findElement(By.xpath(AmazonPage.PASSWORD_FIELD));
        passwordField.sendKeys("alisa05");
        Util.waitThreadFor(1);
        WebElement signInSubmit= driver.findElement(By.xpath(AmazonPage.SIGN_IN_SUBMIT));
        signInSubmit.click();
        Util.waitThreadFor(5);
        String helloUser=driver.findElement(By.xpath(AmazonPage.HELLO_USER)).getText();
        Util.waitThreadFor(1);
        Assert.assertEquals("Hello, Hanna-Alisa",helloUser );


    }
    @After
    public void tearDown(){
        driver.quit();
    }


}

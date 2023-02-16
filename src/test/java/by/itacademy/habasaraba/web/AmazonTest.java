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


}

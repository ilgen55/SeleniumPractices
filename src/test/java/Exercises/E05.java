package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E05 extends TestBase {
    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaSayfa= driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(anaSayfa.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUser= driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUser.isDisplayed());
        //6. Enter name and already registered email address
        WebElement name= driver.findElement(By.xpath("//*[@type='text']"));
        name.sendKeys("ksm", Keys.TAB,"kasimilgen01@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        //8. Verify error 'Email Address already exist!' is visible
    }
}

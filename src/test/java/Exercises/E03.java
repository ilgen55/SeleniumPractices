package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E03 extends TestBase {
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaSayfa= driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement login= driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(login.isDisplayed());

        //6. Enter incorrect email address and password
        WebElement email= driver.findElement(By.xpath("(//*[@type='email'])[1]"));
        email.sendKeys("asimilgen01@gmail.com", Keys.TAB,"7714104");
        bekle(3);

        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrect= driver.findElement(By.xpath("//*[@style='color: red;']"));
        Assert.assertTrue(incorrect.isDisplayed());
    }
}

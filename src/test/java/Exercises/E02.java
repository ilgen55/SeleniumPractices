package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E02 extends TestBase {
    @Test
    public void test01() {
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
        //6. Enter correct email address and password
        WebElement email= driver.findElement(By.xpath("(//*[@type='email'])[1]"));
        email.sendKeys("kasimilgen01@gmail.com", Keys.TAB,"7714104f");
        bekle(3);
        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible
    }
}

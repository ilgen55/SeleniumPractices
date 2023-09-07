package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E01 extends TestBase {
    @Test
    public void test01() {
        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaSayfa= driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));

        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signupButton= driver.findElement(By.xpath("//*[@href='/login']"));
        signupButton.click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUser= driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUser.isDisplayed());

        //6. Enter name and email address
        WebElement nameKutusu= driver.findElement(By.xpath("//*[@type='text']"));
        nameKutusu.sendKeys("ksm", Keys.TAB,"shannon.adair@feerock.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }
}

package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class E06 extends TestBase {
    @Test
    public void test01() {
     // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
     // 3. Verify that home page is visible successfully
        WebElement anaSayfa= driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(anaSayfa.isDisplayed());
     // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();
        bekle(2);
     // 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch= driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());
     // 6. Enter name, email, subject and message
        WebElement name= driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));
        name.sendKeys("ksm", Keys.TAB,"kasimilgen01@gmail.com", Keys.TAB,"exercises",Keys.TAB,"çok çalışırsan başarırsın");
        bekle(3);
     // 7. Upload file
        WebElement file= driver.findElement(By.xpath("//*[@type='file']"));
        //file.click();
        bekle(2);
        // "C:\Users\Toshiba\Desktop\deneme.txt"
        String dosyaYolu="C:\\Users\\Toshiba\\Desktop\\deneme.txt";
        file.sendKeys(dosyaYolu);
        bekle(2);


     // 8. Click 'Submit' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
     // 9. Click OK button
        driver.switchTo().alert().accept();
        bekle(2);
     // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success= driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        Assert.assertTrue(success.isDisplayed());
     // 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
       // WebElement çerez=driver.findElement(By.xpath("(//*[@fill='#5F6368'])[1]"));
        WebElement çerez2=driver.findElement(By.xpath("//*[@class='ns-64e2o-e-18']"));
        try {
            çerez2.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

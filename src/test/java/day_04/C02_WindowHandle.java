package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {
    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
       String amazonHandle= driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
       String amazonUrl= driver.getCurrentUrl();
       Assert.assertTrue(amazonUrl.contains("amazon"));
       bekle(2);

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
       String bestBuyHadnle= driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
      String bestBuyTitle=  driver.getTitle();
      Assert.assertTrue(bestBuyTitle.contains("Best Buy"));
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("java", Keys.ENTER);
        bekle(2);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucu.getText().contains("java"));
        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyHadnle);
        // 8- logonun gorundugunu test edelim
        WebElement bestBuyLogo= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }
}

package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_ıframe extends TestBase {
    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        // Videoyu görecek kadar asagiya ininiz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        bekle(2);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement ıframe= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(ıframe);
        WebElement play= driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        /*
play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
bunun üzerine HTML kodlarını inceleyince play'in aslında bir iframe icerisinde oldugunu gorduk
bu durumda once iframe'i locate edip
switchTo() ile o iframe'e gecmeliyiz
 */

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());
        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement txet= driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(txet.isDisplayed());

    }
}

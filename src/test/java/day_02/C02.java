package day_02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;

public class C02 extends TestBase {
    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin


    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
       String googleTitle= driver.getTitle();
        Assert.assertTrue(googleTitle.contains("Google"));

        // arama cubuguna "Nutella" yazıp aratın
      WebElement aramaKutusu=  driver.findElement(By.xpath("//*[@class='gLFyf']"));
      aramaKutusu.sendKeys("Nutella",Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
       WebElement result= driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("Sonuç :"+result.getText());

       String arr[]= result.getText().split(" ");
        System.out.println(Arrays.toString(arr));
      String sonuc=  arr[1];
        System.out.println(sonuc);

        // sonuc sayısının 100000000  fazla oldugunu test edin
       String sonucc=sonuc.replaceAll("\\D","");
      Assert.assertTrue(Integer.parseInt(sonucc)>100000000);

    }
}


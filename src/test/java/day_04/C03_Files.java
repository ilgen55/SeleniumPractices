package day_04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Files  {
    @Test
    public void test01() {
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        // "C:\Users\Toshiba    \Desktop\text.txt"
        String farklıKısım=System.getProperty("user.home");//"C:\\Users\\Toshiba";
        String  ortakYol="\\Desktop\\text.txt";
        String dosyaYolu=farklıKısım+ortakYol;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}

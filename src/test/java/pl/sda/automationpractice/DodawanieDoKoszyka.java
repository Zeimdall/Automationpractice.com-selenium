package pl.sda.automationpractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DodawanieDoKoszyka {
    ChromeDriver przeglądarka;


    @Test
    public void dodajProduktDoKoszyka() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Chromedriver/chromedriver.exe");
        przeglądarka = new ChromeDriver();
        //przeglądarka.manage().window().maximize();
        przeglądarka.get("http://automationpractice.com");

       List<WebElement> listaProduktow = przeglądarka.findElements(
               (By.cssSelector("#homefeatured .ajax_add_to_cart_button")));


       listaProduktow.get(0).click();

        Thread.sleep(3000);
        przeglądarka.quit();


    }

}

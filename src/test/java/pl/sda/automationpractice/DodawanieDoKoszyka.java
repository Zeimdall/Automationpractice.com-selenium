package pl.sda.automationpractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class DodawanieDoKoszyka {
    ChromeDriver przeglądarka;

    @Before
    public void otwórzStronę() {
        System.setProperty("webdriver.chrome.driver", "C:/Chromedriver/chromedriver.exe");
        przeglądarka = new ChromeDriver();
        przeglądarka.manage().window().setSize(new Dimension(1024, 768));
        przeglądarka.get("http://google.com");
        przeglądarka.get("http://automationpractice.com");
    }

    @Test
    public void dodajProduktDoKoszyka() throws InterruptedException {


       List<WebElement> listaProduktow = przeglądarka.findElements(
               (By.cssSelector("#homefeatured .ajax_add_to_cart_button")));

        Actions actions = new Actions(przeglądarka);
        actions.moveToElement(listaProduktow.get(0)).perform();

        Thread.sleep(1500);
       listaProduktow.get(0).click();

        WebDriverWait wait = new WebDriverWait(przeglądarka, 10);
        WebElement potwierdzenieDodania = przeglądarka.findElement(By.cssSelector("#layer_cart"));
        wait.until(ExpectedConditions.visibilityOf(potwierdzenieDodania));

       przejdzDoKoszyka();
    }

    private void przejdzDoKoszyka() {
        przeglądarka.findElement(By.cssSelector("#layer_cart .button-container .button-medium")).click();
    }

    @After
    public void zamknijStronę() throws InterruptedException {

            Thread.sleep(3000);
        przeglądarka.quit();
    }

}

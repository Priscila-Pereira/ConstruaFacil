// 1 - Pacote
package webTests;

// 2 - Bibliotecas

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// 3 - Classe
public class seleniumSimples {
    // 3.1 - Atributos

    WebDriver driver;        // declarar o objeto do Selenium Webdriver


    // 3.2 - Métodos e Funções
    @BeforeMethod
    public void iniciar(){

        // A - Início
        // Aponta para onde está o driver do chrome
        System.setProperty("webdriver.chrome.driver","drivers/chrome/91/chromedriver.exe");
        // Instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void finalizar(){
        // C - Encerramento
        driver.quit(); // Encerra o objeto do selenium
    }

    @Test(priority = 2)
    public void consultarCursoMantis(){
        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");          // Abre o site do teste alvo informado
        driver.findElement(By.id("searchtext")).click();    // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();    // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis"); // Escreve "mantis" no campo de pesquisa

        driver.findElement(By.id("btn_form_search")).click(); // Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos › \"mantis\"");

        //assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("mantis"));

        driver.findElement(By.cssSelector("span.comprar")).click();  // Clica no botão Matricule-se

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99");



    }

    @Test(priority = 1)
    public void consultarCursoPreparatórioCTFL(){
        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");          // Abre o site do teste alvo informado
        driver.findElement(By.id("searchtext")).click();    // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();    // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("preparatório ctfl"); // Escreve "fundamentos" no campo de pesquisa

        driver.findElement(By.id("btn_form_search")).click(); // Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos › \"preparatório ctfl\"");

        //assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("mantis"));

        driver.findElement(By.cssSelector("span.comprar")).click();  // Clica no botão Matricule-se

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Preparatório CTFL");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 169,00");


    }
}

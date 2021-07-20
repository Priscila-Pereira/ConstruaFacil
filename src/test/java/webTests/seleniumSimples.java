// 1 - Pacote
package webTests;

// 2 - Bibliotecas

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import utils.Evidencias;
import utils.Logs;

// 3 - Classe
public class seleniumSimples {
    // 3.1 - Atributos

    WebDriver driver;        // declarar o objeto do Selenium Webdriver
    Evidencias evidencias;
    Logs logs;
    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());


    // 3.2 - Métodos e Funções

    // Executa 1 vez apenas, no início da execução do script
    @BeforeClass
    public void antesDeTudo() throws IOException {
        logs = new Logs();
        logs.iniciarLogCSV(dataHora);
    }

    // Executa antes de cada @Test
    @BeforeMethod
    public void iniciar(){

        // A - Início
        // Aponta para onde está o driver do chrome
        System.setProperty("webdriver.chrome.driver","drivers/chrome/91/chromedriver.exe");
        // Instancia o objeto driver como um controlador do Chrome

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        evidencias = new Evidencias();


    }

    @AfterMethod
    public void finalizar(){
        // C - Encerramento
        driver.quit(); // Encerra o objeto do selenium
    }

    @Test(priority = 2)
    public void consultarCursoMantis() throws IOException {
        String casoDeTeste = "Consultar Curso mantis";

        // B - Realizar o teste

        logs.registrarCSV(casoDeTeste, "Iniciou o teste");
        driver.get("https://www.iterasys.com.br");          // Abre o site do teste alvo informado
        logs.registrarCSV(casoDeTeste, "Abriu o site");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 1 - Abriu o site");

        driver.findElement(By.id("searchtext")).click();    // Clica no campo de pesquisa
        logs.registrarCSV(casoDeTeste, "Clicou na caixa de pesquisa");
        driver.findElement(By.id("searchtext")).clear();    // Limpa o campo de pesquisa
        logs.registrarCSV(casoDeTeste, "Limpou a caixa de pesquisa");
        driver.findElement(By.id("searchtext")).sendKeys("mantis"); // Escreve "mantis" no campo de pesquisa
        logs.registrarCSV(casoDeTeste, "Escreveu o nome do curso na caixa de pesquisa");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 2 - Digitou Mantis");

        driver.findElement(By.id("btn_form_search")).click(); // Clique na lupa
        logs.registrarCSV(casoDeTeste, "Clicou na lupa ");
        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos › \"mantis\"");
        logs.registrarCSV(casoDeTeste, "Confirmou o texto indicativo da pesquisa do curso ");
        //assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("mantis"));

        evidencias.print(driver, dataHora, casoDeTeste, "Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();  // Clica no botão Matricule-se
        logs.registrarCSV(casoDeTeste, "Clicou no botão Matricule-se");

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis");
        logs.registrarCSV(casoDeTeste, "Confirmou o nome do curso");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99");
        logs.registrarCSV(casoDeTeste, "Confirmou o preço do curso");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 4 - Exibiu o carrinho de compras");
        logs.registrarCSV(casoDeTeste, "Concluiu o teste        ");

    }

    @Test(priority = 1)
    public void consultarCursoPreparatórioCTFL() throws IOException {
        String casoDeTeste = "Consultar Curso CTFL";
        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");          // Abre o site do teste alvo informado
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 1 - Abriu o site");

        driver.findElement(By.id("searchtext")).click();    // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();    // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("preparatório ctfl"); // Escreve "fundamentos" no campo de pesquisa

        evidencias.print(driver, dataHora, casoDeTeste, "Passo 2 - Digitou preparatorio ctfl");
        driver.findElement(By.id("btn_form_search")).click(); // Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos › \"preparatório ctfl\"");

        //assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("mantis"));

        evidencias.print(driver, dataHora, casoDeTeste, "Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();  // Clica no botão Matricule-se

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Preparatório CTFL");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 169,00");

        evidencias.print(driver, dataHora, casoDeTeste, "Passo 4 - Exibiu o carrinho de compras");

    }
}

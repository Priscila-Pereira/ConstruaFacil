package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    // Classe de mapeamento possui 3 seções
    // 1 - Mapeamento de elementos (Atributos)
    // 2 - Construtor entre os elementos e os passo
    // 3 - Funções e métodos mapeados

    // 1 - Mapeamento
    WebDriver driver;

    @FindBy(id = "searchtext")
    WebElement caixaDePesquisa;
    // Similar ao que fazíamos antes
    // driver.findElements(By.id("searchText"))

    @FindBy(id = "btn_form_search")
    WebElement botaoProcurar; // btnProcurar

    // 2 - Construtor

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Funções e métodos
    public void pesquisarPorCurso(String curso){
        caixaDePesquisa.click();           // clicar na caixa
        caixaDePesquisa.clear();           // limpar a caixa
        caixaDePesquisa.sendKeys(curso);   // escrever na caixa

    }
    public void clicarNaLupa(){
        botaoProcurar.click();             // clicar no botão

    }
}


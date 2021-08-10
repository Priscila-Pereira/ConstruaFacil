package stepsPO;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/featuresPO"}, //Onde estão os cenários em Gherkin
        glue     = {"stepsPO"},                      //Onde estão definições de passos
        dryRun   = false,                            // Exibição de log
        monochrome = true,                           // Detalhes do log
        plugin = {
                "pretty",                            // formatacao visual do Cucumber
                "html:target/reports/extentreports", // saida html do relatorio simples
                "json:target/reports/extentreports.json"// saida json com os dados
                //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"




        }
)
public class Runner extends AbstractTestNGCucumberTests{
    // Configuração de modelo de relatório ou de outra característica
}

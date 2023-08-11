//Classe criada para executar os cenários de teste com o próprio Cucumber
package org.examples;

import constantes.ConstantesChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
//eu poderia utilizar uma dependência API, porém estou usando a dependencia da versao 7 do cucumber e, a dependencia cucumber.api, é de uma versão anterior
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.chrome.ChromeDriver;

//O RunWith é do JUnit, então eu estou basicamente especificando um runner personalizado pra executar os testes, no caso o Cucumber

@RunWith(Cucumber.class)
//No features, estou especificando o caminho pro diretório que os arquivos de feature estão
//No glue, especifico o pacote daquela classe de passo a passo que criei com Cucumber (passo a passo de cada cenário)
@CucumberOptions(
        features = {
                "C:\\Projetos\\Java\\ForwardCarTestAutomation\\src\\test\\java\\resources",
        },
        glue = {
                "org.examples"
        },
        tags = "@%CT001"
)

//Com a configuração feita, quando eu clicar pra executar com o testRunner
//O cucumber tem que acessar os cenarios que fiz e coloquei no features
//e vai usar isso pra executar a classe CenariosAppTest
public class TestRunner {

}

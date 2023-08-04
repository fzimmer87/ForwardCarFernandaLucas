package org.examples;

import PageObject.*;
import constantes.ConstantesChromeDriver;
import constantes.ConstantesUrls;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class StepsTest {
    private ChromeDriver driver;
    private CommomSteps commomSteps;

    @BeforeClass
    public static void configCaminhoChromeDriver() {
        System.out.println(ConstantesChromeDriver.OPCAO_CONFIG_CHROME_DRIVER);
        System.out.println(ConstantesChromeDriver.CAMINHO_CHROME_DRIVER);
    }
    @Before
    public void criarNovoNavegador() {
        driver = new ChromeDriver();
        commomSteps = new CommomSteps(driver);
    }

    @After
    public void fecharNavegador() {
        driver.quit();
    }

    ///////////////////////////////////////////////////
    //////////////////    CT001     ///////////////////
    ///////////////////////////////////////////////////
    @Given("Que o usuário está na página da ForwardCar acessando o ambiente virtual")
    public void queOUsuárioEstáNaPáginaDaForwardCarAcessandoOAmbienteVirtual() throws InterruptedException {
        //Instanciando ChromeDriver para poder usar no get
        driver.get(ConstantesUrls.URL_PAGINA_PRINCIPAL);
        Thread.sleep(5000);
    }
    @When("Eu clicar no botão {string} no cabeçalho da página")
    public void euClicarNoBotãoNoCabeçalhoDaPágina(String arg0) throws InterruptedException {
        RedirectLoanApplication redirectLoanApplication = new RedirectLoanApplication(driver);
        redirectLoanApplication.clicarBotaoLoanApplication();
        Thread.sleep(5000);
    }

    //Deveria fazer mais uma validação da exibição dos campos de input de Username e Password?
    @And("For solicitado Login e Senha")
    public void forSolicitadoLoginESenha() throws InterruptedException {
        RedirectLoginPage redirectLoginPage = new RedirectLoginPage(driver);
        redirectLoginPage.isContainerLoginDisponivel();
        Thread.sleep(5000);
    }
    @And("eu inserir os dados em Username e Password e os enviar")
    public void euInserirOsDadosEmUsernameEPasswordEOsEnviar(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        //Isso daqui provavelmente vai dar erro, pois na segunda iteração ele irá falhar
        //Como coloquei a massa de dados errada primeiro, ele funciona tranquilamente, caso fosse o contrário, provavelmente falharia
        //pensar em solução para esse problema
        for (Map<String, String> linhas : data) {
            String username = linhas.get("Username");
            String password = linhas.get("Password");
            String isValidoValue = linhas.get("isValido");

            boolean isValido = Boolean.parseBoolean(isValidoValue);

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enviarCaracteresParaCampoInput(username, password);
            Thread.sleep(2000);
            loginPage.enviarInfosLogin();
            Thread.sleep(5000);

            if(!isValido) {
                //Garantir que uma mensagem de erro com credenciais é exibida na tela
                loginPage.isAuthenticationErrorMessageDisponivel();
                Thread.sleep(5000);
                loginPage.apagarCredenciasInseridas();
                Thread.sleep(5000);
            }
        }
    }
    @Then("Devo ser autenticado e redirecionado para a página {string}")
    public void devoSerAutenticadoERedirecionadoParaAPágina(String arg0) throws InterruptedException {
        AutenticacaoPage autenticacaoPage = new AutenticacaoPage(driver);
        autenticacaoPage.isNaPaginaPrincipal();
        autenticacaoPage.isLogado();
        Thread.sleep(5000);

        //Poderia levar como erro por ser redirecionado para a página de Home e não de Loan Application?
    }

    ///////////////////////////////////////////////////
    //////////////////    CT002     ///////////////////
    ///////////////////////////////////////////////////
    @Given("Que o usuário está autenticado na página Loan Application")
    public void queOUsuárioEstáAutenticadoNaPáginaLoanApplicationCT002() throws InterruptedException {
        commomSteps.queOUsuarioEstaAutenticadoNaPaginaLoanApplication();
    }
    @When("Eu preencher cada campo do formulário de Finance Application com os seguintes valores:")
    public void euPreencherCadaCampoDoFormulárioDeFinanceApplicationComOsSeguintesValores(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        boolean checkTeste = false;

        for(Map<String, String> linha : data) {
            String campo = linha.get("Campo");
            String valor = linha.get("Valor");
            String aceitacao = linha.get("Aceitacao");
            Boolean isAceito = Boolean.parseBoolean(aceitacao);

            LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
            loanApplicationPage.enviarCaracteresCampoInputSwithCase(campo, valor, checkTeste, isAceito);
            Thread.sleep(1000);
        }
    }
    @Then("A inserção desses valores nos campos respectivos deve ser aceita")
    public void aInserçãoDessesValoresNosCamposRespectivosDeveSerAceita(List<Map<String, String>> data) {
        boolean checkTeste = true;

        for(Map<String, String> linha : data) {
            String campo = linha.get("Campo");
            String valor = linha.get("Valor");
            String aceitacao = linha.get("Aceitacao");
            Boolean isAceito = Boolean.parseBoolean(aceitacao);

            LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
            loanApplicationPage.enviarCaracteresCampoInputSwithCase(campo, valor, checkTeste, isAceito);
        }
    }

    ///////////////////////////////////////////////////
    //////////////////    CT003     ///////////////////
    ///////////////////////////////////////////////////
    @Given("Que o user está autenticado na página Loan Application")
    public void queOUserEstáAutenticadoNaPáginaLoanApplication() throws InterruptedException {
            commomSteps.queOUsuarioEstaAutenticadoNaPaginaLoanApplication();
    }

    @When("Eu não preencher nenhum campo com nenhum valor na página Loan Application")
    public void euNãoPreencherNenhumCampoComNenhumValorNaPáginaLoanApplication(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        boolean checkTeste = false;
        boolean isAceito = false;

        for(Map<String, String> linha : data) {
            String campo = linha.get("Campo");
            String valor = linha.get("Valor");

            LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
            loanApplicationPage.tornarCamposVazios(campo, valor);
            Thread.sleep(1000);
        }
    }
    @And("Clicar no botão {string}")
    public void clicarNoBotão(String arg0) throws InterruptedException {
        LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
        loanApplicationPage.clicarBotaoApply();
        Thread.sleep(7000);
    }
    @Then("Deve ocorrer uma falha no envio do formulário e a solicitação de empréstimo não deve ser enviada")
    public void deveOcorrerUmaFalhaNoEnvioDoFormulárioEASolicitaçãoDeEmpréstimoNãoDeveSerEnviada() throws InterruptedException{
        LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);

        boolean isMensagemExibidanaTela = loanApplicationPage.ismodalTitleDisplayed();

        if(isMensagemExibidanaTela) {
            System.out.println("BUG: a mensagem está sendo exibida na tela nessas condições");
        }
    }

    ///////////////////////////////////////////////////
    //////////////////    CT004     ///////////////////
    ///////////////////////////////////////////////////
    @Given("Que o user está autenticado na página Loan Application")
    public void queOUsuarioEstáAutenticadoNaPáginaLoanApplication() throws InterruptedException {
        commomSteps.queOUsuarioEstaAutenticadoNaPaginaLoanApplication();
    }
    @When("Eu preencher cada campo do formulário com valores válidos")
    public void euPreencherCadaCampoDoFormulárioComValoresVálidos() {

    }
}

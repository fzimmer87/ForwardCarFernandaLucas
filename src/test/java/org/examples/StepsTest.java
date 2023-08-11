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

import java.util.ArrayList;
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
        //RedirectLoanApplication redirectLoanApplication = new RedirectLoanApplication(driver);
        //redirectLoanApplication.clicarBotaoLoanApplication();
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
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    ///////////////////////////////////////////////////
    //////////////////    CT004     ///////////////////
    ///////////////////////////////////////////////////
    @When("Eu preencher cada campo do formulário com valores válidos")
    public void euPreencherCadaCampoDoFormulárioComValoresVálidos(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        boolean checkTeste = false;
        boolean isAceito = false;


        for (Map<String, String> linha : data) {
            String campo = linha.get("Campo");
            String valor = linha.get("Valor");

            LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
            loanApplicationPage.enviarCaracteresCampoInputSwithCase(campo, valor, checkTeste, isAceito);
            Thread.sleep(1000);
        }
    }

    @Then("O envio do formulário deve ser feito com sucesso, sendo exibida a mensagem {string}")
    public void oEnvioDoFormulárioDeveSerFeitoComSucessoSendoExibidaAMensagem(String arg0) throws InterruptedException{
        LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
        Thread.sleep(10000);

        boolean isMensagemExibidanaTela = loanApplicationPage.ismodalTitleDisplayed();

        if(isMensagemExibidanaTela) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    ///////////////////////////////////////////////////
    //////////////////    CT005     ///////////////////
    ///////////////////////////////////////////////////
    @When("Eu preencher cada campo do formulário com valores inválidos")
    public void euPreencherCadaCampoDoFormulárioComValoresInválidos(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        boolean checkTeste = false;
        boolean isAceito = false;


        for(Map<String, String> linha : data) {
            String campo = linha.get("Campo");
            String valor = linha.get("Valor");

            LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
            loanApplicationPage.enviarCaracteresCampoInputSwithCase(campo, valor, checkTeste, isAceito);
            Thread.sleep(1000);
        }
    }

    @Then("Deve ocorrer uma falha no envio do formulário e a mensagem de {string}")
    public void deveOcorrerUmaFalhaNoEnvioDoFormulárioEAMensagemDe(String arg0) throws InterruptedException {
        LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
        Thread.sleep(10000);

        boolean isMensagemExibidanaTela = loanApplicationPage.ismodalTitleDisplayed();

        if (isMensagemExibidanaTela) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    ///////////////////////////////////////////////////
    //////////////////    CT006     ///////////////////
    ///////////////////////////////////////////////////

    @When("Eu clicar no Botão {string} no cabeçalho da página")
    public void euClicarNoBotãoVinLookupNoCabeçalhoDaPágina(String arg0) {
        RedirectVinLookup redirectVinLookup = new RedirectVinLookup(driver);
        redirectVinLookup.clickButtonVinLookup();
    }

    @Then("Devo ser redirecionado para a página {string}")
    public void devoSerRedirecionadoParaAPágina(String arg0) {
        RedirectVinLookup redirectVinLookup = new RedirectVinLookup(driver);
        String urlAtual = redirectVinLookup.getUrlAtual();

        if (urlAtual.equals(ConstantesUrls.URL_PAGINA_VIN_LOOKUP)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        
    }

    ///////////////////////////////////////////////////
    //////////////////    CT007     ///////////////////
    ///////////////////////////////////////////////////

    @When("Eu pressionar o botão {string} no cabeçalho da página")
    public void euPressionarOBotãoSearchNoCabeçalhoDaPágina(String arg0) throws InterruptedException {
        RedirectSearch redirectSearch = new RedirectSearch(driver);
        redirectSearch.clickButtonSearch();
        Thread.sleep(5000);
    }

    @Then("Devo ser redirecionado para a pagina search")
    public void devoSerRedirecionadoParaAPaginaSearch() {
        RedirectSearch redirectSearch = new RedirectSearch(driver);
        String urlAtual = redirectSearch.getUrlAtual();

        if (urlAtual.equals(ConstantesUrls.URL_PAGINA_SEARCH)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    @And("Deve ser exibida a lista de carros cadastrados no Inventory da ForwardCar")
    public void deveSerExibidaAListaDeCarrosCadastradosNoInventoryDaForwardCar() {
        SearchPage searchPage = new SearchPage(driver);
        if (searchPage.isCarsListDisponivel()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    ///////////////////////////////////////////////////
    //////////////////    CT008     ///////////////////
    ///////////////////////////////////////////////////

    @Given("Que o usuário está na página VIN Lookup")
    public void queOUsuárioEstáNaPáginaVINLookup() throws  InterruptedException {
        driver.get(ConstantesUrls.URL_PAGINA_VIN_LOOKUP);    
        Thread.sleep(5000);
    }

    @When("inserir o codigo VIN <VIN> do carro <NomeCarro> no campo Vehicle History Report")
    public void inserirOCodigoVINVINDoCarroNomeCarroNoCampoVehicleHistoryReport(String VIN) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enviarVinCampoInput(VIN);
    }
    @And("Pressionar o botao {string}")
    public void pressionarOBotao(String arg0) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickBtnVinLookup();
    }

    @Then("O histórico do carro <NomeCarro> deve ser exibido")
    public void oHistóricoDoCarroNomeCarroDeveSerExibido() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.getValoresVinLookup();
    }

    ///////////////////////////////////////////////////
    //////////////////    CT009     ///////////////////
    ///////////////////////////////////////////////////

    @Given("Que o usuário está na página Search como Admin")
    public void queOUsuárioEstáNaPáginaSearchComoAdmin() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.tornarAdmin();
    }
    @When("Eu clicar no botão {string} debaixo de algum carro")
    public void euClicarNoBotãoDeleteDebaixoDeAlgumCarro() {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.clickDelete();
    }
    @And("Confirmar a ação de deletar o carro")
    public void confirmarAAçãoDeDeletarOCarro() {
     SearchPage searchPage = new SearchPage(driver);
     searchPage.confirmarDelete();
    }
    
    @Then("O carro deve ser deletado do banco de dados")
    public void oCarroDeveSerDeletadoDoBancoDeDados() {

    
    }
}




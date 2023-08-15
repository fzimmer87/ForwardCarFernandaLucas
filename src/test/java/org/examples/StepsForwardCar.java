package org.examples;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import Constantes.ConstanteChromeDriver;
import Constantes.ConstantesFordWardCar;
import PageObjects.ConstantesCampoBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;



public class StepsForwardCar {
    private ChromeDriver driver;
    private ConstantesCampoBy constantesCampoBy;

    @Before
    public void IniciarDriverAntesdeCadaTeste(){
        System.setProperty(ConstanteChromeDriver.CONST_CHROME_DRIVER, ConstanteChromeDriver.CONST_CAMINHO_CHROME_DRIVER);
        driver = new ChromeDriver();
        constantesCampoBy = new ConstantesCampoBy(driver);
    }

    @After
    public void fecharNavegador(){
        driver.quit();
    }


    @Dado("que estou na página da Forward Car")
    public void queEstouNaPaginaDaForwardCar() throws InterruptedException {

        driver.get(ConstantesFordWardCar.URL_PAGINA_INICIAL);
        Thread.sleep(3000);
    }
    @Dado("que estou na pagina inventory da Forward Car")
    public void queEstouNaPaginaInventoryDaForwardCar() throws InterruptedException{
        driver.get(ConstantesFordWardCar.URL_PAGINA_INVETORY);
        Thread.sleep(3000);
    }

    @Quando("clico em search")
    public void clicoEmSearch() throws InterruptedException{
        constantesCampoBy.PesquisarNoCamposSearch();
        Thread.sleep(3000);
    }

    @E("digito {string}")
    public void digito(String Acura) throws InterruptedException {
        constantesCampoBy.DigitarNoCampoSearch();
        Thread.sleep(3000);
    }

    @Entao("aparecem modelos de carro acura")
    public void aparecemModelosDeCarroAcura() {
        constantesCampoBy.AcharElementoPainel();
    }

    @E("digito")
    public void digito(DataTable dataTable) throws InterruptedException{
        List<String> coresDigitadas = dataTable.asList(String.class);
        for (String novaCor: coresDigitadas) {
            constantesCampoBy.DigitarCorEncontradanaTabela(novaCor);
            Thread.sleep(3000);
            constantesCampoBy.ClicarBotaoViewsDetaisls(novaCor);
            Thread.sleep(3000);
        }
        constantesCampoBy.ClicarBotaoClear();
    }

    @Entao("aparecem modelos de carro da cor digitada")
    public void aparecemModelosDeCarroDaCorDigitada() {

    }
    @E("clico no cadeado")
    public void clicoNoCadeado() {
        constantesCampoBy.ClicarBotaoCadeado();
    }


    @Entao("cadeado não abre sem pedir login e senha como admin")
    public void cadeadoNaoAbreSemPedirLoginESenhaComoAdmin() {
        if (constantesCampoBy.TelaAdminIsDisplayed()){
            System.out.println(false);
        }
    }

    @E("clico em delete")
    public void clicoEmDelete() throws InterruptedException{
        Thread.sleep(3000);
        constantesCampoBy.ClicarBotaoDelete();

    }


    @Quando("clico em ok")
    public void clicoEmOk() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @E("clico em Add Car")
    public void clicoEmAddCar() throws InterruptedException{
        constantesCampoBy.ClicarBotaoAddCar();
        Thread.sleep(3000);
    }

    @Quando("clico em Population From")
    public void clicoEmPopulationFrom() throws InterruptedException{
        constantesCampoBy.ClicarNoBotaoPopulationFrom();
        Thread.sleep(3000);
    }

    @E("modifico o campo preco para {string}")
    public void modificoOCampoPrecoPara(String arg0) throws InterruptedException {
        constantesCampoBy.LimparCampoPrice();
        constantesCampoBy.DeixarCampoPriceZerado();
        Thread.sleep(3000);
    }
    @E("clico em Create")
    public void clicoEmCreate() throws InterruptedException {
        constantesCampoBy.ClicarBotaoCreate();
        Thread.sleep(3000);
    }
    @Entao("sistema nao inclui um modelo novo e nao mostra mensagem car created")
    public void sistemaNaoIncluiUmModeloNovoENaoMostraMensagemCarCreated() throws InterruptedException {
        Thread.sleep(3000);
        if(constantesCampoBy.AcharBotaoCarCreatedNaTela());
        System.out.println(false);
    }

    @Entao("sistema mostra mensagem Car Deleted")
    public void sistemaMostraMensagemCarDeleted() throws InterruptedException {
        Thread.sleep(3000);
        if (constantesCampoBy.AcharMensagemCarDeletedNaTela());
        System.out.println(true);
    }

    @E("clico em Register")
    public void clicoEmRegister() throws InterruptedException {
        constantesCampoBy.ClicarBotaoRegister();
        Thread.sleep(3000);
    }

    @Quando("digito campo FIRST NAME, LAST NAME, USARNAME, PASSWORD com dados")
    public void digitoCampo(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> registrarUsuario = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> NovoUsuario : registrarUsuario) {
            String firstName = NovoUsuario.get("first name");
            String lastName = NovoUsuario.get("last name");
            String username = NovoUsuario.get("username");
            String password = NovoUsuario.get("password");
            constantesCampoBy.preencherFirstName(firstName);
            Thread.sleep(5000);
            constantesCampoBy.preencherLastName(lastName);
            Thread.sleep(5000);
            constantesCampoBy.preencherUsarname(username);
            Thread.sleep(5000);
            constantesCampoBy.preencherPassword(password);
            constantesCampoBy.clicarBotaoRegister();
        }
    }

    @Entao("só consigo realizar o Registro com todos os campos preenchidos")
    public void soConsigoRealizarORegistroComTodosOsCamposPreenchidos()throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),ConstantesFordWardCar.URL_PAGINA_LOGIN);
    }


    @E("clico no botao Guest")
    public void clicoNoBotaoGuest() throws InterruptedException{
        constantesCampoBy.ClicarNoBotaoGuest();
        Thread.sleep(4000);
    }

    @E("clico no botao Make Acura")
    public void clicoNoBotaoMakeAcura()throws InterruptedException {
        Thread.sleep(3000);
        constantesCampoBy.ClicarNoBortaoAcura();
    }

    @Quando("clico no botao Model RLX-AWD")
    public void clicoNoBotaoModelRLXAWD()throws InterruptedException{
        Thread.sleep(3000);
        constantesCampoBy.ClicarNoBotaoModelRLXAWD();
    }

    @Entao("aparecem modelos de carro Acura RLX-AWD")
    public void aparecemModelosDeCarroAcuraRLXAWD() throws InterruptedException {
        Thread.sleep(3000);
        constantesCampoBy.validarCampoMakeAcuraRLXAWD();
    }

    @E("clico campo busca search")
    public void clicoCampoBuscaSearch()throws InterruptedException {
        Thread.sleep(3000);
        constantesCampoBy.ClicarNoCampoSearch();
    }


    @E("realizo meu login com Usarname e Senha")
    public void realizoMeuLoginComUsarnameESenha() throws InterruptedException{
        Thread.sleep(3000);
        constantesCampoBy.RealizarLoginComUsarnameSenha();
    }

    @E("clico onde esta meu nome Guest")
    public void clicoOndeEstaMeuNomeGuest() throws InterruptedException{
        Thread.sleep(3000);
        constantesCampoBy.ClicarNoCampoGuestLogado();

    }
    @Quando("clico em Loan Status")
    public void clicoEmLoanStatus() throws InterruptedException {
        constantesCampoBy.ClicarNoBotaoLoanStatus();
        Thread.sleep(3000);
    }

    @Entao("sou encaminhado para pagina onde verifico meus emprestimos e financiamentos")
    public void souEncaminhadoParaPaginaOndeVerificoMeusEmprestimosEFinanciamentos()throws InterruptedException {
        Thread.sleep(3000);
        String URL_nova = driver.getCurrentUrl();
        if (URL_nova == ConstantesFordWardCar.URL_PAGINA_LOAN_STATUS) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    @Quando("digito o ano de algum modelo de carro")
    public void digitoOAnoDeAlgumModeloDeCarro(DataTable dataTable)throws InterruptedException {
        List<String> anoDigitado = dataTable.asList(String.class);
        for (String novoAno : anoDigitado) {
            constantesCampoBy.digitarAnoDosCarros(novoAno);
            Thread.sleep(3000);
            Assert.assertTrue(constantesCampoBy.pegarTextoDoCampoYear(novoAno));
        }
    }
    @E("clico em Guest")
    public void clicoEmGuest()throws InterruptedException{
        constantesCampoBy.ClicarNoBotaoGuest();
        Thread.sleep(3000);
    }

    @E("clico em Login")
    public void clicoEmLogin() {
        constantesCampoBy.ClicarBotaoLogin();
    }

    @Quando("preencho usarname e passoword com dados já cadastrado no Register")
    public void preenchoUsarnameEPassowordComDadosJáCadastradoNoRegister() throws InterruptedException {
        constantesCampoBy.RealizarLoginComUsarnameSenha();
    }

    @Entao("sistema me encaminha para pagina principal da Forward Car")
    public void sistemaMeEncaminhaParaPaginaPrincipalDaForwardCar() {
        String URL_nova = driver.getCurrentUrl();
        if (URL_nova == ConstantesFordWardCar.URL_PAGINA_INICIAL) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    @Dado("que estou na pagina login da ForwardCar")
    public void queEstouNaPaginaLoginDaForwardCar() throws InterruptedException{
        driver.get(ConstantesFordWardCar.URL_PAGINA_LOGIN);
        Thread.sleep(3000);
    }

    @Entao("aparecem modelos do ano que digitei")
    public void aparecemModelosDoAnoQueDigitei() {
    }
}












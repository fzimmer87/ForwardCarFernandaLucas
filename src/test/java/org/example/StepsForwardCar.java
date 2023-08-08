package org.example;

import Constantes.ConstanteChromeDriver;
import Constantes.ConstantesFordWardCar;
import PageObjects.ConstantesCampoBy;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;



public class StepsForwardCar {
    private WebDriver driver;
    @BeforeClass
    public void AbrirNavegador() {
        System.setProperty(ConstanteChromeDriver.CONST_CHROME_DRIVER, ConstanteChromeDriver.CONST_CAMINHO_CHROME_DRIVER);

    }
    @Before
    public void IniciarDriverAntesdeCadaTeste(){
        driver = new ChromeDriver();
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

    @Quando("clico em search")
    public void clicoEmSearch() throws InterruptedException{
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.PesquisarNoCamposSearch();
        Thread.sleep(3000);
    }

    @E("digito {string}")
    public void digito(String Acura) throws InterruptedException {
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.DigitarNoCampoSearch();
        Thread.sleep(3000);
    }

    @Entao("aparecem modelos de carro acura")
    public void aparecemModelosDeCarroAcura() {
        List<WebElement> CarrosdaLista = driver.findElements(By.className("panel-heading"));
        String nomeDoCarro = "Acura";
        Boolean resultadoContemNomeCarro = true;
        for (WebElement carros : CarrosdaLista) {
            String nomeDaBusca = carros.getText();
            if (!nomeDaBusca.contains(nomeDoCarro)) {
                resultadoContemNomeCarro = false;
            }
        }
        System.out.println(resultadoContemNomeCarro);
    }


    @E("digito RED,BLUE,GREEN,BLACK,SILVER")
    public void digitoREDBLUEGREENBLACKSILVER(DataTable dataTable) throws InterruptedException{
        List<String> coresDigitadas = dataTable.asList(String.class);
        ConstantesCampoBy campoBy = new ConstantesCampoBy(driver);

        for (String novaCor: coresDigitadas) {
            campoBy.DigitarCorEncontradanaTabela(novaCor);
            Thread.sleep(3000);

            List<WebElement> botoesViewsDetails = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div/div/div[3]/button[1]"));            campoBy.ClicarBotaoViewsDetaisls();

            for (WebElement botaoViewDetail : botoesViewsDetails){
                botaoViewDetail.click();
                Thread.sleep(3000);
                campoBy.resultadoCor();
                campoBy.ClicarBotaoOkCampoViewsDetails();
                Thread.sleep(3000);
            }
            campoBy.ClicarBotaoClear();
        }
    }
    @Entao("aparecem modelos de carro da cor digitada")
    public void aparecemModelosDeCarroDaCorDigitada() {
        driver.quit();
    }
    @E("clico no cadeado")
    public void clicoNoCadeado() {
        ConstantesCampoBy campoBy = new ConstantesCampoBy(driver);
        campoBy.ClicarBotaoCadeado();
    }


    @Entao("cadeado não abre sem pedir login e senha como admin")
    public void cadeadoNaoAbreSemPedirLoginESenhaComoAdmin() {
        ConstantesCampoBy campoBy = new ConstantesCampoBy(driver);
        if (campoBy.TelaAdminIsDisplayed()){
            System.out.println(false);
        }
    }

    @E("clico em delete")
    public void clicoEmDelete() throws InterruptedException{
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        Thread.sleep(3000);
        campoByTeste1.ClicarBotaoDelete();
        Thread.sleep(3000);
    }


    @Quando("clico em ok")
    public void clicoEmOk() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @E("clico em Add Car")
    public void clicoEmAddCar() throws InterruptedException{
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.ClicarBotaoAddCar();
        Thread.sleep(3000);
    }

    @Quando("clico em Population From")
    public void clicoEmPopulationFrom() throws InterruptedException{
        ConstantesCampoBy campoBy = new ConstantesCampoBy(driver);
        campoBy.ClicarNoBotaoPopulationFrom();
        Thread.sleep(3000);
    }

    @E("modifico o campo preco para {string}")
    public void modificoOCampoPrecoPara(String arg0) throws InterruptedException {
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.LimparCampoPrice();
        campoByTeste1.DeixarCampoPriceZerado();
        Thread.sleep(3000);
    }
    @E("clico em Create")
    public void clicoEmCreate() throws InterruptedException {
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.ClicarBotaoCreate();
        Thread.sleep(3000);
    }
    @Entao("sistema nao inclui um modelo novo e nao mostra mensagem car created")
    public void sistemaNaoIncluiUmModeloNovoENaoMostraMensagemCarCreated() throws InterruptedException {
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        Thread.sleep(3000);
        if(campoByTeste1.AcharBotaoCarCreatedNaTela());
        System.out.println(false);
    }

    @Entao("sistema mostra mensagem Car Deleted")
    public void sistemaMostraMensagemCarDeleted() throws InterruptedException {
        ConstantesCampoBy campoByTeste = new ConstantesCampoBy(driver);
        Thread.sleep(3000);
        if (campoByTeste.AcharMensagemCarDeletedNaTela());
        System.out.println(true);
    }
}












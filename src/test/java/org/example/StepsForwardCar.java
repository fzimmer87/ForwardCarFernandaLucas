package org.example;

import Constantes.ConstanteChromeDriver;
import Constantes.ConstantesFordWardCar;
import PageObjects.ConstantesCampoBy;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.hamcrest.core.Is.is;


public class StepsForwardCar {
    private WebDriver driver;

    @After
    public void fecharNavegador(){
        driver.quit();
    }

    @Dado("que estou na página da Forward Car")
    public void queEstouNaPaginaDaForwardCar() throws InterruptedException {
        System.setProperty(ConstanteChromeDriver.CONST_CHROME_DRIVER, ConstanteChromeDriver.CONST_CAMINHO_CHROME_DRIVER);
        driver=new ChromeDriver();
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
        for (String novaCor: coresDigitadas) {
            String corAtual = novaCor;
            Thread.sleep(3000);
            ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/label/input")).sendKeys(corAtual);
            Thread.sleep(3000);
            campoByTeste1.ClicarBotaoClear();
            Thread.sleep(3000);
        }
    }
    @Entao("aparecem modelos de carro da cor digitada")
    public void aparecemModelosDeCarroDaCorDigitada() {//criar outra lista e validar no entao
    }
    @E("clico no cadeado")
    public void clicoNoCadeado() {
        driver.findElement(By.cssSelector("#admin")).click();
    }


    @Entao("cadeado não abre sem pedir login e senha como admin")
    public void cadeadoNaoAbreSemPedirLoginESenhaComoAdmin() {
        Boolean abrirTelaDeAcesso = false;
        if (abrirTelaDeAcesso.equals(driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(2) div.row.ng-scope div.ng-scope div.container div.row div.col-sm-3 div.list-group:nth-child(2) div.list-group-item.ng-binding > button.center-block.btn.btn-primary.btn-block.btn-sm:nth-child(2)"))));
        System.out.println("Teste falhou");

    }

    @E("clico em delete")
    public void clicoEmDelete(){
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.ClicarBotaoDelete();
    }


    @Quando("clico em ok")
    public void clicoEmOk() throws InterruptedException {
        Assert.assertThat(driver.switchTo().alert().getText(), is ("Delete Car?"));
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

    }

    @Entao("sistema exclui o carro do sistema")
    public void sistemaExcluiOCarroDoSistema() {
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.ContagemDeCarrosSistema();



    }

    @E("clico em Add Car")
    public void clicoEmAddCar() throws InterruptedException{
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.ClicarBotaoAddCar();
        Thread.sleep(3000);
    }

    @Quando("clico em Population From")
    public void clicoEmPopulationFrom() throws InterruptedException{
    ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
    campoByTeste1.ClicarNoBotaoPopulationFrom();
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
    public void sistemaNaoIncluiUmModeloNovoENaoMostraMensagemCarCreated() {
        ConstantesCampoBy campoByTeste1 = new ConstantesCampoBy(driver);
        campoByTeste1.AcharBotaoCarCreatedNaTela();
            System.out.println("Teste falhou");
        }
    }












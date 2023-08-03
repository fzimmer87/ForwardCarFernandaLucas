import Constantes.ConstanteChromeDriver;
import Constantes.ConstantesFordWardCar;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.hamcrest.core.Is.is;


public class StepsForwardCar {
    private WebDriver driver;

    @Dado("que estou na página da Forward Car")
    public void queEstouNaPaginaDaForwardCar() throws InterruptedException {

        System.out.println(ConstanteChromeDriver.CONST_CHROME_DRIVER);
        System.out.println(ConstanteChromeDriver.CONST_CAMINHO_CHROME_DRIVER);
        driver = new ChromeDriver();
        Thread.sleep(700);
        driver.get(ConstantesFordWardCar.URL_PAGINA_INICIAL);
    }

    @Quando("clico em search")
    public void clicoEmSearch() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[2]/a")).click();
        Thread.sleep(700);

    }

    @E("digito {string}")
    public void digito(String Acura)throws InterruptedException  {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/label/input")).sendKeys("acura");
        Thread.sleep(700);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[3]/div/div[1]"));
        Thread.sleep(700);
    }

    @Entao("aparecem modelos de carro acura")
    public void aparecemModelosDeCarroAcura() throws InterruptedException{
        List<WebElement> CarrosdaLista = driver.findElements(By.className("panel-heading"));
        Thread.sleep(700);
        String nomeDoCarro = "Acura";//variavel
        Thread.sleep(700);
        Boolean resultadoContemNomeCarro = true; //variavel2
        Thread.sleep(700);
        for (WebElement carros : CarrosdaLista) {
            String nomeDaBusca = carros.getText(); //variavel3
            if (!nomeDaBusca.contains(nomeDoCarro)) {
                resultadoContemNomeCarro = false;
            }
        }
        System.out.println(resultadoContemNomeCarro);
    }


    @E("digito RED,BLUE,GREEN,BLACK,SILVER")
    public void digitoREDBLUEGREENBLACKSILVER(DataTable dataTable) throws InterruptedException {
        List<String> coresDigitadas = dataTable.asList(String.class);
       Thread.sleep(3000);

        for (String novaCor: coresDigitadas) {
            String corAtual = novaCor;
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/label/input")).sendKeys(corAtual);
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/button")).click();
            Thread.sleep(3000);
            driver.findElements(By.className("panel-heading"));

        }
    }
    @Entao("aparecem modelos de carro da cor digitada")
    public void aparecemModelosDeCarroDaCorDigitada() {

    }
    @E("clico no cadeado")
    public void clicoNoCadeado() throws InterruptedException {
        driver.findElement(By.cssSelector("#admin")).click();
        Thread.sleep(700);
    }


    @Entao("cadeado não abre sem pedir login e senha como admin")
    public void cadeadoNaoAbreSemPedirLoginESenhaComoAdmin() {
        Boolean abrirTelaDeAcesso = true;
        if (abrirTelaDeAcesso.equals(driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(2) div.row.ng-scope div.ng-scope div.container div.row div.col-sm-3 div.list-group:nth-child(2) div.list-group-item.ng-binding > button.center-block.btn.btn-primary.btn-block.btn-sm:nth-child(2)"))));



    }

    @E("clico em delete")
    public void clicoEmDelete() {
        driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(2) div.row.ng-scope div.ng-scope div.container div.row div.col-sm-9 div.col-sm-4.ng-scope:nth-child(1) div.panel.panel-primary.text-center div.panel-footer > button.center-block.btn.btn-primary.btn-block.btn-xs:nth-child(3)")).click();
    }

    @Quando("clico em ok")
    public void clicoEmOk() {
        Assert.assertThat(driver.switchTo().alert().getText(), is ("Delete Car?"));
        driver.switchTo().alert().accept();
    }

    @Entao("sistema exclui o carro do sistema")
    public void sistemaExcluiOCarroDoSistema() {
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector(".ng-isolate-scope")).click();
    }

    @E("clico em Add Car")
    public void clicoEmAddCar() {
        driver.findElement(By.cssSelector("body.ng-scope.modal-open:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(1) div.navbar.navbar-cars.ng-scope div.container-fluid > div.navbar-collapse.collapse")).click();
    }

    @Quando("clico em Population From")
    public void clicoEmPopulationFrom() {
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/button")).click();
    }

    @E("modifico o campo preco para {string}")
    public void modificoOCampoPrecoPara(String arg0) {
        driver.findElement(By.cssSelector("#price")).sendKeys("0");
    }
    @E("clico em Create")
    public void clicoEmCreate() {
        driver.findElement(By.cssSelector("body.ng-scope.modal-open:nth-child(2) div.modal.fade.ng-isolate-scope.in:nth-child(4) div.modal-dialog div.modal-content div.modal-content.ng-scope div.modal-content:nth-child(2) div.modal-header form.form-horizontal.ng-valid.ng-valid-required.ng-dirty.ng-valid-parse:nth-child(4) div.modal-footer:nth-child(17) div:nth-child(1) > button.btn.btn-primary:nth-child(2)")).click();
    }

    @Entao("sistema nao inclui um modelo novo")
    public void sistemaNaoIncluiUmModeloNovo() {
        driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(2) div.row.ng-scope div.ng-scope div.container div.row div.col-sm-9 div.col-sm-4.ng-scope:nth-child(1) div.panel.panel-primary.text-center div.panel-body.text-center > p.ng-binding:nth-child(3)"));
        //se for igual a 0 entao dar teste falhou
    }




}











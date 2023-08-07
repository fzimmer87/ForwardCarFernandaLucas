package PageObjects;

import Constantes.ConstantesDeTexto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstantesCampoBy {
    private WebDriver driver;
    private By CampoSearch = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[2]/a");
    private By BotaoSearch =  By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/label/input");
    private By CampoDeRetornodosCarros= By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[3]/div/div[1]");
    private By CampoCorViewsDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[5]/td[2]");
    private By BotaoClear = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/button");
    private By BotaoViewsDetails = By.cssSelector("body.ng-scope.modal-open:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(2) div.row.ng-scope div.ng-scope div.container div.row div.col-sm-9 div.col-sm-4.ng-scope:nth-child(2) div.panel.panel-primary.text-center div.panel-footer > button.center-block.btn.btn-primary.btn-block.btn-xs:nth-child(1)");
    private By BotaoDelete = By.cssSelector("body.ng-scope:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(2) div.row.ng-scope div.ng-scope div.container div.row div.col-sm-9 div.col-sm-4.ng-scope:nth-child(1) div.panel.panel-primary.text-center div.panel-footer > button.center-block.btn.btn-primary.btn-block.btn-xs:nth-child(3)");
    private By BotaoAddCar = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/button");
    private By BotaoPopulationFrom = By.xpath("/html/body/div[4]/div/div/div/div[2]/div/button");
    private By BotaoCreate = By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/div[17]/div/button[2]");
    private By MensagemCarCreated = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div[1]/div/span");
    private By NumerodeCarrosInvenctory = By.xpath("By.xpath(\"/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/text()");
    private By BotaoPrice = By.cssSelector("#price");

    public ConstantesCampoBy(WebDriver driver){
        this.driver=driver;
    }

    public void resultadoCor(){
        this.driver.findElement(CampoCorViewsDetails);
    }
    public void PesquisarNoCamposSearch() {
        this.driver.findElement(CampoSearch).click();
    }
    public void DigitarNoCampoSearch(){
        this.driver.findElement(BotaoSearch).sendKeys(ConstantesDeTexto.CARAC_PARA_ENVIAR_NOME_DO_CARRO);
    }

    public void ClicarBotaoClear(){
        this.driver.findElement(BotaoClear).click();
    }

    public void ClicarBotaoDelete(){
        this.driver.findElement(BotaoDelete).click();
    }
    public void ClicarBotaoAddCar(){
        this.driver.findElement(BotaoAddCar).click();
    }
    public void ClicarNoBotaoPopulationFrom(){
        this.driver.findElement(BotaoPopulationFrom).click();
    }
    public void ClicarBotaoCreate(){
        this.driver.findElement(BotaoCreate).click();
    }
    public void AcharBotaoCarCreatedNaTela(){
        this.driver.findElement(MensagemCarCreated).isDisplayed();
    }
    public void ContagemDeCarrosSistema(){
        this.driver.findElement(NumerodeCarrosInvenctory).isDisplayed();
    }
    public void LimparCampoPrice(){
        this.driver.findElement(BotaoPrice).clear();
    }
    public void DeixarCampoPriceZerado(){
        this.driver.findElement(BotaoPrice).sendKeys("0");
    }

}
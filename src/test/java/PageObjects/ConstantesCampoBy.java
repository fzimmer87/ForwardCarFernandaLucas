package PageObjects;

import Constantes.ConstantesDeTexto;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstantesCampoBy {
    private WebDriver driver;
    private By CampoSearch = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[2]/a");
    private By BotaoSearch = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/label/input");
    private By CampoDeRetornodosCarros = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[3]/div/div[1]");
    private By CampoCorViewsDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[5]/td[2]");
    private By BotaoViewsDetails = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[1]/div/div[3]/button[1]");
    private By BotaoClear = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/button");
    private By BotaoDelete = By.cssSelector("body.ng-scope:nth-child(2) div.container.site:nth-child(1) div.ng-scope:nth-child(2) div.row.ng-scope div.ng-scope div.container div.row div.col-sm-9 div.col-sm-4.ng-scope:nth-child(1) div.panel.panel-primary.text-center div.panel-footer > button.center-block.btn.btn-primary.btn-block.btn-xs:nth-child(3)");
    private By BotaoAddCar = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/button");
    private By BotaoPopulationFrom = By.xpath("/html/body/div[4]/div/div/div/div[2]/div/button");
    private By BotaoCreate = By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/div[17]/div/button[2]");
    private By MensagemCarCreated = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div[1]/div/span");
    private By NumerodeCarrosInvenctory = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/text()");
    private By BotaoPrice = By.cssSelector("#price");
    private By TelacomNomedeTodosCarros = By.className("panel-heading");
    private By TelaAdmin = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div");
    private By BotaoOkViewsDetaisls = By.xpath("/html/body/div[4]/div/div/div/div[3]/button[3]");
    private By BotaoCadeado = By.cssSelector("#admin");
    private By MensagemCarDeleted = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div[1]/div/span");
    private By BotaoCampoSearch = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/label/input");
    private By BotaoGuest = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/a/span[1]");
    private By BotaoMake = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[3]/a[2]");
    private By BotaoModelRLXAWD= By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[4]/a[3]");
    private By BotaoLogin= By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[1]/a");
    private By CampoUsarnameLogin = By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/input");
    private By CampoPassowordLogin = By.xpath("//*[@id=\"login-form\"]/fieldset/div[2]/input");
    private By BotaoSignInPagLogin = By.xpath("//*[@id=\"login-form\"]/fieldset/div[3]/button");
    private By BotaoGuestComMeunome = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/a/span[1]");
    private By BotaoLoanStatus = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[3]/a");
    private By BotaoRegister= By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[2]/a");


    public ConstantesCampoBy(WebDriver driver) {
        this.driver = driver;
    }

    public void resultadoCor() {
        Assert.assertEquals(driver.findElement (CampoCorViewsDetails).getText(),driver.findElement (BotaoCampoSearch).getText());
    }

    public void PesquisarNoCamposSearch() {
        this.driver.findElement(CampoSearch).click();
    }

    public void DigitarNoCampoSearch() {
        this.driver.findElement(BotaoSearch).sendKeys(ConstantesDeTexto.CARAC_PARA_ENVIAR_NOME_DO_CARRO);
    }

    public void ClicarBotaoClear() {
        this.driver.findElement(BotaoClear).click();
    }

    public void ClicarBotaoDelete() {
        this.driver.findElement(BotaoDelete).click();
    }

    public boolean ClicarBotaoAddCar() {
        this.driver.findElement(BotaoAddCar).click();
        return false;
    }

    public void ClicarNoBotaoPopulationFrom() {
        this.driver.findElement(BotaoPopulationFrom).click();
    }

    public void ClicarBotaoCreate() {
        this.driver.findElement(BotaoCreate).click();
    }

    public boolean AcharBotaoCarCreatedNaTela() {
        return this.driver.findElement(MensagemCarCreated).isDisplayed();
    }

    public void LimparCampoPrice() {
        this.driver.findElement(BotaoPrice).clear();
    }

    public void DeixarCampoPriceZerado() {
        this.driver.findElement(BotaoPrice).sendKeys("0");
    }

    public boolean TelaNomedosCarros() {
        return this.driver.findElement(TelacomNomedeTodosCarros).isDisplayed();
    }

    public boolean TelaAdminIsDisplayed() {
        return this.driver.findElement(TelaAdmin).isDisplayed();
    }
    public void ClicarBotaoViewsDetaisls(){
        driver.findElement(BotaoViewsDetails).click();
        driver.findElement(BotaoOkViewsDetaisls).click();
    }
    public void ClicarBotaoOkCampoViewsDetails(){
        driver.findElement(BotaoOkViewsDetaisls).click();
    }
    public void ClicarBotaoCadeado(){
        driver.findElement(BotaoCadeado).click();
    }
    public boolean AcharMensagemCarDeletedNaTela(){
        return this.driver.findElement(MensagemCarDeleted).isDisplayed();
    }
    public void DigitarCorEncontradanaTabela( String corAtual){
        WebElement coratual = driver.findElement(BotaoCampoSearch);
        coratual.clear();
        coratual.sendKeys(corAtual);
    }
    public void ClicarNoBotaoGuest(){
        this.driver.findElement(BotaoGuest).click();
    }
    public void ClicarNoBortaoAcura(){
        this.driver.findElement(BotaoMake).click();
    }
    public void ClicarNoBotaoModelRLXAWD(){
        this.driver.findElement(BotaoModelRLXAWD).click();
    }
    public void ClicarNoCampoSearch(){
        this.driver.findElement(BotaoCampoSearch).click();
    }
    public void ClicarBotaoLogin(){
        this.driver.findElement(BotaoLogin).click();
    }
    public void RealizarLoginComUsarnameSenha(){
        this.driver.findElement(CampoUsarnameLogin).sendKeys("zimmerf");
        this.driver.findElement(CampoPassowordLogin).sendKeys("852456");
        this.driver.findElement(BotaoSignInPagLogin).click();
    }
    public void ClicarNoCampoGuestLogado(){
        this.driver.findElement(BotaoGuestComMeunome).click();
    }
    public void ClicarNoBotaoLoanStatus(){
        this.driver.findElement(BotaoLoanStatus).click();
    }
    public void ClicarBotaoRegister(){
        this.driver.findElement(BotaoRegister).click();
    }


}








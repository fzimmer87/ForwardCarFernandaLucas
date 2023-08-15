package PageObjects;

import Constantes.ConstantesDeTexto;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ConstantesCampoBy {
    private WebDriver driver;

    private By CampoSearch = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[2]/a");
    private By BotaoSearch = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]/label/input");
    private By CampoDeRetornodosCarros = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[3]/div/div[1]");
    private By CampoCorViewsDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[5]/td[2]");
    private By BotaoViewsDetails = By.xpath("//button[contains(@ng-click,'loadCarDetails(car.vin);')]");
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
    private By BotaoModelRLXAWD = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[4]/a[3]");
    private By BotaoLogin = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[1]/a");
    private By CampoUsarnameLogin = By.xpath("//*[@id='login-form']/fieldset/div[1]/input");
    private By CampoPassowordLogin = By.xpath("//*[@id='login-form']/fieldset/div[2]/input");
    private By BotaoSignInPagLogin = By.xpath("//*[@id='login-form']/fieldset/div[3]/button");
    private By BotaoGuestComMeunome = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/a/span[1]");
    private By BotaoLoanStatus = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[3]/a");
    private By BotaoRegister = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/ul/li[2]/a");
    private By Campoprice = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[1]/div/div[1]");
    private By CampoFirstName = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[1]/input");
    private By CampoLastName = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[2]/input");
    private By CampoUsarname = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[3]/input");
    private By CampoPassword = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[4]/input");
    private By BotaoRegisterLogin = By.xpath("//*[@id=\"registration-form\"]/fieldset/div[5]/button");
    private By CampoResultadoBusca = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]");
    private By CampoYearTelaPesquisa = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[1]/div/div[2]/p[1]");
    private By CampoCartaoCarro = By.xpath("//div[contains(@class, 'panel panel-primary text-center')]");


    public ConstantesCampoBy(WebDriver driver) {
        this.driver = driver;
    }



    public boolean AcharElementoPainel() {
        this.driver.findElement(Campoprice);
        List<WebElement> CarrosdaLista = driver.findElements(By.className("panel-heading"));
        String nomeDoCarro = "Acura";
        Boolean resultadoContemNomeCarro = true;
        for (WebElement carros : CarrosdaLista) {
            String nomeDaBusca = carros.getText();
            if (!nomeDaBusca.contains(nomeDoCarro)) {
                resultadoContemNomeCarro = false;
            }
        }
        return resultadoContemNomeCarro;
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


    public boolean TelaAdminIsDisplayed() {
        return this.driver.findElement(TelaAdmin).isDisplayed();
    }

    public void ClicarBotaoCadeado() {
        driver.findElement(BotaoCadeado).click();
    }

    public boolean AcharMensagemCarDeletedNaTela() {
        return this.driver.findElement(MensagemCarDeleted).isDisplayed();
    }

    public void DigitarCorEncontradanaTabela(String corAtual) {
        WebElement coratual = driver.findElement(BotaoCampoSearch);
        coratual.clear();
        coratual.sendKeys(corAtual);
    }
    public void ClicarBotaoViewsDetaisls(String corDigitada)throws InterruptedException {
        List<WebElement>campoViewDetaisls = driver.findElements(CampoCartaoCarro);
        for (WebElement acharCores : campoViewDetaisls){
            driver.findElement(BotaoViewsDetails).click();
            Thread.sleep(3000);
            String texto = driver.findElement(CampoCorViewsDetails).getText();
            Thread.sleep(3000);
            if (texto.equals(corDigitada) ) {
                Thread.sleep(3000);
                clicarBotaoOkViewsDetails();
                System.out.println("true");
            }
        }
        System.out.println("false");
    }
    public void clicarBotaoOkViewsDetails(){
        this.driver.findElement(BotaoOkViewsDetaisls).click();
    }

    public void ClicarNoBotaoGuest() {
        this.driver.findElement(BotaoGuest).click();
    }

    public void ClicarNoBortaoAcura() {
        this.driver.findElement(BotaoMake).click();
    }

    public void ClicarNoBotaoModelRLXAWD() {
        this.driver.findElement(BotaoModelRLXAWD).click();
    }

    public void ClicarNoCampoSearch() {
        this.driver.findElement(BotaoCampoSearch).click();
    }

    public void ClicarBotaoLogin() {
        this.driver.findElement(BotaoLogin).click();
    }

    public void RealizarLoginComUsarnameSenha() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.findElement(CampoUsarnameLogin).click();
        Thread.sleep(5000);
        this.driver.findElement(CampoUsarnameLogin).sendKeys("zimmerf");
        Thread.sleep(5000);
        this.driver.findElement(CampoPassowordLogin).click();
        Thread.sleep(5000);
        this.driver.findElement(CampoPassowordLogin).sendKeys("852456");
        Thread.sleep(5000);
        this.driver.findElement(BotaoSignInPagLogin).click();
    }

    public void ClicarNoCampoGuestLogado() {
        this.driver.findElement(BotaoGuestComMeunome).click();
    }

    public void ClicarNoBotaoLoanStatus() {
        this.driver.findElement(BotaoLoanStatus).click();
    }

    public void ClicarBotaoRegister() {
        this.driver.findElement(BotaoRegister).click();
    }

    public void preencherFirstName(String firstName) {
        this.driver.findElement(CampoFirstName).sendKeys(firstName);
    }
    public void preencherLastName(String lastName) {
        this.driver.findElement(CampoLastName).sendKeys(lastName);
    }
    public void preencherUsarname(String username) {
        this.driver.findElement(CampoUsarname).sendKeys(username);
    }

    public void preencherPassword(String password) {
        this.driver.findElement(CampoPassword).sendKeys(password);
    }
    public void clicarBotaoRegister(){
        this.driver.findElement(BotaoRegisterLogin).click();
    }
    public void validarCampoMakeAcuraRLXAWD(){
        String acharTextoNaTela = driver.findElement(CampoResultadoBusca).getText();
        Assert.assertEquals(acharTextoNaTela, "Acura RLX-AWD");
    }
    public void digitarAnoDosCarros(String anoDigitado) {
        WebElement anodigitado = driver.findElement(BotaoCampoSearch);
        anodigitado.clear();
        anodigitado.sendKeys(anoDigitado);

    }
    public boolean pegarTextoDoCampoYear(String anoCarro){
        String texto = this.driver.findElement(CampoYearTelaPesquisa).getText();
        if (texto.contains(anoCarro)){
            return true;
        }
        return false;
    }
}









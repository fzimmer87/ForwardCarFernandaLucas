import Constantes.ConstantesFordWardCar;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.bytebuddy.matcher.ElementMatchers.is;


public class StepsForwardCar {

    private WebDriver driver;

    @Dado("que estou na página da Forward Car")
    public void queEstouNaPaginaDaForwardCar() {
        driver.get(ConstantesFordWardCar.URL_INVENTORY);
    }
    @Quando("clico em search")
    public void clicoEmSearch() {
        driver.findElement(By.linkText("Guest")).click();
        driver.findElement(By.cssSelector(".form-control")).click();

    }
    @E("digito Acura")
    public void digitoAcura() {
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("acura");
        driver.findElement(By.cssSelector(".btn-positive")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("bmw");
        driver.findElement(By.cssSelector(".btn-positive")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("audi");
    }
    @Entao("aparecem modelos de carro acura")
    public void aparecemModelosDeCarroAcura() {
    }
    @E("digito RED,BLUE,GREEN,BLACK,SILVER")
    public void digitoREDBLUEGREENBLACKSILVER() {
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("blue");
        driver.findElement(By.cssSelector(".btn-positive")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("green");
        driver.findElement(By.cssSelector(".btn-positive")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("red");
        driver.findElement(By.cssSelector(".btn-positive")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("silver");
        driver.findElement(By.cssSelector(".btn-positive")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("black");
        driver.findElement(By.cssSelector(".btn-positive")).click();

    }
    @Entao("aparecem modelos de carro da cor digitada")
    public void aparecemModelosDeCarroDaCorDigitada() {
    }

    @E("clico no cadeado")
    public void clicoNoCadeado() {
        driver.findElement(By.id("//*[@id='admin']")).click();
        
    }

    @Entao("sistema pede login e senha como admin")
    public void sistemaPedeLoginESenhaComoAdmin() {
    }

    @E("clico em delete")
    public void clicoEmDelete() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[1]/div/div[3]/button[3]")).click();
        driver.findElement(By.id("admin")).click();

    }

    @Quando("clico em ok")
    public void clicoEmOk() {
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(1) .center-block:nth-child(3)")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), is("Delete Car?"));

        
    }

    @Entao("sistema exclui o carro do sistema")
    public void sistemaExcluiOCarroDoSistema() {
        driver.switchTo().alert().accept();
    }

    @E("clico em Add Car")
    public void clicoEmAddCar() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/button")).click();
    }

    @Quando("clico em Population From")
    public void clicoEmPopulationFrom() {
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/button")).click();
    }
    @E("modifico o campo preco")
    public void modificoOCampoPreco() {
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/button")).sendKeys("20500");

    }
    @Entao("sistema nao inclui um modelo novo")
    public void sistemaNaoIncluiUmModeloNovo() {
    }



}

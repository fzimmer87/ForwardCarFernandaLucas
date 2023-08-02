import Constantes.ConstanteChromeDriver;
import Constantes.ConstantesFordWardCar;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;




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
        String nomeDoCarro = "Acura";
        Thread.sleep(700);
        Boolean resultadoContemNomeCarro = true;
        Thread.sleep(700);
        for (WebElement carros : CarrosdaLista) {
            String nomeDaBusca = carros.getText();
            if (!nomeDaBusca.contains(nomeDoCarro)) {
                resultadoContemNomeCarro = false;
            }
        }
        System.out.println(resultadoContemNomeCarro);
    }


}

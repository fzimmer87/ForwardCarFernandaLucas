package PageObject;

import constantes.ConstantesUrls;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommomSteps {
    private ChromeDriver driver;
    public CommomSteps(ChromeDriver driver) {
        this.driver = driver;
    }
    public void queOUsuarioEstaAutenticadoNaPaginaLoanApplication() throws InterruptedException{
        driver.get(ConstantesUrls.URL_PAGINA_LOAN_APPLICATION);
        Thread.sleep(10000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValido();
    }
}

package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutenticacaoPage {
    private WebDriver Driver;
    private By bodyHomePage = By.xpath("/html/body");
    private By userAutenticacao = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[5]/a/span[1]");

    public AutenticacaoPage(WebDriver Driver) {
        this.Driver = Driver;
    }
    public boolean isNaPaginaPrincipal() {
        return this.Driver.findElement(bodyHomePage).isDisplayed();
    }
    public boolean isLogado() {
        String verificaoAutenticacao = this.Driver.findElement(userAutenticacao).getText();
        return verificaoAutenticacao.contains("lucas gomes morais");
    }
}

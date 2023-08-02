package PageObject;

import constantes.ConstantesUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver Driver;
    private By inputUsername = By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/input");
    private By inputPassword = By.xpath("//*[@id=\"login-form\"]/fieldset/div[2]/input");
    //Trocar Button por btn quando finalizar (clean code)
    private By loginButton = By.xpath("//*[@id=\"login-form\"]/fieldset/div[3]/button");
    private By autheticationErrorMessage = By.xpath("//*[@id=\"login-form\"]/div");
    public LoginPage(WebDriver Driver) {
        this.Driver = Driver;
    }
    public void enviarCaracteresParaCampoInput(String username, String password) {
        this.Driver.findElement(inputUsername).sendKeys(username);
        this.Driver.findElement(inputPassword).sendKeys(password);
    }
    public void enviarInfosLogin() {
        this.Driver.findElement(loginButton).click();
    }
    public String isOnHomePage() {
        return this.Driver.getCurrentUrl();
    }
    public String isOnLoginPage() {
        return this.Driver.getCurrentUrl();
    }

    public void apagarCredenciasInseridas() {
        this.Driver.findElement(inputUsername).clear();
        this.Driver.findElement(inputPassword).clear();
    }
    public void isAuthenticationErrorMessageDisponivel() {
        this.Driver.findElement(autheticationErrorMessage).isDisplayed();
    }
    public void loginValido() {
        this.Driver.findElement(inputUsername).sendKeys("l.morais");
        this.Driver.findElement(inputPassword).sendKeys("morais");
        this.Driver.findElement(loginButton).click();
    }
}

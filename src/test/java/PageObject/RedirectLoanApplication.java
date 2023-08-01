package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectLoanApplication {
    private WebDriver Driver;
    private By linkLoanApplication = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[4]/a");

    public RedirectLoanApplication(WebDriver Driver) {
        this.Driver = Driver;
    }

    public void clicarBotaoLoanApplication(){
        this.Driver.findElement(linkLoanApplication).click();
    }

}

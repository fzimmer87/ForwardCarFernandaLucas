package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectVinLookup {
    private WebDriver Driver;
    private By btnVinLookup = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[3]/a");

    public RedirectVinLookup(WebDriver Driver){
        this.Driver = Driver;
    }

    public void clickButtonVinLookup() {
        this.Driver.findElement(btnVinLookup).click();
    }

    public String getUrlAtual() {
        return this.Driver.getCurrentUrl();
    }
}

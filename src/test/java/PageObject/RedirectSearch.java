package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectSearch {
    private WebDriver Driver;
    private By pageSearch = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[2]/a");

    public RedirectSearch(WebDriver Driver) {
        this.Driver = Driver;
    }

    public void clickButtonSearch() {
        this.Driver.findElement(pageSearch).click();
    }

    public String getUrlAtual() {
        return Driver.getCurrentUrl();
    }
}

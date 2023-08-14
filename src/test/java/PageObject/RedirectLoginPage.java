package PageObject;

import io.netty.buffer.ByteBufAllocatorMetricProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectLoginPage {
    private WebDriver Driver;
    private By containerLogin = By.xpath("/html/body/div[1]/div[2]/div/div/div/div");
    public RedirectLoginPage(WebDriver Driver){
        this.Driver = Driver;
    }
    public boolean isContainerLoginDisponivel() {
        return this.Driver.findElement(containerLogin).isDisplayed();
    }
}

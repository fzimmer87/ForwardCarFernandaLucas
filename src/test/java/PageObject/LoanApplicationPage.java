package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanApplicationPage {
    private WebDriver Driver;
    private By inputFirstName = By.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/div[1]/div[1]/input");
    private By inputLastName = By.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/div[1]/div[2]/input");
    private By inputAddresLine1 = By.xpath("//*[@id=\"address-line1\"]");
    private By inputCityTown = By.xpath("//*[@id=\"city\"]");
    private By inputStateProvidenceRegion = By.xpath("//*[@id=\"state\"]");
    private By inputZipPostalCode = By.xpath("//*[@id=\"postal-code\"]");
    private By inputDateOfBirth = By.xpath("//*[@id=\"dob\"]");
    private By inputSSN = By.xpath("//*[@id=\"ssn\"]");
    private By inputEmployer = By.xpath("//*[@id=\"employer\"]");
    private By inputPhone = By.xpath("//*[@id=\"phone\"]");
    private By inputLengthTimeAtAJob = By.xpath("//*[@id=\"ltJob\"]");
    private By inputYearlyIncome = By.xpath("//*[@id=\"yIncome\"]");
    private By inputLoanAmount = By.xpath("//*[@id=\"lAmount\"]");
    public LoanApplicationPage(WebDriver Driver) {
        this.Driver = Driver;
    }
    //Estudar Abstração de PageObjects e aplicar nessa parte do projeto que possui duplicação de código
    public void enviarCaracteresParaCampoInput(String valor) {
        this.Driver.findElement()
        this.Driver.findElement(inputFirstName).sendKeys(valor);
    }
}

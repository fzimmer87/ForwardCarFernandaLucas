package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    private By btnApply = By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/button[1]");
    private By modalTitle = By.xpath("/html/body/div[4]/div/div");
    public LoanApplicationPage(WebDriver Driver) {
        this.Driver = Driver;
    }

    //Coloqui WebElement aqui pq foi sugestão da IDE, mas não entendi o real motivo de precisar definir o tipo dessa função com WebDriver
    public void enviarCaracteresCampoInputSwithCase(String campo, String valor, boolean checkTeste, Boolean isAceito) {
        switch (campo) {
            case "First Name":
                this.Driver.findElement(inputFirstName).clear();
                this.Driver.findElement(inputFirstName).sendKeys(valor);
                break;
            case "Last Name":
                if (checkTeste) {
                    if (!isAceito) {
                        System.out.println("O campo Last Name não deveria estar preenchido com esse valor");
                        break;
                    }
                }
                this.Driver.findElement(inputLastName).clear();
                this.Driver.findElement(inputLastName).sendKeys(valor);
                break;
            case "Adress Line 1":
                this.Driver.findElement(inputAddresLine1).clear();
                this.Driver.findElement(inputAddresLine1).sendKeys(valor);
                break;
            case "City / Town":
                if (checkTeste) {
                    if (!isAceito) {
                        System.out.println("O campo City / Town não deveria estar preenchido com esse valor");
                        break;
                    }
                }
                this.Driver.findElement(inputCityTown).clear();
                this.Driver.findElement(inputCityTown).sendKeys(valor);
                break;
            case "State/Providence/Region":
                this.Driver.findElement(inputStateProvidenceRegion).clear();
                this.Driver.findElement(inputStateProvidenceRegion).sendKeys(valor);
                break;
            case "Zip / Postal Code":
                this.Driver.findElement(inputZipPostalCode).clear();
                this.Driver.findElement(inputZipPostalCode).sendKeys(valor);
                break;
            case "Date of Birth":
                if (checkTeste) {
                    if (!isAceito) {
                        System.out.println("O campo Date of Birth não deveria estar preenchido com esse valor");
                        break;
                    }
                }
                this.Driver.findElement(inputDateOfBirth).clear();
                this.Driver.findElement(inputDateOfBirth).sendKeys(valor);
                break;
            case "SSN#":
                if (checkTeste) {
                    if (!isAceito) {
                        System.out.println("O campo SSN# não deveria estar preenchido com esse valor");
                        break;
                    }
                }
                this.Driver.findElement(inputSSN).clear();
                this.Driver.findElement(inputSSN).sendKeys(valor);
                break;
            case "Employer":
                this.Driver.findElement(inputEmployer).clear();
                this.Driver.findElement(inputEmployer).sendKeys(valor);
                break;
            case "Phone":
                this.Driver.findElement(inputPhone).clear();
                this.Driver.findElement(inputPhone).sendKeys(valor);
                break;
            case "Length time at a Job":
                this.Driver.findElement(inputLengthTimeAtAJob).clear();
                this.Driver.findElement(inputLengthTimeAtAJob).sendKeys(valor);
                break;
            case "Yearly Income":
                if (checkTeste) {
                    if (!isAceito) {
                        System.out.println("O campo Yearly Income não deveria estar preenchido com esse valor");
                        break;
                    }
                }
                this.Driver.findElement(inputYearlyIncome).clear();
                this.Driver.findElement(inputYearlyIncome).sendKeys(valor);
                break;
            case "Loan Amount":
                this.Driver.findElement(inputLoanAmount).clear();
                this.Driver.findElement(inputLoanAmount).sendKeys(valor);
                break;
        }
    }

    public void tornarCamposVazios(String campo, String valor) {
        switch (campo) {
            case ("First Name"):
                this.Driver.findElement(inputFirstName).clear();
                break;
            case ("Last Name"):
                this.Driver.findElement(inputLastName).clear();
                break;
            case ("Adress Line 1"):
                this.Driver.findElement(inputAddresLine1).clear();
                break;
            case ("City / Town"):
                this.Driver.findElement(inputCityTown).clear();
                break;
            case ("State/Providence/Region"):
                this.Driver.findElement(inputStateProvidenceRegion).clear();
                break;
            case ("Zip / Postal Code"):
                this.Driver.findElement(inputZipPostalCode).clear();
                break;
            case ("Date of Birth"):
                this.Driver.findElement(inputDateOfBirth).clear();
                break;
            case ("SSN#"):
                this.Driver.findElement(inputSSN).clear();
                break;
            case ("Employer"):
                this.Driver.findElement(inputEmployer).clear();
                break;
            case ("Phone"):
                this.Driver.findElement(inputPhone).clear();
                break;
            case ("Length time at a Job"):
                this.Driver.findElement(inputLengthTimeAtAJob).clear();
                break;
            case ("Yearly Income"):
                this.Driver.findElement(inputYearlyIncome).clear();
                break;
            case ("Loan Amount"):
                this.Driver.findElement(inputLoanAmount).clear();
                break;
        }
    }
    public void clicarBotaoApply() {
        this.Driver.findElement(btnApply).click();
    }
    public boolean ismodalTitleDisplayed(){
        return this.Driver.findElement(modalTitle).isDisplayed();
    }
}

    //Estudar Abstração de PageObjects e aplicar nessa parte do projeto que possui duplicação de código


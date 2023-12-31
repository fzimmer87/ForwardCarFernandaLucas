package PageObject;

import Constantes.ConstantesUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver Driver;
    private By carsList = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]");
    private By inputCampoVin = By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/form/input[1]");
    private By btnLookUp = By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/form/input[2]");
    private By tableReportRunDate = By.xpath("/html/body/div[1]/div[2]/div/div/div[3]");
    private By cadeadoAdminSearch = By.xpath("//*[@id=\"admin\"]");
    private By cellsTable = By.tagName("td");
    private By btnDelete = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[1]/div/div[3]/button[3]");
    private By btnViewDetails = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[1]/div/div[3]/button[1]");
    //Comparacao com o valor de Odometer em Report Run Date
    private By campoMileageViewDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[2]");
    private By campoOwnersViewDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[3]");
    private By campoModelYearViewDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[4]");
    //Utilizar o split para dividir em make e model e fazer a comparação com os dados de ReportRunDate
    private By nameCarViewDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div");
    private By engineViewDetails = By.xpath("/html/body/div[4]/div/div/div/div[2]/table/tbody/tr[7]");
    //Comparacao com valor do VIN no campo Report Run Date
    private By textBtnVinViewDetails = By.xpath("/html/body/div[4]/div/div/div/div[3]/button[1]/i/text()");
    private By qntdCarros = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/text()");
    private By vinVinLookup = By.xpath("//*[@id=\"vin-summary-left\"]/tbody/tr[1]/td[2]");
    private By yearVinLookup = By.xpath("//*[@id=\"vin-summary-left\"]/tbody/tr[2]/td[2]");
    private By makeVinLookup = By.xpath("//*[@id=\"vin-summary-left\"]/tbody/tr[3]/td[2]");
    private By modelVinLookup = By.xpath("//*[@id=\"vin-summary-left\"]/tbody/tr[4]/td[2]");
    private By engineVinLookup = By.xpath("//*[@id=\"vin-summary-left\"]/tbody/tr[6]/td[2]");
    private By ownersVinLookup = By.xpath("//*[@id=\"vin-summary-left\"]/tbody/tr[7]/td[2]");
    private By mileageVinLookup = By.xpath("//*[@id=\"vin-summary-left\"]/tbody/tr[8]/td[2]");

    public SearchPage (WebDriver Driver) {
        this.Driver = Driver;
    }

    public boolean isCarsListDisponivel() {
        boolean listaDisponivel = Driver.findElement(carsList).isDisplayed();
        return listaDisponivel;
    }

    public void enviarVinCampoInput(String VIN) {
        this.Driver.findElement(inputCampoVin).sendKeys(VIN);
    }

    public void clickBtnVinLookup() {
        this.Driver.findElement(btnLookUp).click();
    }

    public boolean isHistoricoCarroExibido() {
        return this.Driver.findElement(tableReportRunDate).isDisplayed();
    }

    public void getValoresViewDetails() {
        Driver.get(ConstantesUrls.URL_PAGINA_SEARCH);
        //Lista para iterar sobre todos os botões ViewDetails
        List<WebElement> caracteristicasCarrosViewDetails = Driver.findElements(btnViewDetails);
        //Lista para armazenar infos dos carros
        List<Carro> carros = new ArrayList<>();


        for (WebElement botaoViewDetails : caracteristicasCarrosViewDetails) {
            botaoViewDetails.click();

            String engine = (Driver.findElement(engineViewDetails).getText());
            String mileage = (Driver.findElement(campoMileageViewDetails).getText());
            String owners = (Driver.findElement(campoOwnersViewDetails).getText());
            String vin = (Driver.findElement(textBtnVinViewDetails).getText());
            String year = (Driver.findElement(campoModelYearViewDetails).getText());

            String nomeCarro = Driver.findElement(nameCarViewDetails).getText();
            String[] divisaoNomeCarro = nomeCarro.split(" ");

            String marca = (divisaoNomeCarro[0]); //Primeira parte do nome completo do carro eh a marca
            String modelo = (divisaoNomeCarro[1]); //Segunda parte vai ser o modelo do carro


            Carro carro = new Carro(modelo, vin, marca, year, engine, owners, mileage);
            //Nesse caso, vou ter que criar uma nova lista para armazenar esses valores, dado que a lista das caracteristicas do carro vai apenas armazenar todos os btns View Details para serem iterados
            //caracteristicasCarrosViewDetails.add();
            carros.add(carro);
            Driver.navigate().back();
        }
    }

    public void getValoresVinLookup() {
        List<String> caracteristicasCarros = new ArrayList<>();
        if (isHistoricoCarroExibido()) {
            List<WebElement> listaInfosDisponiveisVinLookup = Driver.findElements(tableReportRunDate);

            for (WebElement caracteristicas : listaInfosDisponiveisVinLookup) {
                String valor = caracteristicas.getText();
                caracteristicasCarros.add(valor);
            }
        } else {
            System.out.println(false);
        }
    }

    public void tornarAdmin() {
        this.Driver.findElement(cadeadoAdminSearch).click();
    }
    public void clickDelete() {
        this.Driver.findElement(btnDelete).click();
    }
    public void confirmarDelete() {
        this.Driver.switchTo().alert().accept();
    }
    public class Carro {
        private String modelo;
        private String vin;
        private String marca;
        private String year;
        private String engine;
        private String owners;
        private String mileage;

        public Carro(String modelo, String vin, String marca, String year, String engine, String owners, String mileage) {
            this.modelo = modelo;
            this.vin = vin;
            this.marca = marca;
            this.year = year;
            this.engine = engine;
            this.owners = owners;
            this.mileage = mileage;
        }

        public String getMileage() {
            return mileage;
        }

        public String getYear() {
            return year;
        }

        public String getEngine() {
            return engine;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public String getOwners() {
            return owners;
        }

        public String getVin() {
            return vin;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public void setOwners(String owners) {
            this.owners = owners;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public void setYear(String year) {
            this.year = year;
        }

    }

    public class CarroVinLookup extends Carro {
        public CarroVinLookup(String modelo, String vin, String marca, String year, String engine, String owners, String mileage) {
            super(modelo, vin, marca, year, engine, owners, mileage);
        }
    }
}

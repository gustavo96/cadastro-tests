package br.com.webmotors.pages;

import br.com.webmotors.step_definitions.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCarsPage {

    private WebDriver driver;

    private By btnCookie = By.xpath("//button[text()='OK']");
    // Modelo
    private By btnHonda = By.xpath("//a[@title='honda']");
    private By btnModelos = By.xpath("//div[text()='Todos os modelos']");
    private By inputModelos = By.xpath("//label[text()='Digite o modelo desejado']/../input");
    private By selecionaModelo(String modelo){
        return By.xpath("//a[text()='"+modelo+"']");
    }
    // Versoes
    private By btnVersoes = By.xpath("//div[text()='Todas as versões']");
    private By inputVersoes = By.xpath("//label[text()='Digite a versão desejada']/../input");
    private By selecionaVersao(String versao){
        return By.xpath("//a[text()='"+versao+"']");
    }

    public SearchCarsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acesarTelaPesquisa() {
        DriverFactory.driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp&TL=AM3QAYZbQQGlsoq493d2aSSV0Oe6XG2NJjGaaq4Jg0dqy_WIkzJFSPqzF62K_-_5");
        DriverFactory.driver.manage().window().maximize();
    }

    public void pesquisaCarro(String marca, String modelo, String versao) throws InterruptedException {
        driver.findElement(btnCookie).click();
        driver.findElement(btnHonda).click();
    //    driver.wait(1000);
        driver.findElement(btnModelos).click();
        driver.findElement(inputModelos).sendKeys(modelo);
        driver.findElement(selecionaModelo(modelo)).click();
    // Versao
        driver.findElement(btnVersoes).click();
        driver.findElement(inputVersoes).sendKeys(versao);
        driver.findElement(selecionaVersao(versao)).click();
    }

    public boolean validaCarros(String marca, String modelo, String versao) {
        marca = marca.toLowerCase();
        modelo = modelo.toLowerCase();
        versao = versao.toLowerCase();
//        DriverFactory.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String resultadoBusca = driver.findElement(By.xpath("//h1")).getText().toLowerCase();

        if (resultadoBusca.contains(marca)||resultadoBusca.contains(modelo)||
                resultadoBusca.contains(versao)) {
        return true;
        }else {
            return false;
        }

    }

    public void acesarTelaEstoqueLoja() {
        DriverFactory.driver.get("https://www.webmotors.com.br/carros/estoque/?IdRevendedor=3834764&TipoVeiculo=carros&anunciante=concession%C3%A1ria%7Cloja");
        DriverFactory.driver.manage().window().maximize();
    }
}

package br.com.webmotors.pages;

import br.com.webmotors.step_definitions.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage {

    private WebDriver driver;

    private By inputNome = By.xpath("//input[@id='firstName']");
    private By inputSobrenome = By.xpath("//input[@id='lastName']");
    private By inputUsuario = By.xpath("//input[@id='username']");
    private By inputSenha = By.xpath("//input[@name='Passwd']");
    private By inputConfSenha = By.xpath("//input[@name='ConfirmPasswd']");
    private By buttonProxima = By.xpath("//span[text()='Próxima']/..");

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acesarTelaCadastroEmail() {
        DriverFactory.driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp&TL=AM3QAYZbQQGlsoq493d2aSSV0Oe6XG2NJjGaaq4Jg0dqy_WIkzJFSPqzF62K_-_5");
        DriverFactory.driver.manage().window().maximize();
    }

    public void preencheCadastro(String nome, String sobrenome, String usuario, String senha) {
        driver.findElement(inputNome).sendKeys(nome);
        driver.findElement(inputSobrenome).sendKeys(sobrenome);
        driver.findElement(inputUsuario).sendKeys(usuario);
        driver.findElement(inputSenha).sendKeys(senha);
        driver.findElement(inputConfSenha).sendKeys(senha);
        driver.findElement(buttonProxima).click();
    }

    public Boolean validaCadastro() {
        return true;
    }
}

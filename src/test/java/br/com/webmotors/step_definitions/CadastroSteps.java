package br.com.webmotors.step_definitions;

import br.com.webmotors.pages.CadastroPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class CadastroSteps {

    private DriverFactory driverFactory = new DriverFactory();
    private CadastroPage cadastroPage;

    @Before
    public void setUp() throws Exception {
    }

    @Dado("que estou na tela de cadastro de email no gmail")
    public void que_estou_na_tela_de_cadastro_de_email_no_gmail() {
        cadastroPage = new CadastroPage(driverFactory.driver);
        cadastroPage.acesarTelaCadastroEmail();
    }

    @Quando("preencho os campos obrigatórios")
    public void preencho_os_campos_obrigatórios(){
        cadastroPage.preencheCadastro("Pablo","Vitar","Pablo9236429846","iPhone#10");
    }

    @Então("devo visualizar a caixa de email cadastrada")
    public void devo_visualizar_a_caixa_de_email_cadastrada() {
        Assert.assertTrue(cadastroPage.validaCadastro());
    }

    @After
    public void afterClass() throws Exception {

    }
}

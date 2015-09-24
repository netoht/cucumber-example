package cucumber.example.integration.step;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import cucumber.example.Application;
import cucumber.example.integration.selenium.WebBrowser;

@ContextConfiguration(classes = Application.class)
public class IntegrationStepdefs {

    private final WebBrowser browser = new WebBrowser();

    @Before
    public void before() {
        browser.start();
    }

    @Dado("^que o usuário esteja no site \"(.*?)\"$")
    public void que_o_usuário_esteja_no_site(String url) throws Throwable {
        browser.driver().get(url);
    }

    @Quando("^o usuário pesquisar sobre o modelo de carro \"(.*?)\"$")
    public void o_usuário_pesquisar_sobre_o_modelo_de_carro(String modelo_de_carro) throws Throwable {
        WebElement fieldSearch = browser.driver().findElement(By.id("gbqfq"));
        fieldSearch.clear();
        fieldSearch.sendKeys(modelo_de_carro);

        browser.driver().findElement(By.id("gbqfb")).click();
    }

    @Então("^a página com os resultados da pesquisa terá o título \"(.*?)\"$")
    public void a_página_com_os_resultados_da_pesquisa_terá_o_título(String titulo_pagina_pesquisa) throws Throwable {
        TimeUnit.SECONDS.sleep(1);
        assertEquals(titulo_pagina_pesquisa, browser.driver().getTitle());
    }

    @After
    public void after() {
        browser.stop();
    }
}

package ch.martinelli.demo.joinfacesdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexPageIT extends AbstractPageIT {

    @Test
    public void login() {
        webDriver.navigate().to("http://localhost:%d/index.faces".formatted(port));

        LoginPage loginPage = initElements(LoginPage.class);
        assertThat(webDriver.getTitle()).isEqualTo("Login");

        loginPage.login("user", "secret");

        IndexPage indexPage = initElements(IndexPage.class);
        indexPage.navigateTo();

        assertThat(indexPage.getTitle()).isEqualTo("Joinfaces Example");
        assertThat(indexPage.getHeading().getText()).isEqualTo("Hello, user");
    }

}

package ch.martinelli.demo.joinfacesdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexPageIT extends AbstractPageIT {

    @Test
    public void check_title_and_heading() {
        IndexPage indexPage = initElements(IndexPage.class);
        indexPage.navigateTo();

        assertThat(indexPage.getTitle()).isEqualTo("Joinfaces Example");

        assertThat(indexPage.getHeading().getText()).isEqualTo("JSF People Management");
    }

}

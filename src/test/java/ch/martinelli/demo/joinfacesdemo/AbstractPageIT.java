package ch.martinelli.demo.joinfacesdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.web.server.LocalServerPort;

public class AbstractPageIT {

    @LocalServerPort
    protected long port;

    protected static WebDriver webDriver;

    @BeforeAll
    public static void init() {
        webDriver = getChromeDriver();
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--window-size=1920,1080", "--ignore-certificate-errors", "--remote-allow-origins=*", "--disable-dev-shm-usage", "--no-sandbox");
        return new ChromeDriver(chromeOptions);
    }

    @AfterAll
    public static void finish() {
        webDriver.close();
    }

    protected <T extends AbstractPageComponent> T initElements(Class<T> classx) {
        T result = PageFactory.initElements(webDriver, classx);
        result.setPrefix(getPrefix());
        return result;
    }

    private String getPrefix() {
        return "http://localhost:" + port;
    }

}

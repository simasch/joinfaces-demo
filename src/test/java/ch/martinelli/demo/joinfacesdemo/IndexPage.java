package ch.martinelli.demo.joinfacesdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage extends AbstractPageComponent {

    @FindBy(id = "heading")
    private WebElement heading;

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getLocation() {
        return "index.faces";
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public WebElement getHeading() {
        return heading;
    }

    public IndexPage waitLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(heading));
        return this;
    }
}

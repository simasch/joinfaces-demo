package ch.martinelli.demo.joinfacesdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageComponent {

    protected final WebDriver webDriver;

    private String prefix;

    public AbstractPageComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public abstract String getLocation();

    public void navigateTo() {
        this.webDriver.navigate().to(this.prefix + "/" + getLocation());
    }

    public <T extends AbstractPageComponent> T initElements(Class<T> classx) {
        T result = PageFactory.initElements(this.webDriver, classx);
        result.setPrefix(this.prefix);
        return result;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

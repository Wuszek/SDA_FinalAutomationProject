package Steps;

import Base.BaseUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Hook {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() throws URISyntaxException {
        /*
            W tym miejscu należy podać ścieżkę do pliku *.exe z Chromedriver
            https://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/
         */
        URL driverLocalization = getClass().getClassLoader().getResource("chromedriver.exe");
        File file = Paths.get(driverLocalization.toURI()).toFile();
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        base.Driver = new ChromeDriver();
        base.Wait = new WebDriverWait(base.Driver, 5);
        base.Driver.manage().window().maximize();
        PageFactory.initElements(new AjaxElementLocatorFactory(base.Driver,5), base);
        base.Driver.get("http://automationpractice.com/index.php");

    }
    @After
    public void TearDownTests() {
        base.Driver.quit();
    }
}

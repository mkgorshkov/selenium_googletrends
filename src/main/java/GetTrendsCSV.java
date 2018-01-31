import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;
import java.util.Map;

public class GetTrendsCSV {
    public static void main(String[] args) {

        DesiredCapabilities caps = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "C:\\Users\\30149\\IdeaProjects\\googletrends\\src\\main\\resources");
        options.setExperimentalOption("prefs", prefs);
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\30149\\IdeaProjects\\googletrends\\src\\main\\resources\\chromedriver.exe");

        WebDriver Driver = new ChromeDriver(caps);
        Driver.navigate().to("https://trends.google.com/trends/explore?q=ethereum");

        WebElement getCSV = Driver.findElement(By.cssSelector("body > div.trends-wrapper > div:nth-child(2) > div > md-content > div > div > div:nth-child(1) > trends-widget > ng-include > widget > div > div > div > widget-actions > div > button.widget-actions-item.export"));
        getCSV.click();

        Driver.close();
        Driver.quit();
    }
}

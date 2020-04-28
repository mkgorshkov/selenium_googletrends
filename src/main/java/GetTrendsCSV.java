import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        prefs.put("download.default_directory", "/tmp");
        options.setExperimentalOption("prefs", prefs);
//        caps.setCapability(ChromeOptions.CAPABILITY, options);

        System.setProperty("webdriver.chrome.driver", "/home/indiemax/Code/selenium_googletrends/src/main/resources/chromedriver");


        WebDriver Driver = new ChromeDriver(options);
        Driver.navigate().to("https://trends.google.com/trends/");

        WebElement searchbox = Driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/ng-include/div/div[2]/autocomplete/md-autocomplete/md-autocomplete-wrap/input"));
        searchbox.sendKeys("ethereum");
        searchbox.sendKeys(Keys.ENTER);

        WebElement getCSV = Driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/md-content/div/div/div[1]/trends-widget/ng-include/widget/div/div/div/widget-actions/div/button[1]/i"));
        getCSV.click();

        Driver.close();
        Driver.quit();
    }
}

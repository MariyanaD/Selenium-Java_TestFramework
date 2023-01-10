package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;



public class Browser {
    public static WebDriver driver;

    /**
     * Open maximized Chrome browser instance and set implicit wait 10 seconds
     */
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mariyanad\\Documents\\Mimi's things\\Automation\\" +
                "chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /**
     * Quits the browser and all windows created of it
     */
    public static void quit() {
        driver.quit();
    }
}

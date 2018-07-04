package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
    
    public static WebDriver initWebDriver(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    
    public static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }
    
    public static int getRandomInteger(int range) {
        return (int) (Math.random() * range);
    }
    
    public static String getRandomText() {
        return "VladaTest-" + getRandomInteger();
    }

    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".rs");
    }

    public static WebDriver initWebDriver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

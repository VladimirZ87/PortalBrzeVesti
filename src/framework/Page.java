
package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Page extends AbstractPage {
    
    //PRIVATE waits
    
    public  WebElement waitForElementVisibility(By locator) {     
        return getWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public WebElement waitForElementVisibility(WebElement element) {
        return getWait(getDriver()).until(ExpectedConditions.visibilityOf(element));
    }
    
    private WebElement waitForElementClickability(By locator) {
        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(locator));        
    }

    private WebElement waitForElementClickability(WebElement element) {
        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
    //PUBLIC methods
    public void clickOnElement(By locator) {
        WebElement target = waitForElementClickability(locator);
        target.click();
    }

    public void clickOnElement(WebElement element) {
        WebElement target = waitForElementClickability(element);
        target.click();
    }
    
    public String sendTextOnField(By locator) {
        WebElement inputField = waitForElementVisibility(locator);
        inputField.clear();
        String text = Helper.getRandomText();
        inputField.sendKeys(text);
        return text;
    }
    
     public String sendTextOnField(WebElement inputField) {
        inputField.clear();
        String text = Helper.getRandomText();
        inputField.sendKeys(text);
        return text;
    }

    public void sendTextOnField(By locator, String text) {
        WebElement inputField = waitForElementVisibility(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }
    
    public void sendTextOnField(WebElement field, String text) {
        WebElement inputField = waitForElementVisibility(field);
        inputField.clear();
        inputField.sendKeys(text);
    }
    
}

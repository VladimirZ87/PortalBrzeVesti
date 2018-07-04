package pages;

import static framework.Configuration.adminPanelLogin;
import static framework.Configuration.adminPassword;
import static framework.Configuration.adminUsername;
import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Page {
    
    
    public DashboardPage login() {
        getDriver().get(adminPanelLogin);
        sendTextOnField(By.name("email"), adminUsername);
        sendTextOnField(By.name("password"), adminPassword);
        clickOnElement(By.className("btn-primary"));
        
        return PageFactory.initElements(getDriver(), DashboardPage.class);
    }
    
}

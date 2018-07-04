package regions;

import framework.Configuration;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegionsPage;

public class TestRegions {

    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static RegionsPage regionsPage;

    public static WebDriver driver;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login();
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.quitDriver();
    }

    @Before
    public void setUp() {
        regionsPage = dashboardPage.goToRegions();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNewRegion() {
        regionsPage.addNewRegion();
        System.out.println("Uspesno kreiran region!");
    }

    @Test
    public void testEditLastRegion() {
        regionsPage.editLastRegion();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals("Url's doesen't match!", expectedUrl, actualUrl);
        
        String expectedTitle = "Brze vesti admin  | Regions ".replaceAll("\\s+", " ").trim();
        String actualTitle = loginPage.getDriver().getTitle();
        Assert.assertEquals("Titles doesen't match", expectedTitle, actualTitle);
    }

    @Test
    public void testEditFirstRegion(){
        regionsPage.editFirstRegion();
    }
    
    @Test
    public void testEditRandomRegion(){
        regionsPage.editRandomRegion();
    }
    
    @Test
    public void testDeleteFirstRegion(){
        regionsPage.deleteFirstRegion();
    }
    
    @Test
    public void testDeleteLastRegion(){
        regionsPage.deleteLastRegion();
    }
    
    @Test
    public void testDeleteRandomRegion(){
        regionsPage.deleteRandomRegion();
    }
}

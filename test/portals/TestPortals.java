package portals;

import framework.Configuration;
import java.io.IOException;
import java.text.DateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;

public class TestPortals {

    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static PortalsPage portalPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login();
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.quitDriver();
    }

    @Before
    public void setUp() {
        portalPage = dashboardPage.goToPortals();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNewPortal() {
        portalPage.addNewPortal();
    }

    @Test
    public void testEditLastPortal() {

        portalPage.editLastPortal();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals("Url's doesn't match!!! ", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Portals ".replaceAll("\\s+", " ").trim();
        String actualTitle = loginPage.getDriver().getTitle();
        Assert.assertEquals("Titles doesn't match.", expectedTitle, actualTitle);
    }

    @Test
    public void testEditFirstPortal() {
        portalPage.editFirstPortal();
    }

    @Test
    public void testEditRandomPortal() {
        portalPage.editRandomPortal();
    }

    @Test
    public void testDeleteFirstPortal() {
        portalPage.deleteFirstPortal();
    }

    @Test
    public void testDeleteLastPortal() {
        portalPage.deleteLastPortal();
    }

    @Test
    public void testDeleteRandomPortal() {
        portalPage.deleteRandomPortal();
    }

    @Test
    public void testAddEditDeletePortal() {
        portalPage.addNewPortal();
        portalPage.editLastPortal();
        portalPage.deleteLastPortal();
    }
}

package categories;

import framework.Configuration;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;


public class TestCategories {
    
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static CategoriesPage categoriesPage;
    
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
        categoriesPage = dashboardPage.goToCategories();
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void testCreateNewCategory() {
         
         categoriesPage.addNewCategory();
         System.out.println("hello");
     }
     
     @Test
    public void testEditLastCategory() {

        categoriesPage.editLastCategory();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals("Url's doesn't match!!! ", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Categories ".replaceAll("\\s+", " ").trim();
        String actualTitle = loginPage.getDriver().getTitle();
        Assert.assertEquals("Titles doesn't match.", expectedTitle, actualTitle);

    }
    
    @Test
    public void testEditFirstCategory() {
        categoriesPage.editFirstCategory();
        
    }
    
    @Test
    public void testEditRandomCategory() {
        categoriesPage.editRandomCategory();
       
    }

    @Test
    public void testDeleteFirstCategory() {
        categoriesPage.deleteFirstCategory(); 
    }
    
    
    @Test
    public void testDeleteLastCategory() {
        categoriesPage.deleteLastCategory(); 
    }
    
    @Test
    public void testDeleteRandomCategory() {
        categoriesPage.deleteRandomCategory(); 
    }
    
    @Test 
    public void testAddEditDeleteCategory() {
        categoriesPage.addNewCategory();
        categoriesPage.editLastCategory();
        categoriesPage.deleteLastCategory();
    }
}

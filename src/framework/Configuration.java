
package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuration {
    
    public static String chromeDriverPath;
    
    public static String mainSiteUrl;
    public static String adminPanelLogin;
    public static String adminUsername;
    public static String adminPassword;
    
    public static String dbUrl;
    public static String dbUrlDriver;
    public static String dbHost;
    public static String dbPort;
    public static String dbUsername;
    public static String dbPassword;
    
    
    
    public static void init() throws FileNotFoundException, IOException {
        
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("configuration.properties");
        properties.load(fis);
        
        mainSiteUrl = properties.getProperty("mainSiteUrl");
        adminPanelLogin = properties.getProperty("adminPanelLogin");
        adminUsername = properties.getProperty("adminUsername");
        adminPassword = properties.getProperty("adminPassword");
        adminPanelLogin = properties.getProperty("adminPanelLogin");
        chromeDriverPath = properties.getProperty("chromeDriverPath");
        
        
//        dbUrl = properties.getProperty("dbUrl");
//        dbUrlDriver = properties.getProperty("dbUrlDriver");
//        dbHost = properties.getProperty("dbHost");
//        dbPort = properties.getProperty("dbPort");
//        dbUsername = properties.getProperty("dbUsername");
//        dbPassword = properties.getProperty("dbPassword");
       
        
    }
    
//    public static void init(){
//        Properties prop = new Properties();
//        try {
//            FileInputStream fis = new FileInputStream("configuration.properties");
//            prop.load(fis);
//            
//            adminPanelLogin = prop.getProperty("adminPanelLogin");
//            adminUsername = prop.getProperty("adminUsername");
//            adminPassword = prop.getProperty("adminPassword");
//            
//            chromeDriverPath = prop.getProperty("chromeDriverPath");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
}

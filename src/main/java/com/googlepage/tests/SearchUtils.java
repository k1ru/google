package com.googlepage.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SearchUtils {

    public static WebDriver setUpBrowser(String b) {
        String browser = b;
        WebDriver driver = null;
        System.out.println("Initiated setUpBrowser for browser: " + b);

        switch (browser.toLowerCase()) {
            case "chrome":
                try {
                    ChromeDriverManager.setup();
                    driver = new ChromeDriver();
                } catch (Exception e) {
                    System.out.println("setUpBrowser failed with: " + e);
                }
                break;
            case "firefox":
                try {
                    driver = new FirefoxDriver();
                } catch (Exception e) {
                    System.out.println("setUpBrowser failed with: " + e);
                }
                break;
            case "ie":
                try {
                    InternetExplorerDriverManager.setup();
                    driver = new InternetExplorerDriver();
                } catch (Exception e) {
                    System.out.println("setUpBrowser failed with: " + e);
                }
                break;
            default:
                System.out.println("Browser not supported, check testng.xml");
                break;
        }
        return driver;
    }
}

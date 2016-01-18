package com.googlepage.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.googlepage.tests.SearchUtils.setUpBrowser;

public class SearchTest {

    private WebDriver driver;
    private WebElement searchElement;
    private WebElement searchButton;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
        driver = setUpBrowser(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @Parameters("url")
    public void verifyPageTitle(String url) {
        System.out.println("Navigating to url: " + url);
        driver.get(url);
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Google"), "Current title is not Google");
    }

    @Test(dependsOnMethods = "verifyPageTitle", groups = "initGroup")
    public void verifyTextInputFieldExistence() {
        searchElement = driver.findElement(By.name("q"));
        Assert.assertTrue(searchElement != null, "TextInputField doesn't exist");
    }

    @Test(dependsOnMethods = "verifyPageTitle", groups = "initGroup")
    public void verifySearchButtonExistence() {
        searchButton = driver.findElement(By.name("btnK"));
        Assert.assertTrue(searchButton != null, "SearchButton doesn't exist");
    }

    @Test(dependsOnGroups = "initGroup")
    @Parameters("pattern")
    public void initiateSearch(String pattern) {
        System.out.println("Patter to be searched: " + pattern);
        searchElement.sendKeys(pattern);
        searchElement.submit();
        int count = driver.findElements(By.className("r")).size();
        System.out.println("Pattern: " + pattern + ", found:" + count + " times");
        Assert.assertTrue(count >= 1, "Pattern: " + pattern + " not found in results");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
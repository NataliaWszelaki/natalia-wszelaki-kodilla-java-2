package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_COOKIES = "//div[contains(@class, \"_al64\")]/button[2]";
    public static final String XPATH_NEW_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a[contains(@class, \"_6lti\")]";
    public static final String XPATH_DAY = "//select[@id='day']";
    public static final String XPATH_MONTH = "//select[@id='month']";
    public static final String XPATH_YEAR = "//select[@id='year']";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com");

        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_NEW_ACCOUNT)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select selectDay = new Select(driver.findElement(By.xpath(XPATH_DAY)));
        selectDay.selectByValue("11");
        Select selectMonth = new Select(driver.findElement(By.xpath(XPATH_MONTH)));
        selectMonth.selectByValue("11");
        Select selectYear = new Select(driver.findElement(By.xpath(XPATH_YEAR)));
        selectYear.selectByValue("2002");
    }
}

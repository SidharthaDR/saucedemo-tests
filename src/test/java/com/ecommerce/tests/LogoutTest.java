package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.example.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        new LoginPage(driver).login("standard_user", "secret_sauce");

        // Open side menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // Wait a bit or use explicit wait (recommended)
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        driver.findElement(By.id("logout_sidebar_link")).click();

        // Assert we're back on login page
        assert driver.getCurrentUrl().contains("saucedemo.com");
    }
}

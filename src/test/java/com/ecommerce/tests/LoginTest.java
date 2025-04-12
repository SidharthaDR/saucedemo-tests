package com.ecommerce.tests;

import org.example.LoginPage;
import org.example.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isTitleDisplayed(), "Login failed or Products page not displayed");
    }
}
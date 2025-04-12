package com.ecommerce.tests;

import org.example.LoginPage;
import org.example.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        new LoginPage(driver).login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addToCart();
        products.goToCart();

        boolean itemInCart = driver.getPageSource().contains("Sauce Labs Backpack");
        Assert.assertTrue(itemInCart, "Item not found in cart");
    }
}
package com.ecommerce.tests;

import org.example.*;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutFlow() {
        new LoginPage(driver).login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addToCart();
        products.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillCheckoutInfo("John", "Doe", "12345");
        checkout.finishCheckout();

        assert driver.getPageSource().contains("Thank you for your order!");
    }
}
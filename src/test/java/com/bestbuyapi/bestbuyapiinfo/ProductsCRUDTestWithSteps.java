/*
 * Created By: Hiren Patel
 * Project Name: BestBuyAPI-Serenity-Week-19
 */

package com.bestbuyapi.bestbuyapiinfo;

import com.bestbuyapi.bestbuyinfo.ProductsSteps;
import com.bestbuyapi.testbase.TestBaseProducts;
import com.bestbuyapi.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ProductsCRUDTestWithSteps extends TestBaseProducts {
    static String name = "Apple - MacBook Pro" + TestUtils.getRandomName();
    static String type = "Laptop" + TestUtils.getRandomName();
    static Double price = 1200.99;
    static Integer shipping = 10;
    static String upc = "012333424000";
    static String description = "Apple iMac 21.5 All-in-One" + TestUtils.getRandomValue();
    static String manufacturer = "Apple";
    static String model = TestUtils.getRandomName();
    static String url = "https://www.bestbuy.com/site/apple-macbook-pro-13-display-with-touch-bar-intel-core-i5-16gb-memory-512gb-ssd-space-gray/6287726.p?skuId=6287726";
    static String image = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6287/6287726_sd.jpg;maxHeight=640;maxWidth=550";
    static int productId;

    @Steps
    ProductsSteps productsSteps;

    @Title("This will create a new Product")
    @Test
    public void test001() {
        ValidatableResponse response = productsSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().statusCode(201);
    }

    @Title("Verify that Product was added to the application")
    @Test
    public void test002() {
        HashMap<String, Object> value = productsSteps.getProductInfoByName(name);
        Assert.assertThat(value, hasValue(name));
        productId = (int) value.get("id");
    }

    @Title("Update the Product information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated";
        productsSteps.updateProduct(productId, name, type, price, shipping, upc, description, manufacturer, model, url, image).log().all().statusCode(200);
        HashMap<String, Object> value = productsSteps.getProductInfoByName(name);
        Assert.assertThat(value, hasValue(name));
    }

    @Title("Delete the Product and verify if the Product is deleted!")
    @Test
    public void test004() {
        productsSteps.deleteProduct(productId).statusCode(200);
        productsSteps.getProductById(productId).statusCode(404);
    }

}

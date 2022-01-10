/*
 * Created By: Hiren Patel
 * Project Name: BestBuyAPI-Serenity-Week-19
 */

package com.bestbuyapi.testbase;

import com.bestbuyapi.constants.Path;
import com.bestbuyapi.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBaseProducts {

    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
        RestAssured.basePath = Path.PRODUCTS;
    }
}

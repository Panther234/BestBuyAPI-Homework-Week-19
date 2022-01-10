/*
 * Created By: Hiren Patel
 * Project Name: BestBuyAPI-Serenity-Week-19
 */

package com.bestbuyapi.constants;

public class EndPoints {
    /**
     * This Endpoints for PRODUCTS
     */
    public static final String GET_SINGLE_PRODUCT_BY_ID = "/{productID}";
    public static final String UPDATE_PRODUCT_BY_ID = "/{productID}";
    public static final String DELETE_PRODUCT_BY_ID = "/{productID}";

    /**
     * This Endpoints for STORES
     */
    public static final String GET_SINGLE_STORE_BY_ID = "/{storeID}";
    public static final String UPDATE_STORE_BY_ID = "/{storeID}";
    public static final String DELETE_STORE_BY_ID = "/{storeID}";

    /**
     * This Endpoints for CATEGORIES
     */
    public static final String GET_SINGLE_CATEGORY_BY_ID = "/{categoryID}";
    public static final String UPDATE_CATEGORY_BY_ID = "/{categoryID}";
    public static final String DELETE_CATEGORY_BY_ID = "/{categoryID}";

    /**
     * This Endpoints for SERVICES
     */
    public static final String GET_SINGLE_SERVICE_BY_ID = "/{serviceID}";
    public static final String UPDATE_SERVICE_BY_ID = "/{serviceID}";
    public static final String DELETE_SERVICE_BY_ID = "/{serviceID}";

}

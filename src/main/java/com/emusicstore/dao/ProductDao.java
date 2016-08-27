package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 7/23/2016.
 */

//DataBase Access Object
public class ProductDao {
    private List<Product> productList;

    public List<Product> getProductList(){
        Product product1 = new Product();
        product1.setProductName("Guitar");
        product1.setProductCategory("Instrument");
        product1.setProductCondition("new");
        product1.setProductDescription("This is a frender strat Guitar");
        product1.setProductPrice(1200.00);
        product1.setProductStatus("Active");
        product1.setUnitInStock(11);
        product1.setProductManufacturer("Fender");

        Product product2 = new Product();
        product2.setProductName("Record");
        product2.setProductCategory("Record");
        product2.setProductCondition("new");
        product2.setProductDescription("This is an awesome collection of 90s");
        product2.setProductPrice(25.00);
        product2.setProductStatus("Active");
        product2.setUnitInStock(51);
        product2.setProductManufacturer("EMI");

        Product product3 = new Product();
        product3.setProductName("Speaker");
        product3.setProductCategory("Accessory");
        product3.setProductCondition("new");
        product3.setProductDescription("This is a Polk Speaker");
        product3.setProductPrice(355.00);
        product3.setProductStatus("Active");
        product3.setUnitInStock(51);
        product3.setProductManufacturer("Polk");

        productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return  productList;
    }

    public Product getProductById(String productId) throws IOException {
        for(Product product: getProductList()) {
            if (product.getProductId().equals(productId))
                return product;
        }
        throw new IOException("No product found");
    }

}

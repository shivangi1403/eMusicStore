package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 7/21/2016.
 */
@Controller
public class HomeController {

    ProductDao productDao = new ProductDao();

    //MAPPING OF EVERY JSP FILE NEEDS TO BE DONE HERE IN CONTROLLER
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProduct(Model model){  //this model is attached to view automatically whenever we return string from this method
        List<Product> products = productDao.getProductList();
        model.addAttribute("products",products);  //bind the product to model being attached to view

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")    //productId -> PathVariable
    public String viewProduct(@PathVariable String productId, Model model) throws IOException{
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }
}

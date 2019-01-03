package com.RockAndRoll.controller;

import com.RockAndRoll.model.Product;
import com.RockAndRoll.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }
    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable("id") Integer id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "viewProduct";
    }
}

package com.vkoryakin.jparepository.Controllers;

import com.vkoryakin.jparepository.DTO.ProductDTO;
import com.vkoryakin.jparepository.Entity.Product;
import com.vkoryakin.jparepository.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductController {
    @Autowired
    ProductService productService;
@PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<ProductDTO>> sort() {
    return productService.getSortProducts();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDTO>> filter(@RequestParam double price) {
        return productService.getFilteredProduct(price);
    }
}

package com.vkoryakin.jparepository.Service;

import com.vkoryakin.jparepository.DTO.ProductDTO;
import com.vkoryakin.jparepository.Entity.Product;
import com.vkoryakin.jparepository.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<Product> addProduct(Product product) {
      return  ResponseEntity.ok( productRepository.save(product));
    }

    public ResponseEntity<List<ProductDTO>> getSortProducts() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll(Sort.by("price").and(Sort.by("name")));
        for (Product product : products) {

            productDTOs.add(new ProductDTO(product.getName(),product.getPrice(),product.getType()));
        }
        return ResponseEntity.ok(productDTOs);
    }

    public ResponseEntity<List<ProductDTO>> getFilteredProduct(double price) {
        List<ProductDTO> productDTOS = productRepository.filterProduct(price);
        return ResponseEntity.ok(productDTOS);

    }
}

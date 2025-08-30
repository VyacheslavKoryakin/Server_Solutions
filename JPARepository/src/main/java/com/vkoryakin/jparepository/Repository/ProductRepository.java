package com.vkoryakin.jparepository.Repository;

import com.vkoryakin.jparepository.DTO.ProductDTO;
import com.vkoryakin.jparepository.Entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAll(Sort and);


@Query(value = "SELECT new com.vkoryakin.jparepository.DTO.ProductDTO(p.name, p.price) from Product p where p.price >:price", nativeQuery = false)
List<ProductDTO> filterProduct(double price) ;





}
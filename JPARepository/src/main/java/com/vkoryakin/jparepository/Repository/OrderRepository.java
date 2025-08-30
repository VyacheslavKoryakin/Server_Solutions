package com.vkoryakin.jparepository.Repository;


import com.vkoryakin.jparepository.Entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> ,PagingAndSortingRepository<Orders, Long> {



}

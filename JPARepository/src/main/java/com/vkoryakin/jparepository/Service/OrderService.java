package com.vkoryakin.jparepository.Service;


import com.vkoryakin.jparepository.DTO.OrderDTO;
import com.vkoryakin.jparepository.Entity.Orders;
import com.vkoryakin.jparepository.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void create() {
        for (int i = 0; i < 20; i++) {
            Orders order1 = new Orders("processed"+i, LocalDateTime.now().toString(),"Or1V1 "+i);
            orderRepository.save(order1);
        }
    }

    public ResponseEntity< List<OrderDTO>> getAll() {
       Iterable<Orders> orders = orderRepository.findAll();
       List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
       for (Orders order : orders) {
           OrderDTO orderDTO = new OrderDTO(order.getStatus(),order.getDate(),order.getOrderNumber());
           orderDTOs.add(orderDTO);
       }

        return ResponseEntity.ok(orderDTOs);
    }

    public void deleteById(long id) {
       orderRepository.deleteById(id);
    }


    public ResponseEntity<?> pagination() {

        Pageable pageable = PageRequest.of(1,5, Sort.by("date"));
        Page<Orders> all = orderRepository.findAll(pageable);
        return ResponseEntity.ok(all);

    }
}

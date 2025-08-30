package com.vkoryakin.jparepository.Controllers;

import com.vkoryakin.jparepository.DTO.OrderDTO;
import com.vkoryakin.jparepository.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/create")
    public void create() {
        orderService.create();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDTO>> getAll() {
       return orderService.getAll();
    }

    @DeleteMapping("/del")
    public void deleteById(@RequestParam int id) {
        orderService.deleteById(id);
    }

    @GetMapping("/pag")
    public ResponseEntity<?> pagination() {
        return orderService.pagination();
    }
}

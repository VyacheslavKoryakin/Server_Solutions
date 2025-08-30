package com.vkoryakin.jparepository.Controllers;

import com.vkoryakin.jparepository.DTO.UserDTO;
import com.vkoryakin.jparepository.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        return userService.findAll();
    }
@GetMapping("/byEmail")
    public ResponseEntity<List<UserDTO>> findByEmail(@RequestParam String email) {
      return   userService.findByEmail(email);
    }
}

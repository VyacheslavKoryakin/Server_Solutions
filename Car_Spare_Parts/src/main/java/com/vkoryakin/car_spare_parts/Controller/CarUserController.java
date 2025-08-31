package com.vkoryakin.car_spare_parts.Controller;

import com.vkoryakin.car_spare_parts.DTO.CarUserDTO;
import com.vkoryakin.car_spare_parts.Service.CarUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cu")
public class CarUserController {
    @Autowired
    CarUserService carUserService;

    @GetMapping("/get")
    public ResponseEntity<List<CarUserDTO>> getAll(){
        return carUserService.getAll();
    }
}

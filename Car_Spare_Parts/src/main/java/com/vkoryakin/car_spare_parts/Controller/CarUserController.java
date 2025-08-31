package com.vkoryakin.car_spare_parts.Controller;

import com.vkoryakin.car_spare_parts.DTO.CarUserDTO;
import com.vkoryakin.car_spare_parts.Service.CarUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cu")
public class CarUserController {
    @Autowired
    CarUserService carUserService;

    @GetMapping("/get")
    public ResponseEntity<List<CarUserDTO>> getAll(){
        return carUserService.getAll();
    }

    @GetMapping("/list")
    public String showCarUsers(Model model) {
        List<CarUserDTO> carsUserDTO= carUserService.getAll().getBody(); // получаем список
        model.addAttribute("carsUserDTO", carsUserDTO);

        return "car_users"; // имя шаблона без расширения
    }


    @GetMapping("/getByName")
    public String showCarUsers(@RequestParam String carModel, Model model) {
        List<CarUserDTO> carsForFilter= carUserService.getAll().getBody(); // получаем список
        List<CarUserDTO> carsUserDTO= carsForFilter.stream().filter(c->c.getCar().equals(carModel)).toList();
        model.addAttribute("carsUserDTO", carsUserDTO);
        return "car_users"; // имя шаблона без расширения
    }
}

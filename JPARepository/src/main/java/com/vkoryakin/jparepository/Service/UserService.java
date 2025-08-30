package com.vkoryakin.jparepository.Service;

import com.github.javafaker.Faker;
import com.vkoryakin.jparepository.DTO.UserDTO;
import com.vkoryakin.jparepository.Entity.Users;
import com.vkoryakin.jparepository.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Faker faker = new Faker();

    private void saveUser() {
        for (int i = 0; i < 20; i++) {
            userRepository.save(new Users(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress()));

        }
    }


    public ResponseEntity<List<UserDTO>>findAll(){
        if(userRepository.findAll().isEmpty()){
            saveUser();
        }

        List<UserDTO> userDTOs = new ArrayList<>();
        List<Users> all = userRepository.findAll();
        for (Users user : all) {
            userDTOs.add(new UserDTO(user.getName(), user.getEmail()));
        }
        return ResponseEntity.ok(userDTOs);
    }

    public ResponseEntity<List<UserDTO>> findByEmail(String email){
        List<UserDTO> userDTOs = new ArrayList<>();
        List<Users> byEmail = userRepository.findByEmail(email);
        for(Users user : byEmail){
            userDTOs.add(new UserDTO(user.getName(),user.getSecondName(), user.getEmail()));
        }
        return ResponseEntity.ok(userDTOs);
    }
}

package com.vkoryakin.jparepository.Repository;

import com.vkoryakin.jparepository.Entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value="Select *  from Users  where email LIKE %:email% ", nativeQuery=true)
   List<Users> findByEmail(String email);

}

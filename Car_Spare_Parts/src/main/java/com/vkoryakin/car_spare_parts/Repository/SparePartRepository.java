package com.vkoryakin.car_spare_parts.Repository;

import com.vkoryakin.car_spare_parts.Entity.SpareParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepository extends JpaRepository<SpareParts, Long> {}
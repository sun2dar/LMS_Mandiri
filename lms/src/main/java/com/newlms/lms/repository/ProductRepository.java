package com.newlms.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newlms.lms.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

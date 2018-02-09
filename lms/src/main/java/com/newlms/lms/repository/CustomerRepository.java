package com.newlms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newlms.lms.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.module.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}

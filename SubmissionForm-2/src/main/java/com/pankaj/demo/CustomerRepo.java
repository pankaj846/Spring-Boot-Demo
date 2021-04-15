package com.pankaj.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends JpaRepository<Customers, Integer> {
// this interface is responsible to work with the customer class and the primary key will be the integer i.e customer ID

}

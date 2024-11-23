package com.iitpos.pos.repo;

import com.iitpos.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

//we cannot implent one interface to another interface, therefore we extends them
@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByActiveStateEquals(boolean state);
}

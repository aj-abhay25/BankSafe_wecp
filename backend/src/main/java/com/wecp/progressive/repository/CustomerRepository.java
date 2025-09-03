package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer>  {
    @Query("select c from Customers c where c.customerId = ?1")
    Customers findByCustomerId(int customerId);
    @Query("delete from Customers c where c.customerId = ?1")
    void deleteByCustomerId(int customerId);

    Customers findByNameAndEmail(@Param("name") String name, @Param("email") String email);
}
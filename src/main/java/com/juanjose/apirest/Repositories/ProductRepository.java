package com.juanjose.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanjose.apirest.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

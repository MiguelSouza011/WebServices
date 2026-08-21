package com.miguelsouza.webservices.repositories;


import com.miguelsouza.webservices.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

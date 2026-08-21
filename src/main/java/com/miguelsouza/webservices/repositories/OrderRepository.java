package com.miguelsouza.webservices.repositories;

import com.miguelsouza.webservices.entities.Order;
import com.miguelsouza.webservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

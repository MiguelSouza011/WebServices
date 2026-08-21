package com.miguelsouza.webservices.repositories;

import com.miguelsouza.webservices.entities.Category;
import com.miguelsouza.webservices.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long> {
}

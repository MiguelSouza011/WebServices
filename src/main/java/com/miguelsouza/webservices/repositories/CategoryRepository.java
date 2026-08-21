package com.miguelsouza.webservices.repositories;

import com.miguelsouza.webservices.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

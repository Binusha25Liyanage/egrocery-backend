package com.egrocery_remasterd.egrocery_backend.repository;

import com.egrocery_remasterd.egrocery_backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

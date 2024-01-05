package com.example.app.PilotProject.service;


import com.example.app.PilotProject.entity.Product;
import com.example.app.PilotProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Optional<List<Product>> findProducts (String value){
        List<Product> searchResult = repository.findByNameContaining(value);
        return Optional.ofNullable(searchResult);
    }

    public List<Product> searchProducts(String categoryName){
        return repository.findByCategoryName(categoryName);

    }

}

package com.practice.springjdbc.controller;

import com.practice.springjdbc.dao.ProductDao;
import com.practice.springjdbc.model.Product;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;

    @GetMapping
    public List<Product> findAll() {
        return productDao.findAll();
    }
@GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productDao.findById(id);
    }
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productDao.create(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productDao.update(product);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDyId(@PathVariable int id) {
        productDao.deleteById(id);
    }



}

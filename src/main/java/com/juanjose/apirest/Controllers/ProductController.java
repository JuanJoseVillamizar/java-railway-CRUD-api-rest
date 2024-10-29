package com.juanjose.apirest.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.juanjose.apirest.Repositories.ProductRepository;
import com.juanjose.apirest.Entities.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("id not found" + id));
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("update/{id}")
    public Product UpdateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product productoByid = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("id not found" + id));

        productoByid.setName(product.getName());
        productoByid.setPrice(product.getPrice());

        return productRepository.save(productoByid);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product productoByid = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("id not found" + id));
        productRepository.delete(productoByid);

        return "Id producto:"+ id +"Deleted Successfully";
    }
    

}

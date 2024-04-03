package com.resturent.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public Products addProduct(@RequestBody Products product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable int id, @RequestBody Products product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}

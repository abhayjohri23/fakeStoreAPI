package com.fakeStore.springBootBE.Controllers;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("all")
    public String getAllProducts(){
        return "GetAllProducts API is called from the productController class";
    }

    @PostMapping("add")
    public String createProduct(){
        return "createProduct API is called";
    }

    @GetMapping("{id}")
    public String getProductByID(@PathVariable("id") Long productID){
        return "getProductByID is called with id: "+ productID;
    }
    @DeleteMapping("{id}")
    public String deleteProductByID(@PathVariable("id") Long productID){
        return "deleted the product with product ID: "+productID;
    }
    @PostMapping("{id}")
    public String updateProductByID(@PathVariable("id") Long productID){
        return "updated the product by ID: "+ productID;
    }
}

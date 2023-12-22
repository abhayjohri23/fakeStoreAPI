package com.fakeStore.springBootBE.Controllers;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenericProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public GenericProductDTO createProduct(@PathVariable Long productID){
        return productService.createProduct(productID);
    }

}

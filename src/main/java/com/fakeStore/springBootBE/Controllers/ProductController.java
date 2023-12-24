package com.fakeStore.springBootBE.Controllers;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Models.Product;
import com.fakeStore.springBootBE.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private final ProductService productService;
    public ProductController(@Qualifier(value = "FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("all")
    public List<GenericProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("add")
    public GenericProductDTO createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductByID(@PathVariable("id") Long productID){
        return productService.getProductByID(productID);
    }
    @DeleteMapping("{id}")
    public GenericProductDTO deleteProductByID(@PathVariable("id") Long productID){
        return productService.deleteProductByID(productID);
    }
    @PostMapping("{id}")
    public GenericProductDTO updateProductByID(@PathVariable("id") Long productID,@RequestBody FakeStoreProductDTO product){
        return productService.updateProductByID(product,productID);
    }
}

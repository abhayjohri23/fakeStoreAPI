package com.fakeStore.springBootBE.Controllers;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import com.fakeStore.springBootBE.Models.Product;
import com.fakeStore.springBootBE.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private final ProductService productService;
    public ProductController(@Qualifier(value = "FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("all")
    public String getAllProducts(){
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
    public String deleteProductByID(@PathVariable("id") Long productID){
        return productService.deleteProductByID(productID);
    }
    @PostMapping("{id}")
    public String updateProductByID(@PathVariable("id") Long productID){
        return productService.updateProductByID(productID);
    }
}

package com.fakeStore.springBootBE.Services;
import com.fakeStore.springBootBE.DTOs.FakeStoreProductDTO;
import com.fakeStore.springBootBE.DTOs.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;
    private String getAllProductRequestURL = "https://fakestoreapi.com/products";
    private String getProductRequestURL = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestURL = "https://fakestoreapi.com/products/{id}";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public String getAllProducts() {
        return "All products are displayed";
    }

    @Override
    public String getProductByID(Long productID) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        return "Product with ID: "+productID+" is displayed";
    }

    @Override
    public String createProduct() {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        return "Product created in this service";
    }

    @Override
    public String deleteProductByID(Long productID) {
        return "Product with ID: "+ productID+"is deleted";
    }
    @Override
    public String updateProductByID(Long productID){
        return "Product with productID: "+productID+"is updated";
    }
}
